package elo7.marcia.challenge.controller;

import elo7.marcia.challenge.model.planet.MarsSurface;
import elo7.marcia.challenge.template.ExploreMarsRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbeController {

    @GetMapping("/exploreMars")
    public ResponseEntity executeProbeOnMars(@RequestBody ExploreMarsRequest marsAndProbes) {
        try {
            MarsSurface marsPlainResponse = new MarsSurface();
            marsPlainResponse.setBorderLimit(marsAndProbes.getMars());

            marsAndProbes.getProbeList().forEach(probe -> {
                try {
                    marsPlainResponse.deployProbe(probe);
                    probe.runInstructions(marsPlainResponse);
                } catch (Exception e) {
                    throw new RuntimeException(e.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(marsAndProbes);
    }

}
