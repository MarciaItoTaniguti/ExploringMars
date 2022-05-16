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
        protected void move(Planet planet, Object object) throws Exception {
            MoveObject.moveUp(planet, object);
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
        protected void move(Planet planet, Object object) throws Exception {
            MoveObject.moveRight(planet, object);
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
        protected void move(Planet planet, Object object) throws Exception {
            MoveObject.moveDown(planet, object);
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
        protected void move(Planet planet, Object object) throws Exception {
            MoveObject.moveLeft(planet, object);
        }
    };

    protected abstract Direction right();
    protected abstract Direction left();
    protected abstract void move(Planet planet, Object object) throws Exception;
}
