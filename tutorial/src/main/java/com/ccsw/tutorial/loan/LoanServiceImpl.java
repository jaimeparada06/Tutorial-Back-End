package com.ccsw.tutorial.loan;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.ClientService;
import com.ccsw.tutorial.game.GameService;
import com.ccsw.tutorial.loan.exception.AlreadyExistsException;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * @loan ccsw
 */
@Service
@Transactional
public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanRepository loanRepository;

    @Autowired
    GameService gameService;

    @Autowired
    ClientService clientService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Loan> findPage(LoanSearchDto dto) {

        return this.loanRepository.findAll(dto.getPageable());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, LoanDto dto) throws AlreadyExistsException {

        List<Loan> cl = loanRepository.getAllClients(dto.getClient().getId(), dto.getBorrowedDate(),
                dto.getReturnDate());
        List<Loan> gm = loanRepository.getAllGames(dto.getGame().getId(), dto.getBorrowedDate(), dto.getReturnDate());

        Loan loan = null;
        if (id != null && cl.size() == 0 && gm.size() == 0) {
            loan = this.loanRepository.findById(id).orElse(null);
        } else if (id == null && cl.size() == 0 && gm.size() == 0) {
            loan = new Loan();
        }
        if (cl.size() != 0) {
            throw new AlreadyExistsException(
                    "Un mismo cliente no puede tener prestados más de 2 juegos en un mismo día");
        }
        if (gm.size() != 0) {
            throw new AlreadyExistsException(
                    "El mismo juego no puede estar prestado a dos clientes distintos en un mismo día");
        }

        BeanUtils.copyProperties(dto, loan, "id", "game_id", "client_id", "date");

        loan.setGame(gameService.get(dto.getGame().getId()));
        loan.setClient(clientService.get(dto.getClient().getId()));

        this.loanRepository.save(loan);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {

        this.loanRepository.deleteById(id);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Loan> findAll() {

        return (List<Loan>) this.loanRepository.findAll();
    }

    public Page<Loan> find(LoanSearchDto dto, Long idGame, Long idClient, Date date) {
        return this.loanRepository.find(dto.getPageable(), idGame, idClient, date);
    }

}
