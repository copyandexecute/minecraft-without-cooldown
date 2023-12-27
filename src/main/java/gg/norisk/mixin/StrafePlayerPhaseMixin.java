package gg.norisk.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.AbstractPhase;
import net.minecraft.entity.boss.dragon.phase.StrafePlayerPhase;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StrafePlayerPhase.class)
public abstract class StrafePlayerPhaseMixin extends AbstractPhase {
    @Shadow private @Nullable LivingEntity target;

    public StrafePlayerPhaseMixin(EnderDragonEntity enderDragonEntity) {
        super(enderDragonEntity);
    }

    @Inject(method = "serverTick", at = @At("HEAD"))
    private void injected(CallbackInfo ci) {
        if (target != null) {
            Vec3d vec3d3 = this.dragon.getRotationVec(1.0F);
            double l = this.dragon.head.getX() - vec3d3.x * 1.0;
            double m = this.dragon.head.getBodyY(0.5) + 0.5;
            double n = this.dragon.head.getZ() - vec3d3.z * 1.0;
            double o = this.target.getX() - l;
            double p = this.target.getBodyY(0.5) - m;
            double q = this.target.getZ() - n;
            if (!this.dragon.isSilent()) {
                this.dragon.getWorld().syncWorldEvent(null, 1017, this.dragon.getBlockPos(), 0);
            }

            DragonFireballEntity dragonFireballEntity = new DragonFireballEntity(this.dragon.getWorld(), this.dragon, o, p, q);
            dragonFireballEntity.refreshPositionAndAngles(l, m, n, 0.0F, 0.0F);
            this.dragon.getWorld().spawnEntity(dragonFireballEntity);
        }
    }
}
