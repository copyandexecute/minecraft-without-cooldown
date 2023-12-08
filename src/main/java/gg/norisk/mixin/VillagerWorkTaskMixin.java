package gg.norisk.mixin;

import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.MultiTickTask;
import net.minecraft.entity.ai.brain.task.VillagerWorkTask;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.GlobalPos;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Map;

@Mixin(VillagerWorkTask.class)
public abstract class VillagerWorkTaskMixin extends MultiTickTask<VillagerEntity> {
    public VillagerWorkTaskMixin(Map<MemoryModuleType<?>, MemoryModuleState> map) {
        super(map);
    }

    public boolean shouldRun(ServerWorld serverWorld, VillagerEntity villagerEntity) {
        GlobalPos globalPos = villagerEntity.getBrain().getOptionalRegisteredMemory(MemoryModuleType.JOB_SITE).get();
        return globalPos.getDimension() == serverWorld.getRegistryKey() && globalPos.getPos().isWithinDistance(villagerEntity.getPos(), 1.73);
    }
}
