package softka.assesment.client.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import softka.assesment.client.model.Client;
import softka.assesment.client.model.Common;
import softka.assesment.client.model.DAO.ClientObjDao;
import softka.assesment.client.repository.ClientDao;


import java.util.Objects;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ClientServiceImpTest {

    @InjectMocks
    private ClientServiceImp clientService;

    @Mock
    private ClientDao clientDao;



    @Test
    void getClientById() {
        Client c =  new Client(1L, "test user", 25, "6.235.799-8", Common.Genders.male, "+598 84523478", "Ave 8 de julio #3, Montevideo, Uruguay", Common.ClientStatus.ACTIVE, "1234567");
        ClientObjDao cod = new ClientObjDao(1L, "test user", 25, "6.235.799-8", Common.Genders.male, Common.ClientStatus.ACTIVE, "Ave 8 de julio #3, Montevideo, Uruguay", "+598 84523478", "1234567");
        //doReturn(cod).when(clientDao).getClient(1L);
        when(clientDao.getClient(1L)).thenReturn(cod);

        Client cr =  clientService.getClient(1L);

        assertTrue(Objects.nonNull(cr));
        verify(clientDao, times(1)).getClient(1L);
        assertEquals(c.getId(), cr.getId());
    }

}