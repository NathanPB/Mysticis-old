package cf.nathanpb.mysticis.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber
public interface IProxy {

    void registerItemRender(Item item, int meta, String id);

    void onPreInit(FMLPreInitializationEvent e);
    void onInit(FMLInitializationEvent e);
    void onPostInit(FMLPostInitializationEvent e);
}
