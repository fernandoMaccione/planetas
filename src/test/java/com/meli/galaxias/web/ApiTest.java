package com.meli.galaxias.web;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

import com.meli.galaxias.App;
import com.meli.galaxias.common.Config;

public class ApiTest {

	@Test
	public void getClimaApiTest() throws Exception{
		App.main(new String[]{}); //Levanto el sericio.
		
		URL url;
		URLConnection urlConnection;
		
		url = new URL("http://localhost:"+Config.SERVER_PORT + "/clima?dia=0");
		urlConnection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String inputLine;
		StringBuffer result  = new StringBuffer();
		while ((inputLine = in.readLine()) != null)
		{	
			result.append(inputLine);
		}	
		in.close();						

		Api.stopServer();
		String json = result.toString();
		
		assertTrue(json.equals("{\"Respuesta\":{\"dia\":0,\"clima\":\"Optimo\"}}"));
	}
}
