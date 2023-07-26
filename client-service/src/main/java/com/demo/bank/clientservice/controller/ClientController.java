package com.demo.bank.clientservice.controller;

import com.demo.bank.clientservice.model.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.demo.bank.clientservice.service.ClientService;

import java.util.Collection;

@RestController
@RequestMapping("/client")
public class ClientController {

    ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody ClientDTO clientDTO){
        clientService.saveClient(clientDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ClientDTO findClient(@PathVariable("id") long id){
        return clientService.findClient(id);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.FOUND)
    public Collection<ClientDTO> getAllClients(){
        return clientService.getAllClients();
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@RequestBody ClientDTO clientDTO){
        clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeClient(@PathVariable("id") long id){
        clientService.deleteClient(id);
    }
}
