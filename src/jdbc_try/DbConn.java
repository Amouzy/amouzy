package jdbc_try;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
    private static Connection conn = null;

    static {
        try{
            // 1. 加载驱动程序
            Class.forName(Parameter.JDBC_DRIVER);
            // 2. 获取数据库连接
            conn = DriverManager.getConnection(Parameter.DB_URL,Parameter.USER,Parameter.PWD);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }
}
