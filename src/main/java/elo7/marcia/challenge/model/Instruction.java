package elo7.marcia.challenge.model;

public enum Instruction {
    R {
        @Override
        protected void execute(Planet planet, Object object) {
            MoveObject.turnRight(planet, object);
        }
    },
    L {
        @Override
        protected void execute(Planet planet, Object object) {
            MoveObject.turnLeft(planet, object);
        }
    },
    M {
        @Override
        protected void execute(Planet planet, Object object) throws Exception {
            MoveObject.moveForward(planet, object);
        }
    };

    protected abstract void execute(Planet planet, Object object) throws Exception;
}
