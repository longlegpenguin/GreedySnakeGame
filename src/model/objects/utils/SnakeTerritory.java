package model.objects.utils;

public class SnakeTerritory {

    private final int leftBorder;
    private final int rightBorder;
    private final int upperBorder;
    private final int lowerBorder;

    public SnakeTerritory(int leftBorder, int rightBorder, int upperBorder, int lowerBorder) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.upperBorder = upperBorder;
        this.lowerBorder = lowerBorder;
    }

    public int getLeftBorder() {
        return leftBorder;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public int getUpperBorder() {
        return upperBorder;
    }

    public int getLowerBorder() {
        return lowerBorder;
    }
}
