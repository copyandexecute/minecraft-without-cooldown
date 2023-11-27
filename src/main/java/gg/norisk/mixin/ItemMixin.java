package gg.norisk.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {
    @Inject(method = "getMaxUseTime", at = @At("RETURN"), cancellable = true)
    private void injected(ItemStack itemStack, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(1);
    }
}
