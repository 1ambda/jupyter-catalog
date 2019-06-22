package jupyter.common.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(String msg, Throwable t) {
        super(msg, t);
    }

    public static BadRequestException buildUserDoesNotExist(Long userId) {
        throw new BadRequestException("User does not exist" + userId);
    }
}
