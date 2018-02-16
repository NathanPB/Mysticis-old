package cf.nathanpb.mysticis.packets.handler;

import cf.nathanpb.mysticis.hud.Hud;
import cf.nathanpb.mysticis.packets.ManaUpdatePacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ManaUpdatePacketHandler implements IMessageHandler<ManaUpdatePacket, IMessage> {
    @Override
    public IMessage onMessage(ManaUpdatePacket message, MessageContext ctx) {
        Hud.MANA.update(message.getMana());
        return null;
    }
}
