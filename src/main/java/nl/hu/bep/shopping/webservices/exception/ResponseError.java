package nl.hu.bep.shopping.webservices.exception;

public class ResponseError {
    String errorMessage;

    public ResponseError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static ResponseError createError(String errorMessage){
        return new ResponseError(errorMessage);
    }

}
