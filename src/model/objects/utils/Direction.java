package model.objects.utils;

public enum Direction {
    LEFT(-1, 0),
    RIGHT(1, 0),
    DOWN(0, 1),
    UP(0, -1);

    final private int xIncrement;
    final private int yIncrement;

    public int getXIncrement() {
        return xIncrement;
    }

    public int getYIncrement() {
        return yIncrement;
    }

     Direction(int xIncrement, int yIncrement) {
        this.xIncrement = xIncrement;
        this.yIncrement = yIncrement;
    }
}
