package gg.norisk.mixin;

import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable {
    public LivingEntityMixin(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    @ModifyConstant(method = "damage", constant = @Constant(floatValue = 10.0f, ordinal = 0))
    private float timeUntilRegen(float constant) {
        return 0f;
    }

    @ModifyConstant(method = "damage", constant = @Constant(intValue = 20, ordinal = 0))
    private int timeUntilRegen2(int constant) {
        return 0;
    }
}
