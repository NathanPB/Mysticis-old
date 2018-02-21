package cf.nathanpb.mysticis.common.data;

import cf.nathanpb.mysticis.common.Mysticis;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class MysticisConfig extends Configuration{


    public static Property
        SHOW_MANA_HUD,
        MANA_HUD_X,
        MANA_HUD_Y,

        SHOW_AFFINITY_HUD,
        AFFINITY_HUD_X,
        AFFINITY_HUD_Y,

        SHOW_LEVEL_HUD,
        LEVEL_HUD_X,
        LEVEL_HUD_Y,
        LEVEL_EXPONENT,
        LEVEL_EXP_BASE;

    public MysticisConfig(){
        super(new File("config/"+ Mysticis.ID+".cfg"));
        load();
        addCustomCategoryComment("mana", "Things about Mana System and its HUD");
        addCustomCategoryComment("affinity", "Things about Affinity System and its HUD");
        addCustomCategoryComment("leveling", "Things about Leveling System and its HUD");

        SHOW_MANA_HUD = get("mana", "show_hud", true, "Set to false to hide Mana HUD");
        MANA_HUD_X = get("mana", "hud_x", 30, "X axis to Mana HUD");
        MANA_HUD_Y = get("mana", "hud_y", 5, "Y axis to Mana HUD");

        SHOW_AFFINITY_HUD = get("affinity", "show_hud", true, "Set to false to hide Affinity HUD");
        AFFINITY_HUD_X = get("affinity", "hud_x", 5, "X axis to Affinity HUD");
        AFFINITY_HUD_Y = get("affinity", "hud_y", 5, "Y axis to Affinity HUD");

        SHOW_LEVEL_HUD = get("leveling", "show_hud", true, "Set to false to hide Level Hud");
        LEVEL_HUD_X = get("leveling", "hud_x", 20, "X axis to Level HUD");
        LEVEL_HUD_Y = get("leveling", "hud_y", 80, "Y axis to Level HUD");
        LEVEL_EXPONENT = get("leveling", "exponent", 1.5F, "Leveling System Difficulty");
        LEVEL_EXP_BASE = get("leveling", "exp_base", 1000, "Leveling System EXP Base");
        save();
    }

    public static void _save(){
        if(Mysticis.configuration.hasChanged())
            Mysticis.configuration.save();
    }
}
