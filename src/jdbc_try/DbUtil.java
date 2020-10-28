package jdbc_try;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil {

    public static void main(String[] args) throws Exception {
        // 1. 加载驱动程序
        Class.forName(Parameter.JDBC_DRIVER);
        // 2.获得数据库连接
        Connection conn = DriverManager.getConnection(Parameter.DB_URL,Parameter.USER,Parameter.PWD);
        // 3.操作数据库，实现增删查改
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery("select studentId,studentName from student");
        while(rs.next()){
            System.out.println("学号:"+ rs.getInt("studentId")+ "  名字:"+rs.getString("studentName"));
        }
    }
}
