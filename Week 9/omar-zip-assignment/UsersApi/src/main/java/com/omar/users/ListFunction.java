package com.omar.users;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListFunction implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        JsonObject userOne = new JsonObject();
        userOne.addProperty("userId", "2f1ac1fe-ce1b-428b-ba16-9d997fce438d");
        userOne.addProperty("firstName", "Omar");
        userOne.addProperty("lastName", "Garcia");
        userOne.addProperty("userLevel", "Administrator");

        JsonObject userTwo = new JsonObject();
        userTwo.addProperty("userId", "d23582ac-26fe-4af2-b3c8-c720160dd995");
        userTwo.addProperty("firstName", "Mark");
        userTwo.addProperty("lastName", "Chang");
        userTwo.addProperty("userLevel", "Moderator");

        JsonObject userThree = new JsonObject();
        userThree.addProperty("userId", "1fbd4390-6940-4e72-a61e-4c955464bbca");
        userThree.addProperty("firstName", "Thomas");
        userThree.addProperty("lastName", "Gauthier");
        userThree.addProperty("userLevel", "Normal");


        List<JsonObject> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        users.add(userThree);

        Gson gson = new Gson();

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(Map.of(
                        "Content-Type", "application/json",
                        "X-Custom-Header", "application/json"));;
        return response.withStatusCode(200)
                .withBody(gson.toJson(users));
    }
}
