package softka.assesment.client.repository;

import softka.assesment.client.model.Client;
import softka.assesment.client.model.DAO.ClientObjDao;

import java.util.List;
import java.util.Optional;

public interface ClientDao {
    void addClient(ClientObjDao client);
    ClientObjDao getClient(Long id);
    List<ClientObjDao> getClients();
    void deleteClient(Long id);
    void updateClient(ClientObjDao client);
    List<ClientObjDao> getClientsByIds(List<Long> ids);

}
