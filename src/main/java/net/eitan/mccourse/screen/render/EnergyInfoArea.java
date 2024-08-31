package net.eitan.mccourse.screen.render;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.Rect2i;
import net.minecraft.text.Text;
import team.reborn.energy.api.EnergyStorage;

import java.util.List;

public class EnergyInfoArea {
    public final Rect2i area;
    private final EnergyStorage energy;

    public EnergyInfoArea(int xMin, int yMin) {this(xMin, yMin, null, 8, 64);};

    public EnergyInfoArea(int xMin, int yMin, EnergyStorage energyStorage) {this(xMin, yMin, energyStorage, 8, 64);}

    public EnergyInfoArea(int xMin, int yMin, EnergyStorage energy, int width, int height) {
        area = new Rect2i(xMin, yMin, width, height);
        this.energy = energy;
    }

    public List<Text> getToolTips() {return List.of(Text.literal(energy.getAmount()+"/"+energy.getCapacity()+" E"));}

    public void draw(DrawContext context) {
        final int height = area.getHeight();
        int stored = (int) (height*energy.getAmount()/(float)energy.getCapacity());
        context.fillGradient(
                area.getX(), area.getY()+(height-stored),
                area.getX() + area.getWidth(), area.getY() + area.getHeight(),
                0xffb51500, 0xff600b00
        );
    }
}
