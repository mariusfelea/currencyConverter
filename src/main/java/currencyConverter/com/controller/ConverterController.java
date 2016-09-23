package currencyConverter.com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import currencyConverter.com.model.RateConverter;
import currencyConverter.com.service.RateConverterService;

@Controller
public class ConverterController {
	@Autowired
	private RateConverterService rateConverterService;
	
	@RequestMapping("/converterView")
	public ModelAndView converterView(@ModelAttribute("rateConverter") RateConverter rateConverter) {
		
		ModelAndView model = new ModelAndView("converterView");
		model.addObject("currencies", rateConverterService.getCurrencies());
		model.addObject("getRatesConverter", rateConverterService.getRatesConverter(rateConverter));
		return model;
	}

	@RequestMapping("/convertAmount")
	public ModelAndView convertAmount(@Valid @ModelAttribute("rateConverter") RateConverter rateConverter, BindingResult result) {

		ModelAndView model = new ModelAndView("converterView");
		if (!result.hasErrors()) {
			rateConverterService.save(rateConverter);
			model.addObject("currencies", rateConverterService.getCurrencies());
			model.addObject("getRatesConverter", rateConverterService.getRatesConverter(rateConverter));
		}
		return model;
	}

}
