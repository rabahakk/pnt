package utility;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectDB {

    Properties prop = Utility.loadProp();
    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    public Connection connectToSqlDatabase() {
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        try {
            Class.forName(driverClass);
            connect = DriverManager.getConnection(url,userName,password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Database is connected");
        return connect;
    }

    public  MongoDatabase mongoDatabase = null;

    public MongoDatabase connectToMongoDB() {
        MongoClient mongoClient = new MongoClient("" , 27017);
        mongoDatabase = mongoClient.getDatabase("");
        System.out.println("Database Connected");

        return mongoDatabase;
    }

    public List<String> getTableColumnData(String query, String columnName) {
        List<String> list = new ArrayList<>();
        try {
            statement = connectToSqlDatabase().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                list.add(resultSet.getString(columnName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        ConnectDB connectDB = new ConnectDB();
        List<String> emails = connectDB.getTableColumnData("select * from cred;","email");
        System.out.println(emails.get(0));
    }
}
