package com.wudi.srv;

import java.io.IOException;

import javax.jws.WebService;

import org.codehaus.jettison.json.JSONException;
import org.mule.api.annotations.param.Payload;
import org.w3c.dom.Document;

@WebService
public interface Temperature {
	float getResult() throws IOException, JSONException;
}
