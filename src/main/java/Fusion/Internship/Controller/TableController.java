package Fusion.Internship.Controller;

import Fusion.Internship.DAO.User;
import Fusion.Internship.Service.UserService;
import Fusion.Internship.Service.UserServiceImpl;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping(value = {"/table"})
public class TableController {

    @GetMapping
    public ModelAndView tableView(HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        try {
            HttpSession session = request.getSession(false);
            if((boolean)session.getAttribute("adminStatus")){
                model.setViewName("table");
            }
            else if(!(boolean)session.getAttribute("adminStatus")){
                model.setViewName("success");
            }
        }
        catch(Exception e){
            model.setViewName("Home");
        }

        return model;
    }

    @GetMapping(value = {"/showTable"})
    @ResponseBody
    public ArrayList<User> showUserTable() throws SQLException {
        return UserServiceImpl.showUserTable();
    }

    @RequestMapping(value ={"/delete"}, method = RequestMethod.POST)
    public String deleteUser(Integer data) throws SQLException {
        System.out.println("We in here");
        int loginID = data;
        UserServiceImpl.deleteUser(loginID);
        return "table";
    }

}
