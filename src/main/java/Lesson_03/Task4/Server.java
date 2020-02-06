package Lesson_03.Task4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Serializable {

    public static void main(String[] args) {
        Socket socket;
        try(ServerSocket server = new ServerSocket(15000)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = server.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                System.out.println(in.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
