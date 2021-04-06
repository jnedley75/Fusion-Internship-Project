package Fusion.Internship.Controller;


import Fusion.Internship.Model.AdminCheck;
import Fusion.Internship.Model.login;
import Fusion.Internship.Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Fusion.Internship.DAO.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;


@Controller
@RequestMapping(value = { "/login" })
public class LoginController {

//    @Autowired
//    private UserDAO userDao;

    @RequestMapping(value = {"/database"})
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @PostMapping
    public ModelAndView submitLogin(@RequestParam(name="username") String username, @RequestParam(name="password") String password, Model model, HttpServletRequest request) throws SQLException {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user = UserServiceImpl.getUser(user);
        boolean adminCheckUser = user.getAdmin();
        AdminCheck AdminCheck = new AdminCheck();
        AdminCheck.setAdminCheck(adminCheckUser);
        AdminCheck.setLoginID(user.getLoginID());

        if(UserServiceImpl.databaseLogin(user).equals("successOld")){
            login login = new login();
            user.setLoggedIn(true);
            login.setMessage("Welcome back " + user.getUsername() + ", you have successfully logged in!");
            model.addAttribute("login", login);
            model.addAttribute("AdminCheck", AdminCheck);
            session.setAttribute("adminStatus", adminCheckUser);
            session.setAttribute("loginMessage",login.getMessage());
            session.setAttribute("loggedStatus", user.getLoggedIn());
            session.setAttribute("username", user.getUsername());
            mv.setViewName("success");
//            if((boolean)session.getAttribute("adminStatus")) {
//                String viewUser = "<form action=\"http://example.com:8080/table\">" +
//                        "<input class=\"showTable\" type=\"submit\" value=\"View Users\"/>" +
//                        "</form>";
//                model.addAttribute("display", viewUser);
//            }
            return mv;
        } else if (UserServiceImpl.databaseLogin(user).equals("successNew")){
            login login = new login();
            user.setLoggedIn(true);
            login.setMessage("Welcome " + user.getUsername() + ", you have successfully logged in!");
            model.addAttribute("login", login);
            session.setAttribute("loginMessage",login.getMessage());
            model.addAttribute("AdminCheck", AdminCheck);
            session.setAttribute("adminStatus", adminCheckUser);
            session.setAttribute("loggedStatus", user.getLoggedIn());
            session.setAttribute("username", user.getUsername());
            mv.setViewName("success");
//            if((boolean)session.getAttribute("adminStatus")) {
//                String viewUser = "<form action=\"http://example.com:8080/table\">" +
//                        "<input class=\"showTable\" type=\"submit\" value=\"View Users\"/>" +
//                        "</form>";
//                model.addAttribute("display", viewUser);
//            }
            return mv;
        } else{
            mv.setViewName("invalid");
            return mv;
        }
    }

    @RequestMapping(value ={"/update"}, method = RequestMethod.POST)
    public String deleteUser(boolean adminStatus, Integer loginID) throws SQLException {
        UserServiceImpl.updateUser(adminStatus, loginID);
        System.out.println(adminStatus);
        return "success";
    }

}
