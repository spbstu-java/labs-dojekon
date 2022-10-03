public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();

        hero.setMoveMethod(new Run());
        hero.move();
        hero.state();
        System.out.println();
        hero.setMoveMethod(new Fly());
        hero.move();
        hero.state();
        System.out.println();
        hero.setMoveMethod(new Ride());
        hero.move();
        hero.state();
    }
}
