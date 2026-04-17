import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.*;
import java.util.Scanner;


public class Program {

    // fields needed to access database
    // actual connection to db
    private Connection con = null;
    // object used to issue SQL commands
    private Statement stmt = null;


    static void main() {
        new Program();
    }

    public Program() {
        connectToDB();
        processMenu();

    }

    void processMenu() {
        Menu menu = new Menu("Main menu");
        menu.addChoice(new MenuChoice() {
            @Override
            public String getText() {
                return "View All Albums";
            }

            @Override
            public void run() {
                try {
                    displayAlbums();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        menu.run();
    }

    void displayAlbums() throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Album");

        // Get metadata so we know how many columns there are
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();

        while (rs.next()) {
            // Print each column in the row
            for (int i = 1; i <= columnCount; i++) {
                String columnName = meta.getColumnName(i);
                String value = rs.getString(i);
                System.out.print(columnName + ": " + value + "  ");
            }
            System.out.println(); // new line after each album
        }
    }

    void addAlbum() {

    }

    void editAlbum() {

    }

    void editSong() {

    }
    void deleteSong() {

    }

    public void connectToDB(){

        Scanner scanner = new Scanner(System.in);
        //You may want to remove this
        System.out.println("Establishing connection to database...");

        //You may want to remove this
        System.out.println("   Loading JDBC driver for MS SQL Server database...");
        try {

            //This goes to the class of the new driver
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (Exception e) {
            System.out.printf("   Unable to load JDBC driver... '%s'\n", e.getMessage());
            return;
        }

        //You may want to remove this
        System.out.println("   Use driver to connect to MS SQL Server (OPENBOX\\WRR)...");
        if (true) {
            try {
                System.out.println("   Locate database to open (using connection string)...");

                String connectionString = "jdbc:jtds:sqlserver://postsql.mandela.ac.za/WRAP301Music;instance=WRR";
                System.out.println("      Connection string = " + connectionString);

                System.out.println("Enter username: ");
                String username = scanner.nextLine();
                System.out.println("Enter password: ");
                String password = scanner.nextLine();

                con = DriverManager.getConnection(connectionString, username, password);

                // create statement object for manipulating DB
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                System.out.println("Connected to database...");
            } catch (Exception e) {
                System.out.printf("   Unable to connect to DB... '%s'\n", e.getMessage());
            }

            //I don't think we'll use this part
        } else {
            try {
                // another way of creating a connection to a database
                System.out.println("   Locate database to open (using server data source)...");

                // specify details of connection to be made
                SQLServerDataSource ds = new SQLServerDataSource();
                ds.setUser("WRAP301User");
                ds.setPassword("WRAP301");
                ds.setServerName("postsql.mandela.ac.za");
                ds.setInstanceName("WRR");
                ds.setDatabaseName("WRAP301music");

                // create the connection to the DB
                con = ds.getConnection();

                // create statement object for manipulating DB
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
