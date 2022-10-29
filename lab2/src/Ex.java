public class Ex extends Exception {
    private String detail;

    Ex(String errorCode) {
        detail = errorCode;
    }

    public String toString() {
        return "Own Exception: [" + detail + "]";
    }

}
