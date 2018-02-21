package cf.nathanpb.mysticis.common.item;

import cf.nathanpb.mysticis.common.CreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModItems {

    public static final CreativeTab CREATIVE_TAB = new CreativeTab();
    public static final ItemBase MYSTICIS = new ItemMysticis().setCreativeTab(CreativeTabs.MISC);

    public static void register(IForgeRegistry<Item> registry){
        List<ItemBase> items = getItems();
        registry.registerAll(items.toArray(new Item[items.size()]));
    }

    public static void registerModels() {
        getItems().forEach(ItemBase::registryModel);
    }

    public static List<ItemBase> getItems(){
        return Stream.of(ModItems.class.getFields())
                .filter(f -> ItemBase.class.isAssignableFrom(f.getType()))
                .map(f ->{
                    try{
                        return (ItemBase) f.get(null);
                    }catch (Exception ex){}
                    return null;
                })
                .collect(Collectors.toList());
    }
}
