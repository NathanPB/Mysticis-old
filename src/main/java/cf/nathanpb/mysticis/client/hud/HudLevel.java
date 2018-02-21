package cf.nathanpb.mysticis.client.hud;

import cf.nathanpb.mysticis.common.data.LevelData;
import cf.nathanpb.mysticis.common.data.ManaData;
import cf.nathanpb.mysticis.common.data.MysticisConfig;
import cf.nathanpb.mysticis.utils.MathUtils;

public class HudLevel extends Hud{
    private LevelData level = new LevelData(0);
    private String percent = "0%";

    public HudLevel(){
        super();
        setPosition(MysticisConfig.LEVEL_HUD_X.getInt(), MysticisConfig.LEVEL_HUD_Y.getInt());
        setSize(30, 20);
        update(new LevelData(0));
    }

    @Override
    public void render() {
        super.render();
        if(MysticisConfig.SHOW_LEVEL_HUD.getBoolean() && level != null){
            drawCenteredString(mc.fontRenderer, "Level: "+level.level, getX(), getY(), ManaData.colorMagic);
            drawCenteredString(mc.fontRenderer, "Exp: "+percent, getX(), getY()+10, ManaData.colorMagic);
        }
    }

    public void update(LevelData level){
        this.level = level;
        percent = (MathUtils.split( ((double)  level.exp * 100), level.expToLevelUp))+"%";
    }
}
