package com.endi.locationservices.errors;

import java.security.PrivilegedActionException;

/**
 * Created by Endi Zhupani on 18/06/2018.
 */
public class CityDistanceException extends Exception {
    private String operationBeingPerformed;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public CityDistanceException(String operationBeingPerformed) {
        super("Something went wrong while executing the program");
        this.operationBeingPerformed = operationBeingPerformed;
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public CityDistanceException(String message, String operationBeingPerformed) {
        super(message);
        this.operationBeingPerformed = operationBeingPerformed;
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>).
     * This constructor is useful for exceptions that are little more than
     * wrappers for other throwables (for example, {@link
     * PrivilegedActionException}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A <tt>null</tt> value is
     *              permitted, and indicates that the cause is nonexistent or
     *              unknown.)
     * @since 1.4
     */
    public CityDistanceException(Throwable cause, String operationBeingPerformed) {
        super(cause);
        this.operationBeingPerformed = operationBeingPerformed;
    }
}
