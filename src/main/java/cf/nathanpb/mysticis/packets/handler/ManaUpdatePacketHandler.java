package cf.nathanpb.mysticis.packets.handler;

import cf.nathanpb.mysticis.hud.elements.HudElement;
import cf.nathanpb.mysticis.packets.ManaUpdatePacket;
import cf.nathanpb.mysticis.proxy.ClientProxy;
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
        HudElement.MANA.mana = message.getMana();
        return null;
    }
}
