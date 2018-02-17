package cf.nathanpb.mysticis.packets;

import cf.nathanpb.mysticis.data.AffinityData;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

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
}
