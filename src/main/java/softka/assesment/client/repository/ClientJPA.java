package softka.assesment.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softka.assesment.client.model.DAO.ClientObjDao;

public interface ClientJPA extends JpaRepository<ClientObjDao, Long> {

}
