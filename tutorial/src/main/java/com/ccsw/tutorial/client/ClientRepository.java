package com.ccsw.tutorial.client;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ccsw.tutorial.client.model.Client;

/**
 * @author ccsw
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("SELECT p from Client p WHERE p.name LIKE %?1%")
    List<Client> getAllNames(String palabra);

}
