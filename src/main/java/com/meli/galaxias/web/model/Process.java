package com.meli.galaxias.web.model;

import com.google.gson.JsonObject;

import spark.Request;
import spark.Response;

public interface Process {
	public Object get (Request req, Response res,JsonObject json) throws Exception;
	public Object post (Request req, Response res,JsonObject json)throws Exception;
	public Object put (Request req, Response res,JsonObject json)throws Exception;
	public Object delete (Request req, Response res,JsonObject json)throws Exception;
}
