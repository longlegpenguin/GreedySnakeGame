package model.objects.utils;

import java.util.Objects;

public class Fragment {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Fragment(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void shiftBy(int xShift, int yShift) {
        x += xShift;
        y += yShift;
    }

    public boolean isOutOfTerritory(int leftBorder, int rightBorder, int upperBorder, int lowerBorder) {
        return  x < leftBorder ||
                y < upperBorder ||
                y > lowerBorder ||
                x > rightBorder;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Fragment) {
            Fragment that = (Fragment)obj;
            return this.x == that.getX() && this.y == that.getY();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
