package currencyConverter.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import currencyConverter.com.model.User;

@Controller
public class LoginController {

	public static final String ERROR_LOGIN = "Invalid username and password!";
	public static final String MESSAGE_LOGIN = "You've been logged out successfully.";
	
	@RequestMapping("/loginView")
	public ModelAndView loginView(@ModelAttribute("user") User user) {

		ModelAndView view = new ModelAndView("loginView");
		return view;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", ERROR_LOGIN);
		}
		if (logout != null) {
			model.addObject("msg", MESSAGE_LOGIN);
		}
		model.setViewName("loginView");
		return model;
	}
	
}
