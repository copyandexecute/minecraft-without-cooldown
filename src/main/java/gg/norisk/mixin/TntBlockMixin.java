package gg.norisk.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.TntBlock;
import net.minecraft.entity.TntEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TntBlock.class)
public abstract class TntBlockMixin extends Block {
    public TntBlockMixin(Settings settings) {
        super(settings);
    }

    public void onDestroyedByExplosion(World world, BlockPos blockPos, Explosion explosion) {
        if (!world.isClient) {
            TntEntity tntEntity = new TntEntity(world, (double) blockPos.getX() + 0.5, (double) blockPos.getY(), (double) blockPos.getZ() + 0.5, explosion.getCausingEntity());
            tntEntity.setFuse(1);
            world.spawnEntity(tntEntity);
        }
    }
}
