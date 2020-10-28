package jdbc_try;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public void addStudent(Student student) throws SQLException{
        // 1. 获取连接
        Connection conn = DbConn.getConn();
        // 2. sql语句
        String sql = "INSERT INTO student (studentId,studentName,grade,major,clazz,institute,tel,email,pwd,cardId,sex,role) " +
                "value (?,?,?,?,?,?,?,?,?,?,?,?)";
        // 3. 预编译
        PreparedStatement pst = conn.prepareStatement(sql);
        // 4. 传参
        pst.setInt(1,student.getStudentId());
        pst.setString(2,student.getStudentName());
        pst.setString(3,student.getGrade());
        pst.setString(4,student.getMajor());
        pst.setString(5,student.getClazz());
        pst.setString(6,student.getInstitute());
        pst.setString(7,student.getTel());
        pst.setString(8,student.getEmail());
        pst.setString(9,student.getPwd());
        pst.setString(10,student.getCardId());
        pst.setString(11,student.getSex());
        pst.setString(12,student.getRole());
        // 5. 执行
        pst.execute();
    }

    public void updateStudent(Student student) throws SQLException {
        Connection conn = DbConn.getConn();
        String sql = "update student set studentName=?," +
                "grade=?,major=?,clazz=?,institute=?,tel=?,email=?,pwd=?,cardId=?,sex=?,role=? where studentId=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        // 4. 传参
        pst.setInt(1,student.getStudentId());
        pst.setString(2,student.getStudentName());
        pst.setString(3,student.getGrade());
        pst.setString(4,student.getMajor());
        pst.setString(5,student.getClazz());
        pst.setString(6,student.getInstitute());
        pst.setString(7,student.getTel());
        pst.setString(8,student.getEmail());
        pst.setString(9,student.getPwd());
        pst.setString(10,student.getCardId());
        pst.setString(11,student.getSex());
        pst.setString(12,student.getRole());
        // 5. 执行
        pst.execute();
    }

    public void delStudent(Student student) throws SQLException{
        Connection conn = DbConn.getConn();
        String sql = "delete from student where studentId=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,student.getStudentId());
        pst.execute();
    }

    public List<Student> query() throws SQLException{
        Connection conn = DbConn.getConn();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select studentId,studentName from student");
        List<Student> students = new ArrayList<Student>();
        Student student = null;
        while (rs.next()){
            student = new Student();
            student.setStudentId(rs.getInt("studentId"));
            student.setStudentName(rs.getString("studentName"));

            students.add(student);
        }
        return students;
    }

    public Student get() throws SQLException{
        Student student = null;
        Connection conn = DbConn.getConn();
        String sql = "select * from student where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,student.getStudentId());
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            student = new Student();
            student.setStudentId(rs.getInt("StudentId"));
            student.setStudentName(rs.getString("StudentName"));
            student.setGrade(rs.getString("Grade"));
            student.setMajor(rs.getString("Major"));
            student.setClazz(rs.getString("Clazz"));
            student.setInstitute(rs.getString("Institute"));
            student.setTel(rs.getString("Tel"));
            student.setEmail(rs.getString("Email"));
            student.setPwd(rs.getString("Pwd"));
            student.setCardId(rs.getString("CardId"));
            student.setSex(rs.getString("Sex"));
            student.setRole(rs.getString("Role"));

        }
        return student;
    }
}
