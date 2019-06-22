package jupyter.common.exception;

public class DuplicatedException extends RuntimeException {
    public DuplicatedException(String msg) {
        super(msg);
    }

    public DuplicatedException(String msg, Throwable t) {
        super(msg, t);
    }
}
