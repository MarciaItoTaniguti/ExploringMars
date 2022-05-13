package elo7.marcia.challenge.template;

import elo7.marcia.challenge.model.orientation.CoordinatePoint;
import elo7.marcia.challenge.model.Probe;
import java.util.List;

public class ExploreMarsRequest {
    private CoordinatePoint mars;
    private List<Probe> probeList;

    public CoordinatePoint getMars() {
        return mars;
    }

    public void setMars(CoordinatePoint mars) {
        this.mars = mars;
    }

    public List<Probe> getProbeList() {
        return probeList;
    }

    public void setProbeList(List<Probe> probeList) {
        this.probeList = probeList;
    }
}
