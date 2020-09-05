package dao;

import db.DbUtil;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    //增加
    public void addStudent(Student student) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql
        String sql = "INSERT INTO student( sno, name, student_id )"
                +"values("+"?,?,?)";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
        ptmt.setInt(1, student.getSno());
        ptmt.setString(2, student.getName());
        ptmt.setInt(3, student.getClazzId());

        //执行
        ptmt.execute();
    }

    public void updateStudent(Student student) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql
        String sql = "UPDATE student" +
                " set name=?, student_id=?"+
                " where sno=?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
        ptmt.setString(1, student.getName());
        ptmt.setInt(2, student.getClazzId());
        ptmt.setInt(3, student.getSno());

        //执行
        ptmt.execute();
    }

    public void deleteStudent(Student student) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql
        String sql = "delete from student where sno=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //传参
        ptmt.setInt(1, student.getSno());

        //执行
        ptmt.execute();
    }

    public List<Student> queryStudent(String name) throws SQLException {
        Connection conn = DbUtil.getConnection();
        Statement stmt = conn.createStatement();
        String sql="select * from student where student_name like '%" + name + "%'";
        ResultSet rs = stmt.executeQuery(sql);

        List<Student> studentList = new ArrayList<Student>();
        while(rs.next()){
            Student student = new Student();
            student.setSno(rs.getInt("sno"));
            student.setName(rs.getString("name"));
            student.setClazzId(rs.getInt("clazz_id"));

            studentList.add(student);
        }
        return studentList;
    }

}