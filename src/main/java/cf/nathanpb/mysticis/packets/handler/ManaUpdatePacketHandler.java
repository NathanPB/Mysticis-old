package cf.nathanpb.mysticis.packets.handler;

import cf.nathanpb.mysticis.packets.ManaUpdatePacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class ManaUpdatePacketHandler implements IMessageHandler<ManaUpdatePacket, IMessage> {
    @Override
    public IMessage onMessage(ManaUpdatePacket message, MessageContext ctx) {
        //todo renderizar a mana
        return null;
    }
}
