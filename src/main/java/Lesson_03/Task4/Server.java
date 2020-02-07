package Lesson_03.Task4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() {
        Socket socket = null;
        ServerSocket server = null;
        DataInputStream in = null;
        ByteArrayOutputStream baos = null;
        Human humanCopy = null;
        final byte[] buf = new byte[16384];
        int numRead;

        try {
            server = new ServerSocket(15000);
            System.out.println("Сервер запущен, ожидаем подключения...");

            socket = server.accept();
            System.out.println("Клиент подключился");

            in = new DataInputStream(socket.getInputStream());
            baos = new ByteArrayOutputStream();

            while ((numRead = in.read(buf, 0, buf.length)) != -1) {
               baos.write(buf, 0, numRead);
            }

            try {
                humanCopy = (Human)convertFromBytes(baos.toByteArray());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            humanCopy.getInfo();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                baos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private Object convertFromBytes(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }
}
