package com.genspark.clientmanagement.Controller;

import com.genspark.clientmanagement.Entity.Client;
import com.genspark.clientmanagement.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public List<Client> getAllClients() {return clientService.getAllClients();}

    @GetMapping("/{projectId}")
    public Client getClientById(@PathVariable Long id) {return clientService.getClientById(id);}

    @PostMapping("/")
    public Client createClient(@RequestBody Client client) {return clientService.createClient(client);}

    @PutMapping("/{projectId}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {return clientService.updateClient(id, updatedClient);}

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id) { return clientService.deleteClientById(id);}
}
