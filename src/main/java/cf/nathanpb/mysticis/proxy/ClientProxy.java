package cf.nathanpb.mysticis.proxy;

import cf.nathanpb.mysticis.Mysticis;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ClientProxy extends CommonProxy{

    @Override
    public void registerItemRender(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Mysticis.ID + ":" + id, "inventory"));
    }
}
