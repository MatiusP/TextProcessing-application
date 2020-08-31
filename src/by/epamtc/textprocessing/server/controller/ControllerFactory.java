package by.epamtc.textprocessing.server.controller;

import by.epamtc.textprocessing.server.controller.impl.TextControllerImpl;

public class ControllerFactory {
    private static final ControllerFactory INSTANCE = new ControllerFactory();
    private static TextController textController = new TextControllerImpl();

    private ControllerFactory() {
    }

    public static ControllerFactory getInstance() {
        return INSTANCE;
    }

    public TextController getTextController() {
        return textController;
    }
}
