package cf.nathanpb.mysticis;

import cf.nathanpb.mysticis.data.ManaData;
import cf.nathanpb.mysticis.data.PlayerConfiguration;
import cf.nathanpb.mysticis.item.ModItems;
import cf.nathanpb.mysticis.proxy.CommonProxy;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.UUID;

@Mod(modid = Mysticis.ID,  name = Mysticis.NAME, version = Mysticis.VERSION)
public class Mysticis {
    public static final String ID = "mysticis";
    public static final String NAME = "Mysticis";
    public static final String VERSION = "1.0.0";

    @SidedProxy(modId = Mysticis.ID, clientSide = "cf.nathanpb.mysticis.proxy.ClientProxy", serverSide = "cf.nathanpb.mysticis.proxy.CommonProxy")
    public static CommonProxy proxy;


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

        @SubscribeEvent
        public static void onJoin(PlayerEvent.PlayerLoggedInEvent e){
            CommonProxy.players.put(e.player.getUUID(e.player.getGameProfile()), e.player);
        }

        @SubscribeEvent
        public static void onTick(TickEvent.ServerTickEvent event){

            EntityPlayer p = CommonProxy.players.get(Minecraft.getMinecraft().player.getUUID(Minecraft.getMinecraft().player.getGameProfile()));

            ManaData mana = ManaData.from(p);
            PlayerConfiguration config = PlayerConfiguration.from(p);

            Minecraft.getMinecraft().fontRenderer.drawString(mana.toString(), config.getInteger(PlayerConfiguration.Key.MANA_DISPLAY_X), config.getInteger(PlayerConfiguration.Key.MANA_DISPLAY_Y), 1);
        }
    }
}
