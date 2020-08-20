package CHM;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.lwjgl.opengl.GL11;
import scala.collection.parallel.ParIterableLike;
import scala.xml.dtd.ELEMENTS;

import java.lang.reflect.Field;

@Mod(modid = ChmMain.MODID, version = ChmMain.VERSION)
public class ChmMain
{
    public static final String MODID = "chm";
    public static final String VERSION = "0.1";
    public Minecraft mc = Minecraft.getMinecraft();

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Pre event) {
        if (IsTypeAcceoted(event.type)) {
            ScaledResolution sr = new ScaledResolution(mc);
            GlStateManager.pushMatrix();
            GL11.glTranslated(0, -sr.getScaledWidth()/2, 0);
        }
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (IsTypeAcceoted(event.type)) {
            GlStateManager.popMatrix();
        }
    }

    public boolean IsTypeAcceoted(RenderGameOverlayEvent.ElementType type) {
        if (
                type == RenderGameOverlayEvent.ElementType.HEALTH
                || type == RenderGameOverlayEvent.ElementType.FOOD
                || type == RenderGameOverlayEvent.ElementType.EXPERIENCE
                || type == RenderGameOverlayEvent.ElementType.HOTBAR
                || type == RenderGameOverlayEvent.ElementType.JUMPBAR
        ) return true;
        return false;
    }
}
