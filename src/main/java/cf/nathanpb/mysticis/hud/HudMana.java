package cf.nathanpb.mysticis.hud;

import cf.nathanpb.mysticis.data.ManaData;
import cf.nathanpb.mysticis.data.MysticisConfig;
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




    public HudMana(){
        setPosition(MysticisConfig.MANA_HUD_X.getInt(), MysticisConfig.MANA_HUD_Y.getInt());
        setSize(30, 60);
    }

    public void render(){
        super.render();
        if(MysticisConfig.SHOW_MANA_HUD.getBoolean()) {
            int height = getY();
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, air, getX(), height, ManaData.colorAir);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, fire, getX(), height+=10, ManaData.colorFire);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, water, getX(), height+=10, ManaData.colorWater);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, ice, getX(), height+=10, ManaData.colorIce);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, nature, getX(), height+=10, ManaData.colorNature);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, magic, getX(), height+=10, ManaData.colorMagic);
            drawCenteredString(Minecraft.getMinecraft().fontRenderer, dark, getX(), height+10, ManaData.colorDark);
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
