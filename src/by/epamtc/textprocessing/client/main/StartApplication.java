package by.epamtc.textprocessing.client.main;

import by.epamtc.textprocessing.client.controller.ClientSocketRunner;

public class StartApplication {

    public static void main(String[] args) {
        ClientSocketRunner start = new ClientSocketRunner();
        start.startClient();
    }
}
