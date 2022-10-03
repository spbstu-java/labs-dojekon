public class Fly implements MoveMethod{
    @Override
    public String Moving() {
        return "Лечу";
    }
    @Override
    public String Moved() {
        return "Прилетел";
    }
}
