package gg.norisk.mixin;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WaterFluid.class)
public abstract class WaterFluidMixin extends FlowableFluid {
    @Override
    public int getTickRate(WorldView worldView) {
        return 1;
    }
}
