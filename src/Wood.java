public class Wood {
    private int width;
    private int height;
    private int x;
    private int y;

    public Wood (int width, int height, int x, int y) {
        this.width =  width;
        this.height = height;
        this.x = x;
        this.y =y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
