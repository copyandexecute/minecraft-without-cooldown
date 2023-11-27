package gg.norisk.mixin;

import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.BowAttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.HostileEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BowAttackGoal.class)
public abstract class BowAttackGoalMixin<T extends HostileEntity & RangedAttackMob> extends Goal {
    @Shadow
    private int cooldown;

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 20, ordinal = 2))
    private int getItemUseTime(int constant) {
        return 0;
    }

    @Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/ai/goal/BowAttackGoal;cooldown:I", opcode = Opcodes.PUTFIELD, ordinal = 0))
    private void cooldown(BowAttackGoal<T> instance, int value) {
        this.cooldown = 0;
    }
}
