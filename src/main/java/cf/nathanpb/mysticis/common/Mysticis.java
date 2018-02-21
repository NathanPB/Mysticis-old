package cf.nathanpb.mysticis.common;

import cf.nathanpb.mysticis.common.data.MysticisConfig;
import cf.nathanpb.mysticis.common.item.ModItems;
import cf.nathanpb.mysticis.common.packets.AffinityUpdatePacket;
import cf.nathanpb.mysticis.common.packets.LevelUpdatePacket;
import cf.nathanpb.mysticis.common.packets.ManaUpdatePacket;
import cf.nathanpb.mysticis.proxy.IProxy;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;


@Mod(modid = Mysticis.ID,  name = Mysticis.NAME, version = Mysticis.VERSION)
public class Mysticis {
    public static final String ID = "mysticis";
    public static final String NAME = "Mysticis";
    public static final String VERSION = "1.0.0";
    public static final SimpleNetworkWrapper NETWORK_WRAPPER = NetworkRegistry.INSTANCE.newSimpleChannel(Mysticis.ID);
    public static final MysticisConfig configuration = new MysticisConfig();

    @SidedProxy(
            modId = Mysticis.ID,
            clientSide = "cf.nathanpb.mysticis.common.proxy.ClientProxy",
            serverSide = "cf.nathanpb.mysticis.common.proxy.ServerProxy"
    )
    public static IProxy proxy;


    @Mod.EventHandler
    public static void onPreInit(FMLPreInitializationEvent e){
        proxy.onPreInit(e);
    }

    @Mod.EventHandler
    public static void onInit(FMLInitializationEvent e){
        proxy.onInit(e);
        int id = 0;
        NETWORK_WRAPPER.registerMessage(ManaUpdatePacket.Handler.class, ManaUpdatePacket.class, id++, Side.CLIENT);
        NETWORK_WRAPPER.registerMessage(AffinityUpdatePacket.Handler.class, AffinityUpdatePacket.class, id++, Side.CLIENT);
        NETWORK_WRAPPER.registerMessage(LevelUpdatePacket.Handler.class, LevelUpdatePacket.class, id++, Side.CLIENT);
    }

    @Mod.EventHandler
    public static void onPostInit(FMLPostInitializationEvent e){
        proxy.onPostInit(e);
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHander{

        @SubscribeEvent
        public static void registerItem(RegistryEvent.Register<Item> event){
            ModItems.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event){
            ModItems.registerModels();
        }
    }
}
