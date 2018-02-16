package cf.nathanpb.mysticis.hud;

import cf.nathanpb.mysticis.data.ManaData;
import cf.nathanpb.mysticis.data.MysticisConfig;
import cf.nathanpb.mysticis.proxy.ClientProxy;
import cf.nathanpb.mysticis.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;

public class HudMana extends Hud{
    private ManaData mana = new ManaData(new NBTTagCompound());

    private String
            air = mana.get(ManaData.Type.AIR)+"",
            fire = mana.get(ManaData.Type.FIRE)+"",
            water = mana.get(ManaData.Type.WATER)+"",
            ice = mana.get(ManaData.Type.ICE)+"",
            nature = mana.get(ManaData.Type.NATURE)+"",
            magic = mana.get(ManaData.Type.MAGIC)+"",
            dark = mana.get(ManaData.Type.DARK)+"";

    private static int
            colorAir = Integer.parseInt("FFFF55", 16),
            colorFire = Integer.parseInt("AA0000", 16),
            colorWater = Integer.parseInt("0000AA", 16),
            colorIce = Integer.parseInt("00AAAA", 16),
            colorNature = Integer.parseInt("00AA00", 16),
            colorMagic = Integer.parseInt("AA00AA", 16),
            colorDark = Integer.parseInt("460860", 16);




    public HudMana(){
        setPosition(MysticisConfig.MANA_HUD_X.getInt(), MysticisConfig.MANA_HUD_Y.getInt());
        setSize(30, 60);
    }

    public void render(){
        super.render();
        if(MysticisConfig.SHOW_MANA_HUD.getBoolean()) {
            int height = getY();
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, air, getX(), height, colorAir);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, fire, getX(), height+=10, colorFire);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, water, getX(), height+=10, colorWater);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, ice, getX(), height+=10, colorIce);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, nature, getX(), height+=10, colorNature);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, magic, getX(), height+=10, colorMagic);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, dark, getX(), height+10, colorDark);
        }
    }

    /*
        To save cpu resources
     */
    public void update(ManaData mana){
        air = mana.get(ManaData.Type.AIR)+"";
        fire = mana.get(ManaData.Type.FIRE)+"";
        water = mana.get(ManaData.Type.WATER)+"";
        ice = mana.get(ManaData.Type.ICE)+"";
        nature = mana.get(ManaData.Type.NATURE)+"";
        magic = mana.get(ManaData.Type.MAGIC)+"";
        dark = mana.get(ManaData.Type.DARK)+"";
    }
}
