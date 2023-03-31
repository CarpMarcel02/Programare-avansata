import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
public class Line {
    private double startX;
    private double startY;
    private double endX;
    private double endY;

    public Color culoare;



    public Line(double startX, double startY, double endX, double endY,Color culoare) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.culoare=culoare;

    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getEndX() {
        return endX;
    }

    public double getEndY() {
        return endY;
    }

    @Override
    public String toString() {
        return "Line{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                ", culoare=" + culoare +
                '}';
    }
}

