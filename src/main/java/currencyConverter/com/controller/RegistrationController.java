package currencyConverter.com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import currencyConverter.com.model.Registration;
import currencyConverter.com.service.RegistrationService;
import currencyConverter.enums.CountryEnum;

@Controller
public class RegistrationController {
	public static final String CONFIRM_PASSWORD_ERROR = "Please confirm your password!";

	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping("/registrationView")
	public ModelAndView registrationView() {
		
		ModelAndView model = new ModelAndView("registrationView", "registration", new Registration());
		model.addObject("countries", CountryEnum.values());
		return model;
	}
	
	@RequestMapping(value = "/addRegistration", method = RequestMethod.POST)
	public ModelAndView addNewUser(@Valid @ModelAttribute("registration") Registration registration, BindingResult result) {
		
		ModelAndView model = new ModelAndView("registrationView");
		model.addObject("countries", CountryEnum.values());
		if (!result.hasErrors()) {
			if (registration.getPassword().equals(registration.getPasswordConfirm())) {
				registrationService.save(registration);
				model = new ModelAndView("loginView");
			} else {
				model.addObject("err", CONFIRM_PASSWORD_ERROR);
			}
		}
		return model;
	}
}
