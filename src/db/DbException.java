package db;

public class DbException extends RuntimeException {

    private static final long serialversionUID = 1L;

    public DbException(String msg) {
        super(msg);
    }

    public DbException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
