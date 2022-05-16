package elo7.marcia.challenge.model;

public class Probe {

    public void runInstructions(String instructions, Planet planet) {
        try {
            for (char instruction : instructions.toCharArray()) {
                Instruction.valueOf(String.valueOf(instruction)).execute(planet, this);
            }
        } catch (Exception e) {
            System.out.println("During runInstructions - " + e.getLocalizedMessage());
        }

    }

}
