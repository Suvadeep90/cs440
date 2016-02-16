package Connection;

import java.sql.*;

public class Register extends Business{
    private PreparedStatement stm;
    private Statement in_stm;
    private ResultSet res;

    public Register() throws Exception{
        super();
    }

    public boolean doRegistration(String n, String l, String e, String u, String p, String s){
        boolean valid = false;

        if (!checkDuplicates(u,e)){
            try {
                String qry = "INSERT INTO users(firstname, lastname, email, username, password, sex) " +
                             "VALUES ('"+n+"','"+l+"','"+e+"','"+u+"','"+p+"','"+s+"');";
                connection = DriverManager.getConnection(DB_URL, USER, PWD);
                in_stm = connection.createStatement();

                in_stm.executeUpdate(qry);

                valid = true;
            }
            catch (Exception ex){
                System.out.println(ex);
            }
            finally {
                closeConnections();
            }
        }

        return valid;
    }

    // Checks username and email duplicates, returns false if no duplicates were found.
    public boolean checkDuplicates(String u, String e){
        boolean status = false;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);
            stm = connection.prepareStatement("SELECT username, email FROM users WHERE username=? and email=?");
            stm.setString(1,u);
            stm.setString(2,e);

            res = stm.executeQuery();
            status = res.next();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        finally {
            closeConnections();
        }

        return status;
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
