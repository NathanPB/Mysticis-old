package cf.nathanpb.mysticis.common.spell.elements;

import cf.nathanpb.mysticis.common.ManaType;
import cf.nathanpb.mysticis.common.data.AffinityData;
import cf.nathanpb.mysticis.common.data.ManaData;
import cf.nathanpb.mysticis.common.spell.casting.SpellCastingBase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public abstract class SpellElementBase {
    private static HashMap<Class, Integer> idMap = new HashMap<>();


    public abstract ManaData getManaUse();
    public abstract AffinityData getAffinityGiven();
    public abstract int getExpGiven();
    public abstract void execute();
    public abstract ManaType type();



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
            if(c.isAnnotationPresent(SpellCastingBase.Id.class) && SpellCastingBase.class.isAssignableFrom(c)){
                id = ((SpellCastingBase.Id) c.getAnnotation(SpellCastingBase.Id.class)).value();
                idMap.put(c, id);
            } else {
                throw new RuntimeException("Class "+c.getSimpleName()+" is not a valid Spell Caster");
            }
        }
        return id;
    }

    public static Class<? extends SpellElementBase> fromId(int id){
        for(Map.Entry<Class, Integer> entry : idMap.entrySet()){
            if(entry.getValue().equals(id)) return entry.getKey();
        }
        return null;
    }
}
