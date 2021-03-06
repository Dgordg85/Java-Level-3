package Lesson_03.Task4;

import java.io.*;
import java.net.Socket;

public class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 15000;

    private Socket socket;
    private DataOutputStream out;

    public static void main(String[] args) throws IOException {
        Human anatoliy = new Human("Анатолий", "Попов", 25);
        Human larisa = new Human("Лариса", "Абрамова", 22);
        anatoliy.setFriend(larisa);


        Client client = new Client();
        byte[] anatoliyBytes = client.convertToBytes(anatoliy);
        client.out.write(anatoliyBytes);
        client.closeConnection();

    }

    public Client() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        out = new DataOutputStream(socket.getOutputStream());
    }

    public void closeConnection() {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] convertToBytes(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return bos.toByteArray();
        }
    }

}
