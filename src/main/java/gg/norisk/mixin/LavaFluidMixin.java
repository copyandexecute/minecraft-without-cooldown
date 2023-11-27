package gg.norisk.mixin;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LavaFluid.class)
public abstract class LavaFluidMixin extends FlowableFluid {
    @Override
    public int getTickRate(WorldView worldView) {
        return 1;
    }
}
