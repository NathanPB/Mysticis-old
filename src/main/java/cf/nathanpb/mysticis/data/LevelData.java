package cf.nathanpb.mysticis.data;

import cf.nathanpb.mysticis.utils.LevelUtils;
import net.minecraft.entity.EntityLivingBase;

public class LevelData {
    public long exp = 0L;
    public int level = 0;

    public LevelData(long exp){
        this.exp = exp;
        update();
    }


    public void update(){
        level = LevelUtils.expToLevel(exp);
    }

    public static LevelData from(EntityLivingBase e){
        return new LevelData(e.getEntityData().getLong("mysticis:leveling"));
    }

    public void store(EntityLivingBase e){
        e.getEntityData().setLong("mysticis:leveling", exp);
    }
}
