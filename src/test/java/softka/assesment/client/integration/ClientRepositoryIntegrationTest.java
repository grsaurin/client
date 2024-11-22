package softka.assesment.client.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import softka.assesment.client.model.Common;
import softka.assesment.client.model.DAO.ClientObjDao;
import softka.assesment.client.repository.ClientDao;
import softka.assesment.client.repository.ClientDaoImp;
import softka.assesment.client.repository.ClientJPA;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ClientRepositoryIntegrationTest {

    @Autowired
    private ClientJPA clientDao;

    @Test
    void givenClientEntity_whenSaveClient_thenClientIsPersisted() {
        // given
        ClientObjDao cod = new ClientObjDao(1L, "test user", 25, "6.235.799-8", Common.Genders.male, Common.ClientStatus.ACTIVE, "Ave 8 de julio #3, Montevideo, Uruguay", "+598 84523478", "1234567");

        // when
        clientDao.save(cod);

        // then
        Optional<ClientObjDao> retrievedClient = clientDao.findById(1L);
        assertTrue(Objects.nonNull(retrievedClient));
        assertEquals("test user", retrievedClient.get().getName());
    }
}
