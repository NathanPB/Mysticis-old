package cf.nathanpb.mysticis.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.UUID;

public class CommonProxy {
    public static final HashMap<UUID, EntityPlayer> players = new HashMap<>();

    public void registerItemRender(Item item, int meta, String id){

    }
}
