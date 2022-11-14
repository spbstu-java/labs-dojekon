public class MathEx extends Exception {
    private String detail;

    MathEx(String errorCode) {
        detail = errorCode;
    }

    public String toString() {
        return "Math exception: [" + detail + "]";
    }

}
