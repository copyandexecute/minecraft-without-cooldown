package gg.norisk.mixin;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class AbstractFurnaceBlockEntityMixin {
    @Inject(method = "getCookTime", at = @At("RETURN"), cancellable = true)
    private static void injected(World world, AbstractFurnaceBlockEntity abstractFurnaceBlockEntity, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(1);
    }
}
