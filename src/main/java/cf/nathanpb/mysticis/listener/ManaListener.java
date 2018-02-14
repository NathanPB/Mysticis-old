package cf.nathanpb.mysticis.listener;

import cf.nathanpb.mysticis.Mysticis;
import cf.nathanpb.mysticis.events.ManaUpdateEvent;
import cf.nathanpb.mysticis.packets.ManaUpdatePacket;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//server side

@Mod.EventBusSubscriber
public class ManaListener {

    @SubscribeEvent
    public static void onManaChange(ManaUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayerMP) {
            ManaUpdatePacket p = new ManaUpdatePacket(e.getMana());
            Mysticis.NETWORK_WRAPPER.sendTo(p, (EntityPlayerMP)e.getEntity());
        }
    }
}
