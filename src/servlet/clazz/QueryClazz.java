package servlet.clazz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;

import dao.ClazzDao;
import model.Clazz;


@WebServlet(name = "servlet.clazz.QueryClazz", urlPatterns = "/api/clazz/query")
public class QueryClazz<fullName> extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 查询条件
        String clazzName = req.getParameter("clazzName");
        if (clazzName == null) {
            clazzName = "";
        }

        // dao层查询
        List<Clazz> clazzList = null;
        try {
            clazzList = new ClazzDao().queryClazz(clazzName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 返回数据
        resp.setContentType("text/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Map<String,Object> resMap = new HashMap<>();    // 使用Map存储键值对
        resMap.put("success",true);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("clazzList", clazzList);
        resMap.put("data", dataMap);
        String resJSON = JSON.toJSONString(resMap);     // 转换为json
        out.print(resJSON); // 输出
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}