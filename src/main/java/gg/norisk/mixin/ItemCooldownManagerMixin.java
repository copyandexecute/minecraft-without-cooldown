package gg.norisk.mixin;

import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemCooldownManager.class)
public abstract class ItemCooldownManagerMixin {
    @Inject(method = "isCoolingDown", at = @At("RETURN"), cancellable = true)
    private void injected(Item item, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
