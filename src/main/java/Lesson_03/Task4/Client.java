package Lesson_03.Task4;

import java.io.*;
import java.net.Socket;

public class Client implements Serializable {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 15000;

    private Socket socket;
    private DataOutputStream out;

    public static void main(String[] args) throws IOException {
        Human anatoliy = new Human("Анатолий", "Попов", 25);
        Human larisa = new Human("Лариса", "Абрамова", 22);
        anatoliy.setFriend(larisa);

        OutputStream stream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                
            }
        }
        ObjectOutputStream oos = new ObjectOutputStream()
        anatoliy.
        Client client = new Client();


        client.out.writeUTF("BRHR");
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


}
