package softka.assesment.client.service;

import softka.assesment.client.model.Client;
import softka.assesment.client.model.ClientMinData;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ClientService {
    void addClient(Client client);
    Client getClient(Long id);
    List<Client> getClients();
    void deleteClient(Long id);
    void updateClient(Client client);
    List<ClientMinData> getClientMinDataById(List<Long> ids);
}
