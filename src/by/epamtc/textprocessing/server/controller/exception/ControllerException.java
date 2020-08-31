package by.epamtc.textprocessing.server.controller.exception;

public class ControllerException extends RuntimeException {

    public ControllerException() {
    }

    public ControllerException(String message){
        super(message);
    }

    public ControllerException(Exception e){
        super(e);
    }

    public ControllerException(String message, Exception e){
        super(message, e);
    }
}
