package servlet.clazz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;

import dao.ClazzDao;
import model.Clazz;

@WebServlet(name = "servlet.clazz.AddClazz", urlPatterns = "/api/clazz/add")
public class AddClazz extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取表单数据
//        int id = Integer.parseInt(req.getParameter("id"));
        String clazzName = req.getParameter("clazzName");
        String clazzAlias = req.getParameter("clazzAlias");
        int isSpecial = Integer.parseInt(req.getParameter("isSpecial"));
        String school = req.getParameter("school");
        String major = req.getParameter("major");
        Date setupDate = Date.valueOf(req.getParameter("setupDate"));
        String monitor = req.getParameter("monitor");
        String secretary = req.getParameter("secretary");
        String commisStudy = req.getParameter("commisStudy");
        String teacher = req.getParameter("teacher");
        String qq = req.getParameter("qq");
        String wechat = req.getParameter("wechat");
        int number = Integer.parseInt(req.getParameter("number"));
        int numberGirl = Integer.parseInt(req.getParameter("numberGirl"));
        String honors = req.getParameter("honors");
        double currentBalance = Double.parseDouble(req.getParameter("currentBalance"));

        // 去dao层进行操作
        try {
            Clazz clazz = new Clazz();
//            clazz.setId(id);
            clazz.setClazzName(clazzName);
            clazz.setClazzAlias(clazzAlias);
            clazz.setIsSpecial(isSpecial);
            clazz.setSchool(school);
            clazz.setMajor(major);
            clazz.setSetupDate(setupDate);
            clazz.setMonitor(monitor);
            clazz.setSecretary(secretary);
            clazz.setCommisStudy(commisStudy);
            clazz.setTeacher(teacher);
            clazz.setQq(qq);
            clazz.setWechat(wechat);
            clazz.setNumber(number);
            clazz.setNumberGirl(numberGirl);
            clazz.setHonors(honors);
            clazz.setCurrentBalance(currentBalance);

            new ClazzDao().addClazz(clazz);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 返回数据
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Map<String,Object> resMap = new HashMap<>();    // 使用Map存储键值对
        resMap.put("success",true);
        resMap.put("data", "添加成功");
        String resJSON = JSON.toJSONString(resMap);     // 转换为json
        out.print(resJSON); // 输出
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}  