package service;


import entity.Account;
import model.ClientDTO;

import java.util.Set;

public interface IClientService {

    void saveClient(ClientDTO clientDTO);

    ClientDTO findClient(Long id);

    Set<ClientDTO> getAllClients();

    void updateClient(ClientDTO clientDTO);

    void deleteClient(Long id);

    public void addAccount(Long clientId, Account account);

}
