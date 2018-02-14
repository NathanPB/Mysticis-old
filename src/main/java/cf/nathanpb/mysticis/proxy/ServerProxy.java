package cf.nathanpb.mysticis.proxy;

import cf.nathanpb.mysticis.listener.ManaListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy{
    @Override
    public void onPreInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(ManaListener.class);
    }

    @Override
    public void onInit(FMLInitializationEvent e) {
        super.onInit(e);
    }

    @Override
    public void onPostInit(FMLPostInitializationEvent e) {
        super.onPostInit(e);
    }
}
