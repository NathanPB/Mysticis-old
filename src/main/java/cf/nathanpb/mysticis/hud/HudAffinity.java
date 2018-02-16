package cf.nathanpb.mysticis.hud;

import cf.nathanpb.mysticis.data.AffinityData;
import cf.nathanpb.mysticis.data.ManaData;
import cf.nathanpb.mysticis.data.MysticisConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;

public class HudAffinity extends Hud {
    private AffinityData affinity = new AffinityData(new NBTTagCompound());

    private String
            air = affinity.get(ManaData.Type.AIR)+"",
            fire = affinity.get(ManaData.Type.FIRE)+"",
            water = affinity.get(ManaData.Type.WATER)+"",
            ice = affinity.get(ManaData.Type.ICE)+"",
            nature = affinity.get(ManaData.Type.NATURE)+"",
            magic = affinity.get(ManaData.Type.MAGIC)+"",
            dark = affinity.get(ManaData.Type.DARK)+"";

    public HudAffinity(){
        setPosition(MysticisConfig.AFFINITY_HUD_X.getInt(), MysticisConfig.AFFINITY_HUD_Y.getInt());
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
    public void update(AffinityData affinity){
        air = affinity.get(ManaData.Type.AIR)+"";
        fire = affinity.get(ManaData.Type.FIRE)+"";
        water = affinity.get(ManaData.Type.WATER)+"";
        ice = affinity.get(ManaData.Type.ICE)+"";
        nature = affinity.get(ManaData.Type.NATURE)+"";
        magic = affinity.get(ManaData.Type.MAGIC)+"";
        dark = affinity.get(ManaData.Type.DARK)+"";
    }
}
