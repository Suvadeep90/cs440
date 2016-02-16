package Connection;

import java.sql.Connection;


public class Business {
    protected String DB_URL = "jdbc:mysql://localhost:3306/cs440";
    protected String USER = "suvadeep";
    protected String PWD = "suvadeep"; // or whatever password your MySql has set
    private String DRIVER = "com.mysql.jdbc.Driver";

    protected Connection connection;

    public Business() throws Exception
    {
        try
        {
            Class.forName(DRIVER).newInstance();
        }
        catch (IllegalAccessException ex)
        {
            System.out.println("DB error, illegal access");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("DB error, class not found");
        }
    }
}
