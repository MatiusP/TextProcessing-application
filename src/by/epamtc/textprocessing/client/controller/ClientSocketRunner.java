package by.epamtc.textprocessing.client.controller;

import by.epamtc.textprocessing.client.service.ClientService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientSocketRunner {
    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private String request;

    public void startClient() {
        try {
            clientSocket = new Socket("localhost", 4444);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());

            request = createClientRequest();
            Object response;

            while (!request.equals("exit")) {
                sendRequestToServer(request);
                response = readResponseFromServer();
                showResponse(response);
                request = createClientRequest();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при обработке запроса.");
        } finally {
            try {
                if (sendCloseRequestToServer()) {
                    clientSocket.close();
                    System.out.println("Соединение с сервером успешно закрыто.");
                } else {
                    clientSocket.close();
                    System.out.println("Соединение с сервером прервано.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String createClientRequest() throws IOException {
        ClientService clientService = new ClientService();
        return clientService.getClientRequest();
    }

    private void sendRequestToServer(String request) {
        try {
            out.writeUTF(request);
            out.flush();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при отправке запроса на сервер.");
        }
    }

    private Object readResponseFromServer() {
        Object response = null;
        try {
            response = in.readObject();
            return response;
        } catch (IOException e) {
            System.out.println("Сервер временно недоступен.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return response;
    }

    private void showResponse(Object response) {
        List<Object> responseList = (List<Object>) response;
        for (Object component : responseList) {
            System.out.println(component);
        }
    }

    private boolean sendCloseRequestToServer() throws IOException {
        out.writeUTF(request);
        out.flush();

        if (in.readUTF().equals("exit")) {
            return true;
        }
        return false;
    }
}

