package currencyConverter.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import currencyConverter.com.model.Registration;
import currencyConverter.com.service.ConverterService;

@Controller
public class ConverterController {

	@Autowired
	private ConverterService converterService;
	
	@RequestMapping("/converter")
	public ModelAndView welcomeMessage() {
		ModelAndView view = new ModelAndView("converterView");
		List<Registration> registrations = converterService.getRegistrations();
		view.addObject("registrations", registrations);
		return view;
	}
}
