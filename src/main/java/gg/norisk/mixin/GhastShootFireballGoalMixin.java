package gg.norisk.mixin;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.GhastEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(GhastEntity.ShootFireballGoal.class)
public abstract class GhastShootFireballGoalMixin extends Goal {
    @Shadow
    public int cooldown;

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 10, ordinal = 0))
    private int injected(int value) {
        return this.cooldown;
    }

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 20, ordinal = 0))
    private int injected3(int value) {
        return this.cooldown;
    }

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 10, ordinal = 1))
    private int injected2(int value) {
        return this.cooldown - 1;
    }
}
