package elo7.marcia.challenge.rest;

import elo7.marcia.challenge.model.*;
import elo7.marcia.challenge.template.ExploreMars;
import elo7.marcia.challenge.template.ExploreMarsProbe;
import elo7.marcia.challenge.template.ExploreMarsRequestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MarsProbeController {

    @GetMapping("/exploreMars")
    ResponseEntity exploreMars(@RequestBody ExploreMarsRequestResponse request) {
        try {
            Planet mars = mapRequest(request);
            ExploreMarsRequestResponse response = mapResponse(mars);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    private Planet mapRequest(ExploreMarsRequestResponse request) throws Exception {
        Planet mars = new Planet(request.getMars().getBorderX(), request.getMars().getBorderY());
        request.getProbes().forEach(probeRequest -> {
            Location location = new Location(probeRequest.getLocationX(), probeRequest.getLocationY(), probeRequest.getDirection());
            try {
                Probe probe = new Probe();
                DeployOnPlanet.execute(location, probe, mars);
                probe.runInstructions(probeRequest.getInstructions(), mars);
            } catch (Exception e) {
                throw new RuntimeException(e.getLocalizedMessage());
            }
        });
        return mars;
    }

    private ExploreMarsRequestResponse mapResponse(Planet mars) {
        ExploreMarsRequestResponse response = new ExploreMarsRequestResponse();
        ExploreMars marsResponse = new ExploreMars();
        marsResponse.setBorderX(mars.getBorderX());
        marsResponse.setBorderY(mars.getBorderY());
        response.setMars(marsResponse);

        List<ExploreMarsProbe> probesResponse = new ArrayList<>();
        mars.getObjects().forEach((key, value) -> {
            ExploreMarsProbe probeResponse = new ExploreMarsProbe();
            probeResponse.setDirection(key.getDirection());
            probeResponse.setLocationX(key.getX());
            probeResponse.setLocationY(key.getY());
            probesResponse.add(probeResponse);
        });
        response.setProbes(probesResponse);

        return response;
    }


}
