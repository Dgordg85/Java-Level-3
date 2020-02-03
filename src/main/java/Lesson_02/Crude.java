package Lesson_02;

import java.sql.*;

public class Crude {
    private String tableName = "students";
    private static Connection connection;
    private static PreparedStatement pstmt;

    public Crude() {
        try {
            connect();
            createTableIfNotExists(connection);
            delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(){
        try {
            pstmt = connection.prepareStatement(String.format("SELECT * FROM %s", tableName));
            printResult(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(int id){
        try {
            pstmt = connection.prepareStatement(String.format("SELECT * FROM %s WHERE id = ?", tableName));
            pstmt.setInt(1, id);
            printResult(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String name, int score){
        try {
            pstmt = connection.prepareStatement(String.format("INSERT INTO %s (name, score) VALUES (?, ?)", tableName));

            pstmt.setString(1, name);
            pstmt.setInt(2, score);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String name, int score){
        try {
            pstmt = connection.prepareStatement(String.format("UPDATE %s set name = ?, score = ? WHERE id = ?", tableName));
            pstmt.setString(1, name);
            pstmt.setInt(2, score);
            pstmt.setInt(3 , id);
            infoNoId(id, pstmt.executeUpdate(), false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, int score){
        try {
            pstmt = connection.prepareStatement(String.format("UPDATE %s set score = ? WHERE id = ?", tableName));
            pstmt.setInt(1, score);
            pstmt.setInt(2 , id);
            infoNoId(id, pstmt.executeUpdate(), false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String name){
        try {
            pstmt = connection.prepareStatement(String.format("UPDATE %s set name = ? WHERE id = ?", tableName));
            pstmt.setString(1, name);
            pstmt.setInt(2 , id);
            infoNoId(id, pstmt.executeUpdate(), false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            pstmt = connection.prepareStatement(String.format("DELETE FROM %s WHERE id = ?", tableName));
            pstmt.setInt(1 , id);
            infoNoId(id, pstmt.executeUpdate(), true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        try {
            pstmt = connection.prepareStatement(String.format("DELETE FROM %s", tableName));
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:java3.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void infoNoId(int id, int count, boolean delete){
        String str = (delete) ? "удалить" : "обновить";

        if (count == 0){
            System.out.println(id + " - не удалось " + str + ", отсутствует в базе.");
        }

    }

    private void printResult(PreparedStatement pstmt){
        try {
            ResultSet rs = pstmt.executeQuery();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getMetaData().getColumnName(i) + " ");
            }
            System.out.println();
            while (rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS " + this.tableName + " (\n" +
                    "    id    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    name  TEXT,\n" +
                    "    score INT\n" +
                    ");");
        }
    }
}