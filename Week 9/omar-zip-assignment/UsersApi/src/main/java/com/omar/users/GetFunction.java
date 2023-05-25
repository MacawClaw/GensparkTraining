package com.omar.users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.JsonObject;

/**
 * Handler for requests to Lambda function.
 */
public class GetFunction implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        Map<String, String> pathParameters = input.getPathParameters();
        //String userId = pathParameters.get("userId");

        JsonObject returnValue = new JsonObject();
        returnValue.addProperty("userId", pathParameters.get("userId"));
        returnValue.addProperty("firstName", "Omar");
        returnValue.addProperty("lastName", "Garcia");
        returnValue.addProperty("userLevel", "Administrator");
        //returnValue.addProperty("id", "2f1ac1fe-ce1b-428b-ba16-9d997fce438d");
        //"2f1ac1fe-ce1b-428b-ba16-9d997fce438d\"

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200).withBody(returnValue.toString());

        return response;
    }
}
