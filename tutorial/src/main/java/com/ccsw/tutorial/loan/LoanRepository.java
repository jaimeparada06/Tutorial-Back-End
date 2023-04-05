package com.ccsw.tutorial.loan;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.loan.model.Loan;

/**
 * @loan ccsw
 */
public interface LoanRepository extends CrudRepository<Loan, Long> {

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param page
     * @return
     */
    Page<Loan> findAll(Pageable pageable);

    @Query("SELECT p from Loan p WHERE (:idClient IS NULL OR p.client.id = :idClient) AND (p.game.id = :idGame OR :idGame IS NULL) AND ((p.borrowedDate <= :date AND p.returnDate > :date )OR :date IS NULL)")
    Page<Loan> find(Pageable pageable, @Param("idGame") Long idGame, @Param("idClient") Long idClient,
            @Param("date") Date date);

    @Query("SELECT p from Loan p WHERE p.client.id = :id AND ((p.borrowedDate <= :returnD AND :returnD <= p.returnDate) OR (p.borrowedDate <= :borrowD AND :borrowD <= p.returnDate) OR (p.borrowedDate > :borrowD AND :returnD > p.returnDate))")
    List<Loan> getAllClients(Long id, Date borrowD, Date returnD);

    @Query("SELECT p from Loan p WHERE p.game.id = :id AND ((p.borrowedDate <= :returnD AND :returnD <= p.returnDate) OR (p.borrowedDate <= :borrowD AND :borrowD <= p.returnDate) OR (p.borrowedDate > :borrowD AND :returnD > p.returnDate))")
    List<Loan> getAllGames(Long id, Date borrowD, Date returnD);

}
