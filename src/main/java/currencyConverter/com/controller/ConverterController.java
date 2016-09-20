package currencyConverter.com.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import currencyConverter.com.model.RateConverter;
import currencyConverter.com.service.RateConverterService;
import currencyConverter.com.service.RateService;

@Controller
public class ConverterController {

	
	@Autowired
	private RateService rateService;

	@Autowired
	private RateConverterService rateConverterService;
	
	@RequestMapping("/converterView")
	public ModelAndView converterView(@ModelAttribute("rateConverter") RateConverter rateConverter) {
		ModelAndView model = new ModelAndView("converterView");
		model.addObject("currencies", rateService.getCurrencies());
		model.addObject("getRatesConverter", rateConverterService.getRatesConverter());
		return model;
	}
	
	@RequestMapping("/convertAmount")
	public ModelAndView convertAmount(@Valid @ModelAttribute("rateConverter") RateConverter rateConverter,
			BindingResult result) {

		ModelAndView model = new ModelAndView("converterView");
		if (!result.hasErrors()) {
			BigDecimal convertedAmount = rateService.multiplyAmountByRate(rateConverter.getAmount(), rateService
					.getRateBetweenCurrencies(rateConverter.getFromCurrency(), rateConverter.getToCurrency()));
			rateConverter.setConvertedAmount(convertedAmount);

			rateConverterService.save(rateConverter);
			model.addObject("getRatesConverter", rateConverterService.getRatesConverter());
			model.addObject("currencies", rateService.getCurrencies());
			model.addObject("rateConverter", rateConverter);
		}
		return model;
	}
}
