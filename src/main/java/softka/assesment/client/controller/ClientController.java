package softka.assesment.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import softka.assesment.client.model.Client;
import softka.assesment.client.service.ClientService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllClients() {
        try{
            List<Client> allClients = clientService.getClients();
            return new ResponseEntity(allClients, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }  catch (HttpStatusCodeException e) {
            return new ResponseEntity(e.getMessage(), e.getStatusCode());
        }

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getClientById(@PathVariable("id") Long id) {
       try{
        Client c = clientService.getClient(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
       } catch (IllegalArgumentException e) {
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       } catch (NoSuchElementException e) {
           return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
       } catch (HttpStatusCodeException e) {
           return new ResponseEntity(e.getMessage(), e.getStatusCode());
       }

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createClient(@RequestBody Client client) {
        try{
            clientService.addClient(client);
            return new ResponseEntity( HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }  catch (HttpStatusCodeException e) {
            return new ResponseEntity(e.getMessage(), e.getStatusCode());
        }
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteClientById(@PathVariable("id") Long id) {
        try{
            clientService.deleteClient(id);
            return new ResponseEntity( HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }  catch (HttpStatusCodeException e) {
            return new ResponseEntity(e.getMessage(), e.getStatusCode());
        }
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateClientById(@RequestBody Client client) {
        try{
            clientService.updateClient(client);
            return new ResponseEntity( HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }  catch (HttpStatusCodeException e) {
            return new ResponseEntity(e.getMessage(), e.getStatusCode());
        }
    }

    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getClientMinDataById(@RequestBody List<Long> ids) {
        try{
            clientService.getClientMinDataById(ids);
            return new ResponseEntity( HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }  catch (HttpStatusCodeException e) {
            return new ResponseEntity(e.getMessage(), e.getStatusCode());
        }
    }

}
