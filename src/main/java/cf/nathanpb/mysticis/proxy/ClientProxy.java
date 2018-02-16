package cf.nathanpb.mysticis.proxy;

import cf.nathanpb.mysticis.Mysticis;
import cf.nathanpb.mysticis.data.ManaData;
import cf.nathanpb.mysticis.hud.Hud;
import cf.nathanpb.mysticis.utils.RenderUtils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

    @Override
    public void registerItemRender(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Mysticis.ID + ":" + id, "inventory"));
    }

    @Override
    public void onPreInit(FMLPreInitializationEvent e) {
        super.onPreInit(e);
        new RenderUtils();
        Hud.MANA.update(new ManaData(new NBTTagCompound()));
    }
}
