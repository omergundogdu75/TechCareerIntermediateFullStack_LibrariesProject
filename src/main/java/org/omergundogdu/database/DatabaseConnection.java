package org.omergundogdu.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class
public class DatabaseConnection extends DatabaseInformation {

    // Field
    private final String url = super.getUrl();
    private String user = super.getUser();
    private String password = super.getPassword();
    private String forNameData = super.getForNameData();

    // For Database
    private Connection connection; // import java.sql.Connection;

    // Design Pattern (Creational Singleton design Pattern (Class)
    private static DatabaseConnection instance;

    // Singleton design Pattern (Constructor)
    private DatabaseConnection() {
        try {
            Class.forName(this.forNameData);
            System.out.println("Database Class Yüklendi");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database bağlantısı başarıılı");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Dış dünyaya açılacak metot sadece bu
    public static DatabaseConnection getInstance() {
        try {
            // Eğer connection null veya kapalı ise
            // yeni instance oluştur
            if (instance == null || instance.connection.isClosed()) {
                instance = new DatabaseConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    // GÖVDESİZ METOT GELEN
    @Override
    public void databaseInfo() {
        System.out.println("Database Information: " + super.getUrl() + " " + super.getForNameData() + " " + super.getPassword() + " " + super.getUser());
    }

    // GETTER AND SETTER
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // TEST
    public static void main(String[] args) {
        //DatabaseConnection databaseConnection = new DatabaseConnection();
    }
} //end class