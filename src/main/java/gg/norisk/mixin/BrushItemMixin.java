package gg.norisk.mixin;

import net.minecraft.item.BrushItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BrushItem.class)
public abstract class BrushItemMixin extends Item {
    public BrushItemMixin(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack itemStack) {
        return 1;
    }
}

