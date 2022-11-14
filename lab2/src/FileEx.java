public class FileEx extends Exception {
    private String detail;

    FileEx(String errorCode) {
        detail = errorCode;
    }

    public String toString() {
        return "File Exception: [" + detail + "]";
    }

}
