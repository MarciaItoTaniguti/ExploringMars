package elo7.marcia.challenge.model;

public class DeployOnPlanet {

    public static final String INVALID_LOCALE = "Invalid deploy location";

    public static void execute(Location location, Object object, Planet planet) throws Exception {
        validateDeployLocation(location, planet);
        validateDeployOnEmptySpace(location, planet);
        planet.addObject(location, object);
    }

    private static void validateDeployLocation(Location location, Planet planet) throws Exception {
        if (location.getX() < 0 || location.getY() < 0 || location.getX() > planet.getBorderX() || location.getY() > planet.getBorderY()) {
            throw new Exception(INVALID_LOCALE);
        }
    }

    private static void validateDeployOnEmptySpace(Location location, Planet planet) throws Exception {
        if (planet.getObjects().get(location) != null) {
            throw new Exception(INVALID_LOCALE);
        }
    }
}
