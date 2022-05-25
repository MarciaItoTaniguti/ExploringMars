package elo7.marcia.challenge.model;

public enum Direction {
    N {
        @Override
        protected Direction right() {
            return Direction.E;
        }
        @Override
        protected Direction left() {
            return Direction.W;
        }
        @Override
        protected void moveForward(Planet mars, Movable movable) throws Exception {
            movable.moveObjectUp(mars);
        }
    },
    E {
        @Override
        protected Direction right() {
            return Direction.S;
        }
        @Override
        protected Direction left() {
            return Direction.N;
        }
        @Override
        protected void moveForward(Planet mars, Movable movable) throws Exception {
            movable.moveObjectRight(mars);
        }
    },
    S {
        @Override
        protected Direction right() {
            return Direction.W;
        }
        @Override
        protected Direction left() {
            return Direction.E;
        }
        @Override
        protected void moveForward(Planet mars, Movable movable) throws Exception {
            movable.moveObjectDown(mars);
        }
    },
    W {
        @Override
        protected Direction right() {
            return Direction.N;
        }
        @Override
        protected Direction left() {
            return Direction.S;
        }
        @Override
        protected void moveForward(Planet mars, Movable movable) throws Exception {
            movable.moveObjectLeft(mars);
        }
    };

    protected abstract Direction right();
    protected abstract Direction left();
    protected abstract void moveForward(Planet mars, Movable movable) throws Exception;
}
