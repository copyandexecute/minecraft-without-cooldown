package gg.norisk.mixin;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.AbstractPhase;
import net.minecraft.entity.boss.dragon.phase.StrafePlayerPhase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(StrafePlayerPhase.class)
public abstract class StrafePlayerPhaseMixin extends AbstractPhase {
    public StrafePlayerPhaseMixin(EnderDragonEntity enderDragonEntity) {
        super(enderDragonEntity);
    }

    @ModifyConstant(method = "serverTick", constant = @Constant(intValue = 5))
    private int injected(int value) {
        return -1;
    }
}
