package gg.norisk.mixin;

import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.item.Vanishable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CrossbowItem.class)
public abstract class CrossBowItemMixin extends RangedWeaponItem implements Vanishable {
    public CrossBowItemMixin(Settings settings) {
        super(settings);
    }

    @ModifyConstant(method = "onStoppedUsing", constant = @Constant(floatValue = 1f, ordinal = 0))
    private float onStoppedUsing(float constant) {
        return -1;
    }

    @Redirect(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/CrossbowItem;getPullProgress(ILnet/minecraft/item/ItemStack;)F"))
    private float injected(int i, ItemStack itemStack) {
        return 1.0f;
    }

    @Override
    public int getMaxUseTime(ItemStack itemStack) {
        return 1;
    }
}
