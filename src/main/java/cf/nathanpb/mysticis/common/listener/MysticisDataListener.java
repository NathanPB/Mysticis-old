package cf.nathanpb.mysticis.common.listener;

import cf.nathanpb.mysticis.common.Mysticis;
import cf.nathanpb.mysticis.common.events.AffinityUpdateEvent;
import cf.nathanpb.mysticis.common.events.LevelUpdateEvent;
import cf.nathanpb.mysticis.common.events.ManaUpdateEvent;
import cf.nathanpb.mysticis.common.packets.AffinityUpdatePacket;
import cf.nathanpb.mysticis.common.packets.LevelUpdatePacket;
import cf.nathanpb.mysticis.common.packets.ManaUpdatePacket;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
    public static void onAffinityChange(AffinityUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayerMP) {
            AffinityUpdatePacket p = new AffinityUpdatePacket(e.getAffinity());
            Mysticis.NETWORK_WRAPPER.sendTo(p, (EntityPlayerMP) e.getEntity());
        }
    }

    @SubscribeEvent
    public static void onLevelChange(LevelUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayerMP) {
            LevelUpdatePacket p = new LevelUpdatePacket(e.getLevel());
            Mysticis.NETWORK_WRAPPER.sendTo(p, (EntityPlayerMP) e.getEntity());
        }
    }
}
