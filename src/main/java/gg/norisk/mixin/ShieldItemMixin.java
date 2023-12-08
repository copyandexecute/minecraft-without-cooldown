package gg.norisk.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ShieldItem.class)
public abstract class ShieldItemMixin extends Item {
    public ShieldItemMixin(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack itemStack) {
        return 1;
    }
}
