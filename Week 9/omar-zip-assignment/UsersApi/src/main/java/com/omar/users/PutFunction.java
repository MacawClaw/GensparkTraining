package com.omar.users;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PutFunction implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {

        String requestBody = input.getBody();
        Gson gson = new Gson();

        Map<String, String> pathParameters = input.getPathParameters();
        Map<String, String> userDetails = gson.fromJson(requestBody, Map.class);
        //userDetails.put("userId", UUID.randomUUID().toString());

        Map returnValue = new HashMap();
        returnValue.put("userId", pathParameters.get("userId"));
        returnValue.put("firstName", userDetails.get("firstName"));
        returnValue.put("lastName", userDetails.get("lastName"));
        returnValue.put("userLevel", userDetails.get("userLevel"));

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200);
        response.withBody(gson.toJson(returnValue, Map.class));

        Map responseHeader = new HashMap();
        responseHeader.put("Content-Type", "application/json");

        response.withHeaders(responseHeader);

        return response;
    }
}
