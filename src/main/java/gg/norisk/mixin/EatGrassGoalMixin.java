package gg.norisk.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Predicate;

@Mixin(EatGrassGoal.class)
public abstract class EatGrassGoalMixin extends Goal {
    @Shadow @Final private MobEntity mob;

    @Shadow @Final private static Predicate<BlockState> GRASS_PREDICATE;

    @Shadow @Final private World world;

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/goal/EatGrassGoal;getTickCount(I)I"))
    private int getTickCountMixin(EatGrassGoal instance, int i) {
        return instance.getTimer();
    }

    @Override
    public boolean canStart() {
        BlockPos blockPos = this.mob.getBlockPos();
        if (GRASS_PREDICATE.test(this.world.getBlockState(blockPos))) {
            return true;
        } else {
            return this.world.getBlockState(blockPos.down()).isOf(Blocks.GRASS_BLOCK);
        }
    }
}
