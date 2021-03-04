package Fusion.Internship.Controller;

import Fusion.Internship.DAO.User;
import Fusion.Internship.Service.UserServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping(value = { "/register" })
public class RegisterController {

    @RequestMapping(value = {"/database"})
    public ModelAndView registerView() {
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        return model;
    }

    @PostMapping
    public ModelAndView register(@RequestParam(name="email") String email, @RequestParam(name="username") String username,
                                 @RequestParam(name="password") String password, @RequestParam(name="age") int age,
                                 @RequestParam(name="gender") String gender, Model model) throws SQLException {


        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        user.setGender(gender);

        String result = UserServiceImpl.registerUser(user);

        mv.setViewName(result);

        return mv;
    }
}
