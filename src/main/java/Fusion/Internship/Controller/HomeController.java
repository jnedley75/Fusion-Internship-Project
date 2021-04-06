package Fusion.Internship.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = { "/" })
public class HomeController {

	@GetMapping
	public ModelAndView homeView(HttpServletRequest request)
	{
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(false);
		if(session != null){
			System.out.println("not null");
		}

		model.setViewName("Home");

		return model;
	}

//	@GetMapping("/oidc-principal")
//	public OidcUser getOidcUserPrinciple(@AuthenticationPrincipal OidcUser principle){
//		return principle;
//	}

}
