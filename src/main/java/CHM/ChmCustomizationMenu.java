package CHM;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class ChmCustomizationMenu extends GuiScreen {


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        ScaledResolution sr = new ScaledResolution(mc);
        int posY = mouseY - sr.getScaledHeight();
        int posX = mouseX - sr.getScaledWidth()/2;
        ChmMain.yPos = posY;
        ChmMain.xPos = posX;
    }

    @Override
    public void drawDefaultBackground() {

    }
}
