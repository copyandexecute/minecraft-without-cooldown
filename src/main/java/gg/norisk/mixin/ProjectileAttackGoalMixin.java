package gg.norisk.mixin;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ProjectileAttackGoal.class)
public abstract class ProjectileAttackGoalMixin extends Goal {
    @Shadow
    private int updateCountdownTicks;
    
    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/ai/goal/ProjectileAttackGoal;updateCountdownTicks:I", opcode = Opcodes.PUTFIELD, ordinal = 1))
    private void injected(ProjectileAttackGoal instance, int value) {
        updateCountdownTicks = 1;
    }

    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/ai/goal/ProjectileAttackGoal;updateCountdownTicks:I", opcode = Opcodes.PUTFIELD, ordinal = 2))
    private void injected2(ProjectileAttackGoal instance, int value) {
        updateCountdownTicks = 1;
    }
}
