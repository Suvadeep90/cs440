package Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Memo on 2/7/16.
 */
public class Login extends Business{
    private String user;
    private String pwd;

    PreparedStatement stm;
    ResultSet res;


    public Login(String u, String p) throws Exception{
        super();

        this.user = u;
        this.pwd = p;
    }

    public boolean validate(){
        boolean validation = false;

        try
        {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);
            stm = connection.prepareStatement
                                    ("SELECT username, password FROM users WHERE username=? and password=?");

            stm.setString(1,user);
            stm.setString(2,pwd);

            res = stm.executeQuery();
            validation = res.next();
        }
        catch(Exception ex)
        {
            System.out.println("Debug: "+ex);
        }
        finally
        {
            closeConnections();
        }

        return validation;
    }

    private void closeConnections()
    {
        if (connection != null) {
            try{
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (stm != null) {
            try{
                stm.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (res != null) {
            try{
                res.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
