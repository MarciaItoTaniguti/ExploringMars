package elo7.marcia.challenge.model;

public class TargetLocation extends Location{

    public  TargetLocation(Location location, int plusX, int plusY) {
        super(location.getX()+plusX, location.getY()+plusY, location.getDirection());
    }
}
