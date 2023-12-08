package gg.norisk.mixin;

import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.Goal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AnimalMateGoal.class)
public abstract class AnimalMateGoalMixin extends Goal {
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/goal/AnimalMateGoal;getTickCount(I)I"))
    private int injected(AnimalMateGoal instance, int i) {
        return 0;
    }
}
