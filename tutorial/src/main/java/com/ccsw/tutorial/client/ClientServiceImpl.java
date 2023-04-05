package com.ccsw.tutorial.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.exception.AlreadyExistsException;
import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;

/**
 * @author ccsw
 *
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Client get(Long id) {

        return this.clientRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> findAll() {
        return (List<Client>) this.clientRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, ClientDto dto) throws AlreadyExistsException {

        Client cliente = null;
        List<Client> cl = clientRepository.getAllNames(dto.getName());

        if (id == null && cl.size() == 0) {
            cliente = new Client();
        } else if (id != null && cl.size() == 0) {
            cliente = this.clientRepository.findById(id).orElse(null);
        } else {
            throw new AlreadyExistsException();
        }

        cliente.setName(dto.getName());

        this.clientRepository.save(cliente);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {

        this.clientRepository.deleteById(id);
    }

}
