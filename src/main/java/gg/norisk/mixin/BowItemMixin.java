package gg.norisk.mixin;

import net.minecraft.item.BowItem;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.item.Vanishable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BowItem.class)
public abstract class BowItemMixin extends RangedWeaponItem implements Vanishable {
    public BowItemMixin(Settings settings) {
        super(settings);
    }

    @ModifyConstant(method = "onStoppedUsing", constant = @Constant(doubleValue = 0.1))
    private double onStoppedUsing(double constant) {
        return -1;
    }

    @Redirect(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/BowItem;getPullProgress(I)F"))
    private float injected(int i) {
        return 1.0f;
    }
}
