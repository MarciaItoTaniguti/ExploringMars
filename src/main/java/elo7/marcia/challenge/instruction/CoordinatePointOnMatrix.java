package elo7.marcia.challenge.instruction;

public class CoordinatePointOnMatrix extends CoordinatePoint{

    public CoordinatePointOnMatrix(int x, int y) {
        super(x, y);
    }

    @Override
    public void setX(int x) {
        if (x < 0) {
            throw new RuntimeException("Coordinate X cannot be less than 0.");
        }
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        if (y < 0) {
            throw new RuntimeException("Coordinate Y cannot be less than 0.");
        }
        super.setY(y);
    }
}
