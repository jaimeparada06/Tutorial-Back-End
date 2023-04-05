package com.ccsw.tutorial.loan;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.game.model.Game;
import com.ccsw.tutorial.loan.exception.AlreadyExistsException;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * @loan ccsw
 */
public interface LoanService {
    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param dto
     * @return
     */
    Page<Loan> findPage(LoanSearchDto dto);

    /**
     * Método para crear o actualizar un {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id
     * @param data
     */
    void save(Long id, LoanDto data) throws AlreadyExistsException;

    /**
     * Método para crear o actualizar un {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id
     */
    void delete(Long id);

    List<Loan> findAll();

    /**
     * Recupera los juegos filtrando opcionalmente por título y/o cliente y/o fecha
     *
     * @param title      título del juego
     * @param idCategory PK de la categoría
     * @return {@link List} de {@link Game}
     */
    Page<Loan> find(LoanSearchDto dto, Long idGame, Long idClient, Date date);

}
