package com.hbm.inventory.gui;

import com.hbm.inventory.container.ContainerMachineCatalyticReformer;
import com.hbm.items.ModItems;
import com.hbm.lib.RefStrings;
import com.hbm.tileentity.machine.oil.TileEntityMachineCatalyticReformer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class GUIMachineCatalyticReformer extends GuiInfoContainer {

    private static ResourceLocation texture = new ResourceLocation(RefStrings.MODID + ":textures/gui/processing/gui_catalytic_reformer.png");
    private TileEntityMachineCatalyticReformer refinery;

    public GUIMachineCatalyticReformer(InventoryPlayer invPlayer, TileEntityMachineCatalyticReformer tedf) {
        super(new ContainerMachineCatalyticReformer(invPlayer, tedf));
        refinery = tedf;

        this.xSize = 176;
        this.ySize = 238;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float f) {
        super.drawScreen(mouseX, mouseY, f);

        refinery.tanks[0].renderTankInfo(this, mouseX, mouseY, guiLeft + 35, guiTop + 70 - 52, 16, 52);
        refinery.tanks[1].renderTankInfo(this, mouseX, mouseY, guiLeft + 107, guiTop + 70 - 52, 16, 52);
        refinery.tanks[2].renderTankInfo(this, mouseX, mouseY, guiLeft + 125, guiTop + 70 - 52, 16, 52);
        refinery.tanks[3].renderTankInfo(this, mouseX, mouseY, guiLeft + 143, guiTop + 70 - 52, 16, 52);
        this.drawElectricityInfo(this, mouseX, mouseY, guiLeft + 17, guiTop + 70 - 52, 16, 52, refinery.power, refinery.maxPower);

        if(this.mc.player.inventory.getItemStack() == ItemStack.EMPTY && this.isMouseOverSlot(this.inventorySlots.getSlot(10), mouseX, mouseY) && !this.inventorySlots.getSlot(10).getHasStack()) {
            List<Object[]> lines = new ArrayList();
            ItemStack converter = new ItemStack(ModItems.catalytic_converter);
            lines.add(new Object[] {converter});
            lines.add(new Object[] {converter.getDisplayName()});
            this.drawStackText(lines, mouseX, mouseY, this.fontRenderer, 0);
        }
        super.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j) {
        String name = this.refinery.hasCustomInventoryName() ? this.refinery.getInventoryName() : I18n.format(this.refinery.getInventoryName());

        this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 5, 0xffffff);
        this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        super.drawDefaultBackground();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        int j = (int) (refinery.power * 54 / refinery.maxPower);
        drawTexturedModalRect(guiLeft + 17, guiTop + 70 - j, 176, 52 - j, 16, j);

        refinery.tanks[0].renderTank(guiLeft + 35, guiTop + 70, this.zLevel, 16, 52);
        refinery.tanks[1].renderTank(guiLeft + 107, guiTop + 70, this.zLevel, 16, 52);
        refinery.tanks[2].renderTank(guiLeft + 125, guiTop + 70, this.zLevel, 16, 52);
        refinery.tanks[3].renderTank(guiLeft + 143, guiTop + 70, this.zLevel, 16, 52);
    }
}
