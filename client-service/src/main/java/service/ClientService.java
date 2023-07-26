package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Account;
import entity.Client;
import jakarta.persistence.EntityNotFoundException;
import model.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IClientRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ClientService implements IClientService{

    private final IClientRepository clientRepository;

    @Autowired
    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    ObjectMapper mapper;

    private void save(ClientDTO clientDTO){
        Client client = mapper.convertValue(clientDTO,Client.class);
        clientRepository.save(client);
    }

    @Override
    public void saveClient(ClientDTO clientDTO) {
        save(clientDTO);
    }

    @Override
    public ClientDTO findClient(Long id) {
        Client client = this.clientRepository.findById(id).orElse(null);
        ClientDTO clientDTO= null;
        if(client!=null){
            clientDTO = mapper.convertValue(client,ClientDTO.class);
        }
        return clientDTO;
    }

    @Override
    public Set<ClientDTO> getAllClients() {
        List<Client> clients= this.clientRepository.findAll();
        Set<ClientDTO> clientsDTO = new HashSet<>();
        for(Client client:clients){
            clientsDTO.add(mapper.convertValue(client,ClientDTO.class));
        }
        return clientsDTO;
    }

    @Override
    public void updateClient(ClientDTO clientDTO) {
        save(clientDTO);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void addAccount(Long clientId, Account account){
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + clientId));

        client.getAccounts().add(account);

        clientRepository.save(client);
    }
}
