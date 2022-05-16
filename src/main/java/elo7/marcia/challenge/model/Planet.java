package elo7.marcia.challenge.model;

import elo7.marcia.challenge.utils.ReverseHashMap;

public class Planet implements MoveObjectInterface {
    private int borderX;
    private int borderY;
    private ReverseHashMap<Location, Object> objects;
    public static final String OUT_OF_BORD = "Movement out of board.";
    public static final String INVALID_BORD = "Invalid bord value.";

    public Planet(int borderX, int borderY) throws Exception {
        setBorderX(borderX);
        setBorderY(borderY);
        this.objects = new ReverseHashMap<>();
    }

    private void move(int plusX, int plusY, Object object) throws Exception {
        Location currentLocation = getCurrentLocation(object);

        Location nextLocation = new Location(currentLocation.getX() + plusX, currentLocation.getY() + plusY, currentLocation.getDirection());
        MoveObject.validateMovement(objects.get(nextLocation));
        validateNextLocation(nextLocation);
        replaceObject(objects, currentLocation, nextLocation, object);
    }

    @Override
    public void moveObjectUp(Object object) throws Exception {
        move(0, 1, object);
    }

    @Override
    public void moveObjectDown(Object object) throws Exception {
        move(0,-1, object);
    }

    @Override
    public void moveObjectLeft(Object object) throws Exception {
        move(-1, 0, object);
    }

    @Override
    public void moveObjectRight(Object object) throws Exception {
        move(1, 0, object);
    }

    @Override
    public void turnRight(Object object) {
        Location currentLocation = getCurrentLocation(object);
        turn(object, currentLocation.getDirection().right(), currentLocation);
    }

    @Override
    public void turnLeft(Object object) {
        Location currentLocation = getCurrentLocation(object);
        turn(object, currentLocation.getDirection().left(), currentLocation);
    }

    private void turn(Object object, Direction nextDirection, Location currentLocation) {
        Location nextLocation = new Location(currentLocation.getX(), currentLocation.getY(), nextDirection);
        replaceObject(objects, currentLocation, nextLocation, object);
    }

    private Location getCurrentLocation(Object object) {
        ReverseHashMap<Location, Object> objects = this.getObjects();
        return objects.getKey(object);
    }

    @Override
    public void moveForward(Object object) throws Exception {
        ReverseHashMap<Location, Object> objects = this.getObjects();
        Location currentLocation = objects.getKey(object);
        currentLocation.getDirection().move(this, object);
    }

    private void validateNextLocation(Location nextLocation) throws Exception {
        if (isLocaleXInvalid(nextLocation) || isLocaleYInvalid(nextLocation)) {
            throw new Exception(OUT_OF_BORD);
        }
    }

    private boolean isLocaleXInvalid(Location nextLocation) {
        return (nextLocation.getX() > getBorderX() || nextLocation.getX() < 0);
    }

    private boolean isLocaleYInvalid(Location nextLocation) {
        return (nextLocation.getY() > getBorderY() || nextLocation.getY() < 0);
    }

    private static void replaceObject(ReverseHashMap objects, Location oldLocation, Location newLocation, Object object) {
        objects.remove(oldLocation);
        objects.put(newLocation, object);
    }

    private void setBorderX(int x) throws Exception {
        if (x < 0) {
            throw new Exception(INVALID_BORD);
        }
        this.borderX = x;
    }

    private void setBorderY(int y) throws Exception {
        if (y < 0) {
            throw new Exception(INVALID_BORD);
        }
        this.borderY = y;
    }

    public void addObject(Location key, Object probe) {
        objects.put(key, probe);
    }

    public int getBorderX() {
        return borderX;
    }

    public int getBorderY() {
        return borderY;
    }

    public ReverseHashMap<Location, Object> getObjects() {
        return objects;
    }

}
