package by.epamtc.textprocessing.server.controller;

import by.epamtc.textprocessing.server.controller.handler.UserCommandHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketRunner {
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public static void main(String[] args) {
        ServerSocketRunner serverRequestDispatcher = new ServerSocketRunner();
        serverRequestDispatcher.startServer();
    }

    private void startServer() {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Сервер запущен.");

            Socket serverSocket = server.accept();

            in = new ObjectInputStream(serverSocket.getInputStream());
            out = new ObjectOutputStream(serverSocket.getOutputStream());

            String userRequest = readClientRequest();
            Object response;

            while (!userRequest.equals("exit")) {
                response = executeUserRequest(userRequest);
                sentResponseToClient(response);
                userRequest = readClientRequest();
            }

            sendCloseConnectionToClient();
            System.out.println("Серверное соединение успешно закрыто.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendCloseConnectionToClient() throws IOException {
        out.writeUTF("exit");
        out.flush();
    }

    private String readClientRequest() throws IOException {
        return in.readUTF();
    }

    private Object executeUserRequest(String userCommand) {
        String[] command = userCommand.split("#");
        Object response;

        if (command.length > 1) {
            response = UserCommandHandler.executeUserCommand(command[1]);
        } else {
            response = UserCommandHandler.executeUserCommand(userCommand);
        }
        return response;
    }

    private void sentResponseToClient(Object response) throws IOException {
        out.writeObject(response);
        out.flush();
    }
}
