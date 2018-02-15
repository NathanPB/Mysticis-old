package cf.nathanpb.mysticis.proxy;

import cf.nathanpb.mysticis.Mysticis;
import cf.nathanpb.mysticis.data.MysticisConfig;
import cf.nathanpb.mysticis.hud.HudConfigEditor;
import cf.nathanpb.mysticis.hud.ManaHud;
import cf.nathanpb.mysticis.utils.RenderUtils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
    public static ManaHud manaHud = new ManaHud();

    @Override
    public void registerItemRender(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Mysticis.ID + ":" + id, "inventory"));
    }

    @Override
    public void onPreInit(FMLPreInitializationEvent e) {
        super.onPreInit(e);
        new RenderUtils();
    }

    @Override
    public void onPostInit(FMLPostInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(manaHud);
    }
}
