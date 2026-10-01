package com.shashi.constant;

import java.util.Arrays;
import java.util.Optional;

public enum ResponseCode {

    SUCCESS(
            200,
            "OK"
    ),

    FAILURE(
            422,
            "Unprocessable Entity, Failed to Process"
    ),

    NO_CONTENT(
            204,
            "No Items Found"
    ),

    PAGE_NOT_FOUND(
            404,
            "The Page You Are Searching For Is Not Available"
    ),

    ACCESS_DENIED(
            403,
            "Please Login First to Continue"
    ),

    BAD_REQUEST(
            400,
            "Bad Request, Please Try Again"
    ),

    UNAUTHORIZED(
            401,
            "Invalid Credentials, Try Again"
    ),

    SESSION_EXPIRED(
            401,
            "Session Expired, Login Again to Continue"
    ),

    INTERNAL_SERVER_ERROR(
            500,
            "Internal Server Error, Try Again"
    ),

    DATABASE_CONNECTION_FAILURE(
            406,
            "Unable to Connect to DB, Please Check Your DB Credentials in application.properties"
    ),

    METHOD_NOT_ALLOWED(
            405,
            "Requested HTTP Method Is Not Supported by This URL"
    );

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Find response code by HTTP status code.
     */
    public static Optional<ResponseCode> getMessageByStatusCode(int statusCode) {
        return Arrays.stream(values())
                .filter(responseCode -> responseCode.getCode() == statusCode)
                .findFirst();
    }
}
