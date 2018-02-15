package cf.nathanpb.mysticis.hud.elements;

import cf.nathanpb.mysticis.data.ManaData;
import cf.nathanpb.mysticis.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;

public class ManaHudElement extends HudElement{
    public ManaData mana = new ManaData(new NBTTagCompound());

    public ManaHudElement(){
        setPostion(CommonProxy.configuration.getManaHudX(), CommonProxy.configuration.getManaHudY());
        setSize(30, 60);
    }

    @Override
    public void render() {
        if(mana != null && gui != null) {
            super.render();
            int height = getY();
            String air = "§e" + mana.get(ManaData.Type.AIR);
            String fire = "§4" + mana.get(ManaData.Type.FIRE);
            String water = "§9" + mana.get(ManaData.Type.WATER);
            String ice = "§b" + mana.get(ManaData.Type.ICE);
            String nature = "§2" + mana.get(ManaData.Type.NATURE);
            String magic =  "§5" + mana.get(ManaData.Type.MAGIC);
            String dark = "§7" + mana.get(ManaData.Type.DARK);

            gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, air, getX(), height, Integer.parseInt("FFAA00", 16));
            gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, fire, getX(), height+=10, Integer.parseInt("FFAA00", 16));
            gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, water, getX(), height+=10, Integer.parseInt("FFAA00", 16));
            gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, ice, getX(), height+=10, Integer.parseInt("FFAA00", 16));
            gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, nature, getX(), height+=10, Integer.parseInt("FFAA00", 16));
            gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, magic, getX(), height+=10, Integer.parseInt("FFAA00", 16));
            gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, dark, getX(), height+10, Integer.parseInt("FFAA00", 16));
        }
    }
}
