import java.awt.*;

public class Document {
    private int width;
    private int height;
    private int x;
    private int y;

    public Document (int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 126;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Rectangle letterRect () {
        Rectangle rect = new Rectangle(x,y, width, height);
        return rect;
    }
}
