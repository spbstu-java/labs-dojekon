public class Hero {
    public Hero() {
        position = Positions.A;
    }
    MoveMethod moveMethod;

    enum Positions {
        A {
            public Positions destination() {
                return B;
            }
        },
        B {
            public Positions destination() {
                return A;
            }
        };

        public abstract Positions destination();
    }

    Positions position;

    public void setMoveMethod(MoveMethod moveMethod) {
        this.moveMethod = moveMethod;
    }

    public void move() {
        System.out.println(moveMethod.Moving() + " из точки " + position.name().toString() + " в точку " + position.destination());
        position = position.destination();
    }

    public void state() {
        System.out.println(moveMethod.Moved() + " в точку " + position.name().toString());
    }
}