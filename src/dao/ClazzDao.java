package dao;

import db.DbUtil;
import model.Clazz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClazzDao {
    //增加
    public void addClazz(Clazz clazz) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql
        String sql = "INSERT INTO clazz(clazz_name, clazz_alias, is_special, school, major, setup_date, monitor, secretary, commis_study, teacher, qq, wechat, number, number_girl, honors, current_balance )"
                +"values("+"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
//        ptmt.setInt(1, clazz.getId());
        ptmt.setString(1, clazz.getClazzName());
        ptmt.setString(2, clazz.getClazzAlias());
        ptmt.setInt(3, clazz.getIsSpecial());
        ptmt.setString(4, clazz.getSchool());
        ptmt.setString(5, clazz.getMajor());
        ptmt.setDate(6, (Date) clazz.getSetupDate());
        ptmt.setString(7, clazz.getMonitor());
        ptmt.setString(8, clazz.getSecretary());
        ptmt.setString(9, clazz.getCommisStudy());
        ptmt.setString(10, clazz.getTeacher());
        ptmt.setString(11, clazz.getQq());
        ptmt.setString(12, clazz.getWechat());
        ptmt.setInt(13, clazz.getNumber());
        ptmt.setInt(14, clazz.getNumberGirl());
        ptmt.setString(15, clazz.getHonors());
        ptmt.setDouble(16, clazz.getCurrentBalance());

        //执行
        ptmt.execute();
    }

    public void updateClazz(Clazz clazz) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql
        String sql = "UPDATE clazz" +
                " set clazz_name=?, clazz_alias=?, is_special=?, school=?, major=?, setup_date=?, monitor=?, secretary=?, commis_study=?, teacher=?, qq=?, wechat=?, number=?, number_girl=?, honors=?, current_balance=?"+
                " where id=?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
        ptmt.setString(1, clazz.getClazzName());
        ptmt.setString(2, clazz.getClazzAlias());
        ptmt.setInt(3, clazz.getIsSpecial());
        ptmt.setString(4, clazz.getSchool());
        ptmt.setString(5, clazz.getMajor());
        ptmt.setDate(6, (Date) clazz.getSetupDate());
        ptmt.setString(7, clazz.getMonitor());
        ptmt.setString(8, clazz.getSecretary());
        ptmt.setString(9, clazz.getCommisStudy());
        ptmt.setString(10, clazz.getTeacher());
        ptmt.setString(11, clazz.getQq());
        ptmt.setString(12, clazz.getWechat());
        ptmt.setInt(13, clazz.getNumber());
        ptmt.setInt(14, clazz.getNumberGirl());
        ptmt.setString(15, clazz.getHonors());
        ptmt.setDouble(16, clazz.getCurrentBalance());
        ptmt.setInt(17, clazz.getId());

        //执行
        ptmt.execute();
    }

    public void deleteClazz(Clazz clazz) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql
        String sql = "delete from clazz where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //传参
        ptmt.setInt(1, clazz.getId());

        //执行
        ptmt.execute();
    }

    public List<Clazz> queryClazz(String clazzName) throws SQLException {
        Connection conn = DbUtil.getConnection();
        Statement stmt = conn.createStatement();
        String sql="select * from clazz where clazz_name like '%" + clazzName + "%'";
        ResultSet rs = stmt.executeQuery(sql);

        List<Clazz> clazzList = new ArrayList<Clazz>();
        while(rs.next()){
            Clazz clazz = new Clazz();
            clazz.setId(rs.getInt("id"));
            clazz.setClazzName(rs.getString("clazz_name"));
            clazz.setClazzAlias(rs.getString("clazz_alias"));
            clazz.setIsSpecial(rs.getInt("is_special"));
            clazz.setSchool(rs.getString("school"));
            clazz.setMajor(rs.getString("major"));
            clazz.setSetupDate(rs.getDate("setup_date"));
            clazz.setMonitor(rs.getString("monitor"));
            clazz.setSecretary(rs.getString("secretary"));
            clazz.setCommisStudy(rs.getString("commis_study"));
            clazz.setTeacher(rs.getString("teacher"));
            clazz.setQq(rs.getString("qq"));
            clazz.setWechat(rs.getString("wechat"));
            clazz.setNumber(rs.getInt("number"));
            clazz.setNumberGirl(rs.getInt("number_girl"));
            clazz.setHonors(rs.getString("honors"));
            clazz.setCurrentBalance(rs.getDouble("current_balance"));

            clazzList.add(clazz);
        }
        return clazzList;
    }

}