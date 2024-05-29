public class Wood {
    private int widthAndHeight;
    private int x;
    private int y;

    public Wood (int x, int y) {
        this.widthAndHeight = 75;
        this.x = x;
        this.y =y;
    }

    public int getWidthAndHeight() {
        return widthAndHeight;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
