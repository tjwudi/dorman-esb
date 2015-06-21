package com.wudi.srv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import javax.jws.WebService;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

@WebService(endpointInterface="com.wudi.srv.Distance",
serviceName="Distance")
public class DistanceImpl implements Distance {
	public float getResult() throws IOException, JSONException {
		Properties prop = new Properties();
		String propFileName = "appconfig.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("Property file not found");
		}
		String urlStr = prop.getProperty("distanceAPIUrl");
		URL url = new URL(urlStr);
	
        URLConnection yc = url.openConnection();

		Object obj = JSONValue.parse(new BufferedReader(new InputStreamReader(yc.getInputStream())));
		JSONObject jsonObj = (JSONObject) obj;
		Number result = (Number) jsonObj.get("distance");
		return result.floatValue();
	}

}
