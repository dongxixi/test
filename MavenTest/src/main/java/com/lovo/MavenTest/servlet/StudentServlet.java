package com.lovo.MavenTest.servlet;

import com.lovo.MavenTest.Service.IStudentService;
import com.lovo.MavenTest.Service.impl.StudentServiceImpl;
import com.lovo.MavenTest.bean.Student;
import com.lovo.MavenTest.bean.StudentSelect;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String grade = request.getParameter("grade");
        String sex = request.getParameter("sex");
        String min = request.getParameter("scoremin");
        String max = request.getParameter("scoremax");
        int scoreMin = Integer.parseInt(min == "" ? "0" : min);
        int scoreMax = Integer.parseInt(max == "" ? "0" : max);
        int pageNo = Integer.parseInt(request.getParameter("pageno"));

        StudentSelect studentSelect = new StudentSelect(grade, sex, scoreMin, scoreMax);

        IStudentService ss = new StudentServiceImpl();
        int total = ss.getTotalPage(studentSelect);
        int pageTotal = total % 5 == 0 ? total / 5 : total / 5 + 1;


        class sendBean{
            private int pagetotal;
            private List<Student> list;

            public sendBean() {
            }

            public sendBean(int pagetotal, List<Student> list) {
                this.pagetotal = pagetotal;
                this.list = list;
            }

            public int getPagetotal() {
                return pagetotal;
            }

            public void setPagetotal(int pagetotal) {
                this.pagetotal = pagetotal;
            }

            public List<Student> getList() {
                return list;
            }

            public void setList(List<Student> list) {
                this.list = list;
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), new sendBean(pageTotal, ss.getlist(studentSelect, pageNo, 5)));

    }
}
