package cf.nathanpb.mysticis.common.utils;

import cf.nathanpb.mysticis.common.data.MysticisConfig;

public class LevelUtils {

    public static int expToLevel(long exp){
        double level = Math.pow(MathUtils.split((double) exp, (double) MysticisConfig.LEVEL_EXP_BASE.getInt()), MathUtils.decimalToFraction(MysticisConfig.LEVEL_EXPONENT.getDouble()));
        int a = (int) Math.floor(level);
        int b = (int) Math.ceil(level);
        return levelToExp(b) > exp ? a : b;
    }

    public static long levelToExp(int level){
        return (long) Math.floor(MysticisConfig.LEVEL_EXP_BASE.getInt() * Math.pow(level, MysticisConfig.LEVEL_EXPONENT.getDouble()));
    }


}
