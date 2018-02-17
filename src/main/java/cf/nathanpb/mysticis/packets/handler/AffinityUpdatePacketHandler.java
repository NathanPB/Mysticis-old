package cf.nathanpb.mysticis.packets.handler;

import cf.nathanpb.mysticis.hud.Hud;
import cf.nathanpb.mysticis.packets.AffinityUpdatePacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class AffinityUpdatePacketHandler implements IMessageHandler<AffinityUpdatePacket, IMessage>{
    @Override
    public IMessage onMessage(AffinityUpdatePacket message, MessageContext ctx) {
        Hud.AFFINITY.update(message.getAffinity());
        return null;
    }
}
