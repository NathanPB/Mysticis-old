package cf.nathanpb.mysticis.proxy;

import cf.nathanpb.mysticis.Mysticis;
import cf.nathanpb.mysticis.packets.ManaUpdatePacket;
import cf.nathanpb.mysticis.packets.handler.ManaUpdatePacketHandler;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void registerItemRender(Item item, int meta, String id){

    }

    public void onPreInit(FMLPreInitializationEvent e) {

    }

    public void onInit(FMLInitializationEvent e) {
        int id = 0;
        Mysticis.NETWORK_WRAPPER.registerMessage(ManaUpdatePacketHandler.class, ManaUpdatePacket.class, id++, Side.CLIENT);
    }

    public void onPostInit(FMLPostInitializationEvent e){

    }
}
