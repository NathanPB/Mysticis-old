package cf.nathanpb.mysticis.item;

import cf.nathanpb.mysticis.Mysticis;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item{
    protected String name;

    public ItemBase(String name){
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registryModel(){
        Mysticis.proxy.registerItemRender(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
