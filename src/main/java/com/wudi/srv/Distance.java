package com.wudi.srv;

import java.io.IOException;

import javax.jws.WebService;

import org.json.JSONException;


@WebService
public interface Distance {
	float getResult() throws IOException, JSONException;
}
