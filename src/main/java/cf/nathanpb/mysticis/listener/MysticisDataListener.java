package cf.nathanpb.mysticis.listener;

import cf.nathanpb.mysticis.Mysticis;
import cf.nathanpb.mysticis.events.AffinityUpdateEvent;
import cf.nathanpb.mysticis.events.ManaUpdateEvent;
import cf.nathanpb.mysticis.packets.AffinityUpdatePacket;
import cf.nathanpb.mysticis.packets.ManaUpdatePacket;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//@SideOnly(Side.SERVER)
@Mod.EventBusSubscriber
public class MysticisDataListener {

    @SubscribeEvent
    public static void onManaChange(ManaUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayerMP) {
            ManaUpdatePacket p = new ManaUpdatePacket(e.getMana());
            Mysticis.NETWORK_WRAPPER.sendTo(p, (EntityPlayerMP) e.getEntity());
        }
    }

    @SubscribeEvent
    public void onAffinityChange(AffinityUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayerMP) {
            AffinityUpdatePacket p = new AffinityUpdatePacket(e.getAffinity());
            Mysticis.NETWORK_WRAPPER.sendTo(p, (EntityPlayerMP) e.getEntity());
        }
    }
}
