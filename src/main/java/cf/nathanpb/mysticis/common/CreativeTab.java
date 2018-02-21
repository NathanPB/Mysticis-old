package cf.nathanpb.mysticis.common;

import cf.nathanpb.mysticis.common.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs{
    public CreativeTab(){
        super(Mysticis.NAME);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.MYSTICIS);
    }
}
