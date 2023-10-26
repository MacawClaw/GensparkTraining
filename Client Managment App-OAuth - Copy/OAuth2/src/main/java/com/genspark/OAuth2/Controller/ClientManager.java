package com.genspark.OAuth2.Controller;

import com.genspark.OAuth2.Data.ClientData;
import com.genspark.OAuth2.OAuth2Application;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class ClientManager {

    private ClientData clientData;

    @GetMapping("/project")
    public ResponseEntity<String> organizationProjects(@AuthenticationPrincipal OAuth2User principle) {
        String message = "Invalid user, unable to process further. Please authenticate yourself";

        if(principle != null) {
            String clientName = principle.getAttribute("clientName");
            log.info("Fetching account balance for customer : {}", clientName);
            var project = clientData.getProject(clientName);

            if(null == project){
                message = "Sorry no project found with name:" + clientName;
            }else{
                message = "Hello " + clientName + ", here are your projects: " + project;
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}