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

@WebServlet(name = "servlet.clazz.DeleteClazz", urlPatterns = "/api/clazz/delete")
public class DeleteClazz extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取表单数据
        int id = Integer.parseInt(req.getParameter("id"));

        // 去dao层进行操作
        try {
            Clazz clazz = new Clazz();
            clazz.setId(id);
            new ClazzDao().deleteClazz(clazz);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 返回数据
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Map<String,Object> resMap = new HashMap<>();    // 使用Map存储键值对
        resMap.put("success",true);
        resMap.put("data", "删除成功");
        String resJSON = JSON.toJSONString(resMap);     // 转换为json
        out.print(resJSON); // 输出
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}