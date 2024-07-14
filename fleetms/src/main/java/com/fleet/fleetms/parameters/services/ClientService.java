package com.fleet.fleetms.parameters.services;

import com.fleet.fleetms.parameters.models.Client;
import com.fleet.fleetms.parameters.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //Get All Clients
    public Object getAll(){
        return clientRepository.findAll();
    }

    //Get Client By Id
    public Client findById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    //Delete Client
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    //Update Client
    public void save( Client client) {
        clientRepository.save(client);
    }

}
