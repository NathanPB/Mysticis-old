package cf.nathanpb.mysticis.client.hud;

import cf.nathanpb.mysticis.common.data.ManaData;
import cf.nathanpb.mysticis.common.data.MysticisConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;

public class HudMana extends Hud{
    private ManaData mana = new ManaData(new NBTTagCompound());

    private String
            air = mana.AIR+"",
            fire = mana.FIRE+"",
            water = mana.WATER+"",
            ice = mana.ICE+"",
            nature = mana.NATURE+"",
            magic = mana.MAGIC+"",
            dark = mana.DARK+"";




    public HudMana(){
        setPosition(MysticisConfig.MANA_HUD_X.getInt(), MysticisConfig.MANA_HUD_Y.getInt());
        setSize(30, 60);
    }

    public void render(){
        super.render();
        if(MysticisConfig.SHOW_MANA_HUD.getBoolean()) {
            int height = getY();
            drawString(Minecraft.getMinecraft().fontRenderer, air, getX(), height, ManaData.colorAir);
            drawString(Minecraft.getMinecraft().fontRenderer, fire, getX(), height+=10, ManaData.colorFire);
            drawString(Minecraft.getMinecraft().fontRenderer, water, getX(), height+=10, ManaData.colorWater);
            drawString(Minecraft.getMinecraft().fontRenderer, ice, getX(), height+=10, ManaData.colorIce);
            drawString(Minecraft.getMinecraft().fontRenderer, nature, getX(), height+=10, ManaData.colorNature);
            drawString(Minecraft.getMinecraft().fontRenderer, magic, getX(), height+=10, ManaData.colorMagic);
            drawString(Minecraft.getMinecraft().fontRenderer, dark, getX(), height+10, ManaData.colorDark);
        }
    }

    public void update(ManaData mana){
        air = mana.AIR+"";
        fire = mana.FIRE+"";
        water = mana.WATER+"";
        ice = mana.ICE+"";
        nature = mana.NATURE+"";
        magic = mana.MAGIC+"";
        dark = mana.DARK+"";
    }
}
