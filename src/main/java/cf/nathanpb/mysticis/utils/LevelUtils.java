package cf.nathanpb.mysticis.utils;

public class LevelUtils {

    public static int expToLevel(long exp){
        double level = Math.pow(exp / 1000.0, 2 / 3.0);
        int a = (int) Math.floor(level);
        int b = (int) Math.ceil(level);
        return levelToExp(b) > exp ? a : b;
    }

    public static long levelToExp(int level){
        return (long) Math.floor(1000 * Math.pow(level, 1.5F));
    }
}
