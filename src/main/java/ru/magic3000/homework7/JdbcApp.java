package ru.magic3000.homework7;

import java.sql.*;

public class JdbcApp {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connect();
            createTableEx();
            //clearTableEx();
            insertEx();
            psBatchEx();
            transactionEx("Portal", 2007, 90);
            //readEx();
            getFromTableByYear(2005);
            getFromTableByRating(70);
            readEx();
            updateRatingByName(100, "Witcher 3");
            readEx();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void connect() throws SQLException {
        System.out.println("Opening DB connection");
        connection = DriverManager.getConnection("jdbc:sqlite:hw7db.db");
        statement = connection.createStatement();
        System.out.println("Connected");
    }

    private static void createTableEx() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Games (\n" +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " Name TEXT,\n" +
                " Year INTEGER,\n" +
                " Rating INTEGER\n" +
                " );");
        System.out.println("Table created");
    }

    private static void readEx() throws SQLException {
        System.out.println("Table records:");
        try (ResultSet rs = statement.executeQuery("SELECT * FROM Games;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getString("Name") + " " +
                        rs.getInt("Year") + " " +
                        rs.getInt("Rating"));
            }
        }
    }

    private static void insertEx() throws SQLException {
        statement.executeUpdate("INSERT INTO Games (Name, Year, Rating  ) VALUES ('Portal', 2007, 90);");
        statement.executeUpdate("INSERT INTO Games (Name, Year, Rating) VALUES ('Witcher 3', 2015, 92);");
        statement.executeUpdate("INSERT INTO Games (Name, Year, Rating) VALUES ('Cyberpunk 2077', 2020, 86);");
        statement.executeUpdate("INSERT INTO Games (Name, Year, Rating) VALUES ('Grand Theft Auto V', 2014, 97);");
        System.out.println("Values inserted to table");
    }

    private static void clearTableEx() throws SQLException {
        statement.executeUpdate("DELETE FROM Games;");
        System.out.println("Table cleared");
    }

    private static void psBatchEx() {
        try (PreparedStatement prepInsert = connection.prepareStatement("INSERT INTO Games(Name, Year, Rating) VALUES(?,?,?)")) {
            for (int i = 1; i <= 10; i++) {
                prepInsert.setString(1, "GameName_" + i);
                prepInsert.setInt(2, i + 2000);
                prepInsert.setInt(3, i * 10);
                prepInsert.addBatch();
            }
            int[] result = prepInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Batch values inserted to table");
    }

    private static void transactionEx(String name, int year, int rating) throws SQLException {
        System.out.println("transactionEx");
        connection.setAutoCommit(false);
        try {
            statement.execute("INSERT INTO Games (Name, Year, Rating) values ('" + name + "', " + year + ", " + rating + ")");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
        System.out.println("Value inserted to table");
    }

    private static void getFromTableByYear(int year) throws SQLException {
        System.out.println("Records with year > " + String.valueOf(year));
        try (ResultSet rs = statement.executeQuery("SELECT * FROM Games WHERE Year > " + String.valueOf(year) + ";")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getString("Name") + " " +
                        rs.getInt("Year") + " " +
                        rs.getInt("Rating"));
            }
        }
    }

    private static void getFromTableByRating(int rating) throws SQLException {
        System.out.println("Records with rating <= " + String.valueOf(rating));
        try (ResultSet rs = statement.executeQuery("SELECT * FROM Games WHERE Rating <= " + String.valueOf(rating) + ";")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getString("Name") + " " +
                        rs.getInt("Year") + " " +
                        rs.getInt("Rating"));
            }
        }
    }

    private static void updateRatingByName(int rating, String name) throws SQLException {
        System.out.println("Rating set on " + rating + " for record with Name " + name);
        statement.executeUpdate("UPDATE Games SET Rating = " + rating + " WHERE Name = '" + name + "'");
    }

    private static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
