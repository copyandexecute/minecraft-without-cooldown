package gg.norisk.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.item.Vanishable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TridentItem.class)
public abstract class TridentItemMixin extends Item implements Vanishable {
    public TridentItemMixin(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack itemStack) {
        return 0;
    }
}

