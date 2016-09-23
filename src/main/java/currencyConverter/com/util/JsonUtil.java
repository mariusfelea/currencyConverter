package currencyConverter.com.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import currencyConverter.com.model.RateConverter;

public class JsonUtil {

	public static RateConverter convertJsonToObject(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, RateConverter.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
