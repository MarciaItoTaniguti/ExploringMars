package elo7.marcia.challenge.instruction;

import elo7.marcia.challenge.model.MarsPlain;
import elo7.marcia.challenge.model.MovementOptions;

import java.util.List;

public interface MoveOnMatrix {

    void runInstructions(List<MovementOptions> instructions, MarsPlain mars);
}
