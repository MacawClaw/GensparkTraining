package com.genspark.clientmanagement.Service;

import com.genspark.clientmanagement.Entity.Client;
import com.genspark.clientmanagement.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client updatedClient) {
        Client existingClient = clientRepository.findById(id).orElse(null);
        if(existingClient != null) {
            existingClient.setClientName(updatedClient.getClientName());
            existingClient.setAddress(updatedClient.getAddress());
            //existingProject.setClientId(updatedProject.getClientId());
            existingClient.setAddress(updatedClient.getAddress());
            existingClient.setUsername(updatedClient.getUsername());
            existingClient.setAgreement(updatedClient.getAgreement());
            return clientRepository.save(existingClient);
        }
        return null;
    }

    public String deleteClientById(Long id) {
        clientRepository.deleteById(id);
        return "The client was deleted successfully";
    }
}
