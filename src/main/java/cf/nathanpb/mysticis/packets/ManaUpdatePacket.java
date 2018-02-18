package cf.nathanpb.mysticis.packets;

import cf.nathanpb.mysticis.data.ManaData;
import cf.nathanpb.mysticis.hud.Hud;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ManaUpdatePacket implements IMessage{
    ManaData mana;

    public ManaUpdatePacket(){}
    public ManaUpdatePacket(ManaData mana){
        this.mana = mana;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.mana = new ManaData(ByteBufUtils.readTag(buf));
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, mana.toTag());
    }

    public ManaData getMana() {
        return mana;
    }

    public static class Handler implements IMessageHandler<ManaUpdatePacket, IMessage>{
        @Override
        public IMessage onMessage(ManaUpdatePacket message, MessageContext ctx) {
            Hud.MANA.update(message.getMana());
            return null;
        }
    }
}
