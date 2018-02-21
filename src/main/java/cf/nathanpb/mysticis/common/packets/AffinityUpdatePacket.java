package cf.nathanpb.mysticis.common.packets;

import cf.nathanpb.mysticis.client.hud.Hud;
import cf.nathanpb.mysticis.common.data.AffinityData;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class AffinityUpdatePacket implements IMessage{
    private AffinityData affinity;

    public AffinityUpdatePacket(){}
    public AffinityUpdatePacket(AffinityData affinity){
        this.affinity = affinity;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, affinity.toTag());
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.affinity = new AffinityData(ByteBufUtils.readTag(buf));
    }

    public AffinityData getAffinity() {
        return affinity;
    }

    public static class Handler implements IMessageHandler<AffinityUpdatePacket, IMessage>{
        @Override
        public IMessage onMessage(AffinityUpdatePacket message, MessageContext ctx) {
            Hud.AFFINITY.update(message.getAffinity());
            return null;
        }
    }
}
