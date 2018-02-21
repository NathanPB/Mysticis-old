package cf.nathanpb.mysticis.proxy;

import cf.nathanpb.mysticis.data.AffinityData;
import cf.nathanpb.mysticis.listener.MysticisDataListener;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy implements IProxy {

    @Override
    public void registerItemRender(Item item, int meta, String id) { }

    @Override
    public void onPreInit(FMLPreInitializationEvent e) {
    }

    @Override
    public void onInit(FMLInitializationEvent e) {
        new MysticisDataListener();
        MinecraftForge.EVENT_BUS.register(MysticisDataListener.class);
        MinecraftForge.EVENT_BUS.register(AffinityData.Factory.class);

    }

    @Override
    public void onPostInit(FMLPostInitializationEvent e) {

    }
}
