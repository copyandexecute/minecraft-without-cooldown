package gg.norisk.mixin;

import net.minecraft.world.MobSpawnerLogic;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobSpawnerLogic.class)
public abstract class MobSpawnerLogicMixin {
    @Shadow private int spawnDelay;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injected(CallbackInfo ci) {
        this.spawnDelay = -1;
    }

    @Redirect(method = "updateSpawns", at = @At(value = "FIELD", target = "Lnet/minecraft/world/MobSpawnerLogic;spawnDelay:I", opcode = Opcodes.PUTFIELD))
    private void injected(MobSpawnerLogic instance, int value) {
       spawnDelay = -1;
    }
}

