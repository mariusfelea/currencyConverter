package currencyConverter.com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import currencyConverter.com.model.User;
import currencyConverter.com.service.UserService;
import currencyConverter.enums.CountryEnum;

@Controller
public class RegistrationController {
	
	public static final String CONFIRM_PASSWORD_ERROR = "Please confirm your password!";
	public static final String MAIL_DOUBLED_ERROR = "Email already exists!"; 
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/registrationView")
	public ModelAndView registrationView() {
		ModelAndView model = new ModelAndView("registrationView", "user", new User());
		model.addObject("countries", CountryEnum.values());
		return model;
	}
	
	@RequestMapping(value = "/addRegistration", method = RequestMethod.POST)
	public ModelAndView addNewUser(@Valid @ModelAttribute("user") User user, BindingResult result) {	
		ModelAndView model = new ModelAndView("registrationView", "user", user);
		model.addObject("countries", CountryEnum.values());
		if (!result.hasErrors()) {
			if (!userService.userAlreadyRegistered(user.getMail())) {
				if (user.getPassword().equals(user.getPasswordConfirm())) {
					userService.save(user);
					model = new ModelAndView("loginView");
				} else {
					model.addObject("errorConfirmPassword", CONFIRM_PASSWORD_ERROR);
				}
			} else {
				model.addObject("errorMailDoubled", MAIL_DOUBLED_ERROR);
			}
		}
		return model;
	}
	
}
