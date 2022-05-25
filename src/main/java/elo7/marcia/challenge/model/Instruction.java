package elo7.marcia.challenge.model;

public enum Instruction {
    R {
        @Override
        protected void execute(Planet mars, Movable movable) throws Exception {
            movable.turnRight(mars);
        }
    },
    L {
        @Override
        protected void execute(Planet mars, Movable movable) throws Exception {
            movable.turnLeft(mars);
        }
    },
    M {
        @Override
        protected void execute(Planet mars, Movable movable) throws Exception {
            Direction direction = movable.getLocation().getDirection();
            direction.moveForward(mars, movable);
        }
    };

    protected abstract void execute(Planet mars, Movable movable) throws Exception;

}
