package elo7.marcia.challenge.template;

import java.util.List;

public class ExploreMarsRequestResponse {
    private ExploreMars mars;
    private List<ExploreMarsProbe> probes;

    public ExploreMars getMars() {
        return mars;
    }

    public void setMars(ExploreMars mars) {
        this.mars = mars;
    }

    public List<ExploreMarsProbe> getProbes() {
        return probes;
    }

    public void setProbes(List<ExploreMarsProbe> probes) {
        this.probes = probes;
    }
}
