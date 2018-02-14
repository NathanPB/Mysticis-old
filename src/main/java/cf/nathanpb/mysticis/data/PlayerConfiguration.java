package cf.nathanpb.mysticis.data;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Optional;

//todo arrumar outra forma de implementar esse sistema (client side)
public class PlayerConfiguration extends NBTTagCompound{

    public PlayerConfiguration(NBTTagCompound compound){
        try {
            Field f = compound.getClass().getDeclaredField("tagMap");
            f.setAccessible(true);
            HashMap<String, NBTBase> map  = (HashMap) f.get(compound);
            map.entrySet().forEach(e -> setTag(e.getKey(), e.getValue()));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static PlayerConfiguration from(EntityPlayer player){
        return new PlayerConfiguration(Optional.of(player.getEntityData().getCompoundTag("mysticis:configurations")).orElse(new NBTTagCompound()));
    }

    public void store(EntityPlayer player){
        player.getEntityData().setTag("mysticis:configurations", this);
    }

    public Object getRaw(Key key){
        if(!hasKey(key.name())){
            return key.getDefault();
        } else {
            return getTag(key.name());
        }
    }

    public boolean getBoolean(Key key) {
        return (boolean) getRaw(key);
    }

    public String getString(Key key) {
        return (String) getRaw(key);
    }

    public int getInteger(Key key) {
        return (int) getRaw(key);
    }

    public enum Key{
        MANA_DISPLAY_X(15),
        MANA_DISPLAY_Y(15),
        MANA_DISPLAY_FLAG(true);

        private Object dfault;

        Key(Object o){
            this.dfault = o;
        }

        public Object getDefault() {
            return dfault;
        }

        @Override
        public String toString() {
            return this.name();
        }
    }

}
