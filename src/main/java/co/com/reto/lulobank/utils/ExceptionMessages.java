package co.com.reto.lulobank.utils;

public enum ExceptionMessages {

    JSON_NOT_RESPONSE("ERROR!!! in response from service: %s with error message: %s");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
