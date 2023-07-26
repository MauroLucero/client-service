package com.demo.bank.clientservice.service;


import com.demo.bank.clientservice.model.ClientDTO;

import java.util.Set;

public interface IClientService {

    void saveClient(ClientDTO clientDTO);

    ClientDTO findClient(Long id);

    Set<ClientDTO> getAllClients();

    void updateClient(ClientDTO clientDTO);

    void deleteClient(Long id);


}
