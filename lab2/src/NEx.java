public class NEx extends Throwable {
    private String detail;

    NEx(String errorCode) {
        detail = errorCode;
    }

    public String toString() {
        return "N Size Exception: [" + detail + "]";
    }

}
