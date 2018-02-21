package cf.nathanpb.mysticis.common.packets;

import cf.nathanpb.mysticis.common.data.LevelData;
import cf.nathanpb.mysticis.client.hud.Hud;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class LevelUpdatePacket implements IMessage{

    private LevelData level;

    public LevelUpdatePacket(){}
    public LevelUpdatePacket(LevelData level){
        this.level = level;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(level.exp);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.level = new LevelData(buf.readLong());
    }

    public static class Handler implements IMessageHandler<LevelUpdatePacket, IMessage>{
        @Override
        public IMessage onMessage(LevelUpdatePacket message, MessageContext ctx) {
            Hud.LEVEL.update(message.level);
            return null;
        }
    }
}
