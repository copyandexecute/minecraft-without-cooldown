package gg.norisk.mixin;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.BlazeEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlazeEntity.ShootFireballGoal.class)
public abstract class ShootFireballGoalMixin extends Goal {
    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/mob/BlazeEntity$ShootFireballGoal;fireballCooldown:I", opcode = Opcodes.PUTFIELD))
    private void injected(BlazeEntity.ShootFireballGoal instance, int value) {
        instance.fireballCooldown = 0;
    }
}
