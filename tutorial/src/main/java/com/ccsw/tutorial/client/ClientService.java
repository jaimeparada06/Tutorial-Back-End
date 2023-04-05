package com.ccsw.tutorial.client;

import java.util.List;

import com.ccsw.tutorial.client.exception.AlreadyExistsException;
import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;

/**
 * @author ccsw
 *
 */
public interface ClientService {

    /**
     * Recupera un {@link com.ccsw.tutorial.client.model.Client} a través de su ID
     * 
     * @param id
     * @return
     */
    Client get(Long id);

    /**
     * Método para recuperar todas los Client
     * 
     * @return
     */
    List<Client> findAll();

    /**
     * Método para crear o actualizar un Client
     * 
     * @param dto
     * @return
     */
    void save(Long id, ClientDto dto) throws AlreadyExistsException;

    /**
     * Método para borrar un Client
     * 
     * @param id
     */
    void delete(Long id);

}
