package gg.norisk.mixin;

import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Item;
import net.minecraft.item.Vanishable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(FishingRodItem.class)
public abstract class FishingRodItemMixin extends Item implements Vanishable {
    public FishingRodItemMixin(Settings settings) {
        super(settings);
    }

    @ModifyArg(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/FishingBobberEntity;<init>(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/World;II)V"), index = 3)
    private int injected(int x) {
        return 5;
    }
}
