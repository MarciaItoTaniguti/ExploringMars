package elo7.marcia.challenge.model.planet;

import elo7.marcia.challenge.model.orientation.CoordinatePoint;
import elo7.marcia.challenge.model.orientation.ObjectOnMatrix;

import java.util.ArrayList;
import java.util.List;

public class MarsSurface {
    public static String LOCALE_NOT_AVAILABLE = "Locale is not available.";
    private List<ObjectOnMatrix> objectsOnMatrix;
    private CoordinatePoint borderLimit;

    public MarsSurface() {
        objectsOnMatrix = new ArrayList<>();
    }

    public MarsSurface(CoordinatePoint borderLimit) {
        this();
        this.borderLimit = borderLimit;
    }

    public void deployProbe(ObjectOnMatrix probe) throws Exception{
        CoordinatePoint reserveLocation = probe.getLocation();
        boolean isAvailable = objectsOnMatrix.stream().parallel().noneMatch(objectsOnMatrix -> objectsOnMatrix.getLocation().equals(reserveLocation));
        if (!isAvailable || !isLocationInLimits(reserveLocation)) {
            throw new Exception(LOCALE_NOT_AVAILABLE);
        }
        objectsOnMatrix.add(probe);
    }

    public void updateProbeOnMatrix(ObjectOnMatrix probe, ObjectOnMatrix probePrevious) throws Exception {
        CoordinatePoint reserveLocation = probe.getLocation();
        if (!probePrevious.getLocation().equals(reserveLocation)) {
            boolean isAvailable = objectsOnMatrix.stream().parallel().noneMatch(probeLocales -> probeLocales != probe && probeLocales.getLocation().equals(reserveLocation));
            if (!isAvailable || !isLocationInLimits(reserveLocation)) {
                throw new Exception(LOCALE_NOT_AVAILABLE);
            }
        }
    }

    private boolean isLocationInLimits(CoordinatePoint locale) {
        return isXLocaleValid(locale.getX()) && isYLocaleValid(locale.getY());
    }

    private boolean isXLocaleValid(int x) {
        return x > -1 && x < borderLimit.getX()+1;
    }

    private boolean isYLocaleValid(int y) {
        return y > -1 && y < borderLimit.getY()+1;
    }

    public void setBorderLimit(CoordinatePoint borderLimit) {
        this.borderLimit = borderLimit;
    }

    public CoordinatePoint getBorderLimit() {
        return borderLimit;
    }

    public List<ObjectOnMatrix> getObjectsOnMatrix() {
        return objectsOnMatrix;
    }

}
