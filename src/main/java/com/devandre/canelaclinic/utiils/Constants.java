package com.devandre.canelaclinic.utiils;

/**
 * andre on 13/11/2023
 */
public class Constants {

    public static final String API_VERSION = "/api/v1";
    public static final String API_BASE_PATH = API_VERSION + "/";

    public static final class Exception {
        public static final class Common {
            public static final String RESOURCE_NOT_FOUND = "Resource not found";
            public static final String URI_NOT_FOUND_MESSAGE = API_BASE_PATH + "errors/not-found";
            public static final String ERROR_CATEGORY = "Generic";
            public static final String DUPLICATE_RESOURCE = "Duplicate resource";
            public static final String URI_DUPLICATE_RESOURCE_MESSAGE = API_BASE_PATH + "errors/duplicate-resource";
            public static final String REQUEST_VALIDATION_ERROR = "Request validation error";
            public static final String URI_REQUEST_VALIDATION_ERROR_MESSAGE = API_BASE_PATH + "errors/request-validation";
            public static final String GENERIC_ERROR = "Generic error";
            public static final String URI_GENERIC_ERROR_MESSAGE = API_BASE_PATH + "errors/generic";

            public static final String SERVER_ERROR = "Server error";
            public static final String URI_SERVER_ERROR_MESSAGE = API_BASE_PATH + "errors/server-error";

        }
    }
}
