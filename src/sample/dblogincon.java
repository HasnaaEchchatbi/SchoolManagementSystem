package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class dblogincon {
    public Connection databaselink;
    public Connection getConnection(){
        String databaseName="jdbc-connecttt";
        String databseUser="root";
        String databasePassword="toor";
        String url="jdbc:mysql://localhost/" +databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url,databseUser,databasePassword);

        }catch (Exception e){
           e.printStackTrace();
           e.getCause();
        }
        return databaselink;
    }
}
