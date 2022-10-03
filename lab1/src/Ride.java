public class Ride implements MoveMethod {
    @Override
    public String Moving() {
        return "Еду";
    }
    @Override
    public String Moved() {
        return "Приехал";
    }
}
