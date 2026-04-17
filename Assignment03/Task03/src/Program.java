import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.*;


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


    }

    public void connectToDB(){

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

                String connectionString = "jdbc:jtds:sqlserver://postsql.mandela.ac.za/WRPV301;instance=WRR";
                System.out.println("      Connection string = " + connectionString);

                // create connection to DB, including username & password
                // NEVER, EVER, include a username and password in your code!!!!
                con = DriverManager.getConnection(connectionString, "WRPV301User", "WRPV301");

                // create statement object for manipulating DB
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
