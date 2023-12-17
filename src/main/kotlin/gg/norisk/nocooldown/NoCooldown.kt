package gg.norisk.nocooldown

import gg.norisk.PlayerBlockPlaceEvents
import net.fabricmc.api.ModInitializer
import net.minecraft.block.Fertilizable
import net.minecraft.server.world.ServerWorld
import net.silkmc.silk.core.task.mcCoroutineTask

object NoCooldown : ModInitializer {

    override fun onInitialize() {
        PlayerBlockPlaceEvents.AFTER.register(PlayerBlockPlaceEvents.After { world, player, blockPos, blockState, blockEntity ->
            if (!world.isClient) {
                val fertilizable = blockState.block as? Fertilizable ?: return@After
                mcCoroutineTask(howOften = 20) {
                    fertilizable.grow(world as ServerWorld?, world.random, blockPos, world.getBlockState(blockPos))
                }
            }
        })
    }
}
