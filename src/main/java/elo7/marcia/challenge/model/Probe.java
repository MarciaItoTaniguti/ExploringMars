package elo7.marcia.challenge.model;

public class Probe extends Movable{

    public Probe(Location location) {
        setLocation(location);
    }

    public void deploy(Planet planet) throws Exception {
        planet.addMovable(this);
    }

    public void runInstructions(String instructions, Planet planet) {
        try {
            for (char instruction : instructions.toCharArray()) {
                Instruction.valueOf(String.valueOf(instruction)).execute(planet, this);
            }
        } catch (Exception e) {
            System.out.println("During runInstructions - " + e.getLocalizedMessage());
        }
    }

    @Override
    protected void moveObjectUp(Planet planet) throws Exception {
        move(0,1,planet);
    }

    @Override
    protected void moveObjectDown(Planet planet) throws Exception {
        move(0,-1,planet);
    }

    @Override
    protected void moveObjectLeft(Planet planet) throws Exception {
        move(-1,0,planet);
    }

    @Override
    protected void moveObjectRight(Planet planet) throws Exception {
        move(1,0,planet);
    }

    @Override
    protected void turnRight(Planet planet) throws Exception {
        TargetLocation targetLocation = new TargetLocation(getLocation(),0,0);
        targetLocation.setDirection(targetLocation.getDirection().right());
        turn(planet, targetLocation);
    }

    @Override
    protected void turnLeft(Planet planet) throws Exception {
        TargetLocation targetLocation = new TargetLocation(getLocation(),0,0);
        targetLocation.setDirection(targetLocation.getDirection().left());
        turn(planet, targetLocation);
    }

    private void move(int plusX, int plusY, Planet planet) throws Exception {
        TargetLocation targetLocation = new TargetLocation(getLocation(), plusX, plusY);
        planet.updateMovable(this, targetLocation);
        this.setLocation(targetLocation);
    }

    private void turn(Planet planet, TargetLocation targetLocation) throws Exception {
        planet.updateMovable(this, targetLocation);
        this.setLocation(targetLocation);
    }

    @Override
    public String toString() {
        return "Location [" +
                "X: " + this.getLocation().getX() + ", " +
                "Y: " + this.getLocation().getY() + ", " +
                "D: " + this.getLocation().getDirection() + "]";
    }
}
