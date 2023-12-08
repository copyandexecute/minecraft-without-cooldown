package gg.norisk.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PassiveEntity.class)
public abstract class PassiveEntityMixin extends Entity {
    public PassiveEntityMixin(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    @ModifyVariable(method = "setBreedingAge", at = @At("HEAD"), argsOnly = true)
    private int injected(int y) {
        return 0;
    }
}
