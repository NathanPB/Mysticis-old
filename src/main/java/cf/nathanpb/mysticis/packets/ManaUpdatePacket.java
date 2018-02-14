package cf.nathanpb.mysticis.packets;

import cf.nathanpb.mysticis.data.ManaData;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.SidedProxy;
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
        ByteBufUtils.writeTag(buf, mana);
    }

    public ManaData getMana() {
        return mana;
    }
}
