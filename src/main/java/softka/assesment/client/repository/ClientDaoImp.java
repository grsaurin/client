package softka.assesment.client.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import softka.assesment.client.model.DAO.ClientObjDao;

import java.util.List;

@Repository
public class ClientDaoImp implements ClientDao{

    private final ClientJPA clientJPA;

    @Autowired
    public ClientDaoImp(ClientJPA clientJPA) {
        this.clientJPA = clientJPA;
    }

    @Override
    public void addClient(ClientObjDao client) {
        clientJPA.saveAndFlush(client);
    }

    @Override
    public ClientObjDao getClient(Long id) {
        return clientJPA.findById(id).orElse(null);
    }

    @Override
    public List<ClientObjDao> getClients() {
        return clientJPA.findAll();
    }

    @Override
    public void deleteClient(Long id) {
        clientJPA.deleteById(id);
    }

    @Override
    public void updateClient(ClientObjDao client) {
        clientJPA.saveAndFlush(client);
    }

    @Override
    public List<ClientObjDao> getClientsByIds(List<Long> ids) {
        return clientJPA.findAllById(ids);
    }


}
