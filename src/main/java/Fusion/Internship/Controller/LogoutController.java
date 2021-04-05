package Fusion.Internship.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/logout"})
public class LogoutController {
    @GetMapping
    public ModelAndView logout(HttpServletRequest request){
        System.out.println("we in this bitch");
        HttpSession session = request.getSession(false);
        ModelAndView mv = new ModelAndView();
        session.invalidate();
        mv.setViewName("Home");
        return mv;
    }
}
