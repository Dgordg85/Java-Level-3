package Lesson_03;

import java.io.*;
import java.util.ArrayList;

public class FileCarousel {
    private String path = "src/main/java/Lesson_03/";
    private String filename;
    private String fullPath;

    public void createFile(String filename, int size) {
        this.filename = filename + ".txt";
        fullPath = path + this.filename;

        File file = new File(fullPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.writeBytesToFile(file, size);
    }

    private void writeBytesToFile(File file, int size){
        try(FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(getRandArray(size));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] getRandArray(int size){
        byte[] arr = new byte[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (byte) (Math.random() * 255);
        }
        return arr;
    }

    public void printFIle(){
        try(FileInputStream fis = new FileInputStream(this.getFullPath())) {
            byte[] byteArr = new byte[fis.available()];

            while(fis.available() > 0){
                fis.read(byteArr);
            }

            this.printArray(byteArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printArray(byte[] byteArr){
        for (byte b: byteArr){
            System.out.print(b + " ");
        }
        System.out.println();
    }

    public String[] getFilesNames(String reg){
        return new File(path).list((dir, name) -> name.startsWith(reg));
    }

    public String getFullPath() {
        return fullPath;
    }

    public ArrayList<InputStream> getFilesStreamsArrayList(String reg){
        String[] filenameArr = this.getFilesNames(reg);
        ArrayList<InputStream> list = new ArrayList<>();
        try {
            for (String s : filenameArr){
                list.add(new FileInputStream(new File(path + s)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getPath() {
        return path;
    }
}
