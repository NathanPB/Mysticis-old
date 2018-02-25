package cf.nathanpb.mysticis.common.spell.casting;

import cf.nathanpb.mysticis.common.ManaType;
import cf.nathanpb.mysticis.common.data.AffinityData;
import cf.nathanpb.mysticis.common.data.ManaData;
import com.sun.istack.internal.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SpellCastingBase {
    private static HashMap<Class, Integer> idMap = new HashMap<>();


    public abstract ManaData getManaUse();
    public abstract AffinityData getAffinityGiven();
    public abstract int getExpGiven();
    public abstract List<Class> getTargets();
    public abstract ManaType type();

    public abstract void cast();
    public abstract void execute();

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Id{
        int value();
    }

    public static Integer getId(Class c){
        if(c != null){
            throw new RuntimeException("Class must not be null");
        }
        Integer id = idMap.get(c);
        if(id == null){
            if(c.isAnnotationPresent(Id.class) && SpellCastingBase.class.isAssignableFrom(c)){
                id = ((Id) c.getAnnotation(Id.class)).value();
                idMap.put(c, id);
            } else {
                throw new RuntimeException("Class "+c.getSimpleName()+" is not a valid Spell Caster");
            }
        }
        return id;
    }

    public static Class<? extends SpellCastingBase> fromId(int id){
        for(Map.Entry<Class, Integer> entry : idMap.entrySet()){
            if(entry.getValue().equals(id)) return entry.getKey();
        }
        return null;
    }


}
