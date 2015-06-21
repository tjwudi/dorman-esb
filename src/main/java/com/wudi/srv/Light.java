package com.wudi.srv;

import java.io.IOException;

import javax.jws.WebService;

import org.json.JSONException;


@WebService
public interface Light {
	float getResult() throws IOException, JSONException;
}
