public class Hero {
    MoveMethod moveMethod;

    public void setMoveMethod(MoveMethod moveMethod) {
        this.moveMethod = moveMethod;
    }

    public void Move() {
        moveMethod.Moving();
    }
}
