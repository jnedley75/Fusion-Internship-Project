package Fusion.Internship.Controller;

import Fusion.Internship.DAO.User;
import Fusion.Internship.DAO.UserDAOImpl;
import Fusion.Internship.Model.AdminCheck;
import Fusion.Internship.Model.login;
import Fusion.Internship.Service.UserServiceImpl;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


@Controller
@RequestMapping(value = {"/success"})
public class SuccessController {
    static Date date = new Date();
    static long time = date.getTime();
    static private Timestamp lastLogin = new Timestamp(time);

    @GetMapping
    public ModelAndView successView(HttpServletRequest request, Model model){
        ModelAndView mv = new ModelAndView();
        try {
            HttpSession session = request.getSession(false);
            login login = new login();
            login.setMessage((String)session.getAttribute("loginMessage"));
            model.addAttribute("login", login);
        }
        catch (Exception e){
            mv.setViewName("success");
        }

        mv.setViewName("success");


        return mv;
    }

    @GetMapping(value = {"/google"})
    //@SessionAttribute("adminStatus")
    public String successGoogleView(HttpServletRequest request, Model model) throws SQLException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken)request.getUserPrincipal();
        User newGoogleUser = new User();
        newGoogleUser.setEmail((String)token.getPrincipal().getAttributes().get("email"));
        String email = (String)token.getPrincipal().getAttributes().get("email");
        int index = email.indexOf("@");
        String username = email.substring(0, index);
        HttpSession session = request.getSession();
        newGoogleUser.setUsername(username);
        newGoogleUser.setLastLogin(lastLogin);

        if(UserServiceImpl.googleLogin(newGoogleUser).equals("successNew")){
            login login = new login();
            newGoogleUser.setLoggedIn(true);
            String name = (String)token.getPrincipal().getAttributes().get("given_name");
            login.setMessage("Welcome "+name+", you have successfully logged in with Google!");
            model.addAttribute("login", login);
            session.setAttribute("adminStatus", newGoogleUser.getAdmin());
            session.setAttribute("loginMessage",login.getMessage());
            session.setAttribute("loggedStatus", newGoogleUser.getLoggedIn());
            return "success";
        } else{
            String name = (String)token.getPrincipal().getAttributes().get("given_name");
            login login = new login();
            newGoogleUser.setLoggedIn(true);
            login.setMessage("Welcome back "+name+", you have successfully logged in with Google!");
            model.addAttribute("login", login);
            User temp = UserDAOImpl.getUser(newGoogleUser);
            boolean adminCheckUser = temp.getAdmin();
            AdminCheck AdminCheck = new AdminCheck();
            AdminCheck.setAdminCheck(adminCheckUser);
            AdminCheck.setLoginID(temp.getLoginID());
            model.addAttribute("AdminCheck", AdminCheck);
            session.setAttribute("adminStatus", adminCheckUser);
            session.setAttribute("loginMessage",login.getMessage());
            session.setAttribute("loggedStatus", newGoogleUser.getLoggedIn());
//            if((boolean)session.getAttribute("adminStatus")){
//                String viewUser = "<form action=\"http://example.com:8080/table\">" +
//                        "<input class=\"showTable\" type=\"submit\" value=\"View Users\"/>" +
//                        "</form>";
//                model.addAttribute("display", viewUser);
//            }
            return "success";
        }
    }

    @RequestMapping(value ={"/update"}, method = RequestMethod.POST)
    public String deleteUser(boolean adminStatus, Integer loginID) throws SQLException {
        UserServiceImpl.updateUser(adminStatus, loginID);
        return "success";
    }

}
