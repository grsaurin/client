package softka.assesment.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import softka.assesment.client.model.Client;
import softka.assesment.client.model.ClientMinData;
import softka.assesment.client.model.DAO.ClientObjDao;
import softka.assesment.client.repository.ClientDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
public class ClientServiceImp implements ClientService{

    private final ClientDao clientDao;

    @Autowired
    public ClientServiceImp(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void addClient(Client client) {
        clientDao.addClient(convertClientToClientDao(client));
    }

    @Override
    public Client getClient(Long id) {
            Client result = new Client();
            ClientObjDao cod =  clientDao.getClient(id);
            if(Objects.nonNull(cod)) {
                result = convertClientDaoToClient(cod);
            }
            return result;
    }

    @Override
    public List<Client> getClients() {
        List<Client> lc = new ArrayList<>();
        List<ClientObjDao> codL = clientDao.getClients();
        if(!codL.isEmpty()){
            for (ClientObjDao clientObjDao : codL) {
                lc.add(convertClientDaoToClient(clientObjDao));
            }
        }

        return lc;
    }

    @Override
    public void deleteClient(Long id) {
        clientDao.deleteClient(id);
    }

    @Override
    public void updateClient(Client client) {
        clientDao.addClient(convertClientToClientDao(client));
    }

    @Override
    public List<ClientMinData> getClientMinDataById(List<Long> ids) {
        List<ClientObjDao> codL = clientDao.getClientsByIds(ids);
        List<ClientMinData> cmd = new ArrayList<>();

        for(ClientObjDao cod : codL){
            cmd.add(new ClientMinData(cod.getId(), cod.getName()));
        }

        return cmd;
    }

    private Client convertClientDaoToClient(ClientObjDao cod) {
        Client nc = new Client();
        nc.setId(cod.getId());
        nc.setName(cod.getName());
        nc.setAge(cod.getAge());
        nc.setCi(cod.getCi());
        nc.setGender(cod.getGender());
        nc.setPhone(cod.getPhone());
        nc.setAddress(cod.getAddress());
        nc.setClientStatus(cod.getClientStatus());
        nc.setPassword(cod.getPassword());

        return nc;
    }

    private ClientObjDao convertClientToClientDao(Client c) {
        ClientObjDao ncod = new ClientObjDao();
        ncod.setName(c.getName());
        ncod.setAge(c.getAge());
        ncod.setCi(c.getCi());
        ncod.setGender(c.getGender());
        ncod.setPhone(c.getPhone());
        ncod.setAddress(c.getAddress());
        ncod.setClientStatus(c.getClientStatus());
        ncod.setPassword(c.getPassword());

        return ncod;
    }


}
