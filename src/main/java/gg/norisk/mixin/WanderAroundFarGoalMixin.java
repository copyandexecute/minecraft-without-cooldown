package gg.norisk.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.FuzzyTargeting;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WanderAroundFarGoal.class)
public abstract class WanderAroundFarGoalMixin extends WanderAroundGoal {
    public WanderAroundFarGoalMixin(PathAwareEntity pathAwareEntity, double d) {
        super(pathAwareEntity, d);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.mob instanceof SheepEntity sheepEntity) {
            var world = this.mob.getWorld();
            BlockPos blockPos = this.mob.getBlockPos();
            if (BlockStatePredicate.forBlock(Blocks.GRASS).test(world.getBlockState(blockPos))) {
                if (world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                    world.breakBlock(blockPos, false);
                }

                this.mob.onEatingGrass();
            } else {
                BlockPos blockPos2 = blockPos.down();
                if (world.getBlockState(blockPos2).isOf(Blocks.GRASS_BLOCK)) {
                    if (world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                        world.syncWorldEvent(2001, blockPos2, Block.getRawIdFromState(Blocks.GRASS_BLOCK.getDefaultState()));
                        world.setBlockState(blockPos2, Blocks.DIRT.getDefaultState(), 2);
                    }

                    this.mob.onEatingGrass();
                }
            }
        }
    }

    @Inject(method = "getWanderTarget", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfoReturnable<Vec3d> cir) {
        if (this.mob instanceof SheepEntity sheepEntity) {
            cir.setReturnValue(FuzzyTargeting.find(this.mob, 30, 20));
        }
    }
}
