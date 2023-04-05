package com.ccsw.tutorial.loan;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.config.mapper.BeanMapper;
import com.ccsw.tutorial.loan.exception.AlreadyExistsException;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * @loan ccsw
 */
@RequestMapping(value = "/loan")
@RestController
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    BeanMapper beanMapper;

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param dto
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<LoanDto> findPage(@RequestBody LoanSearchDto dto,
            @RequestParam(value = "idGame", required = false) Long idGame,
            @RequestParam(value = "idClient", required = false) Long idClient,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "MM/dd/yyyy") Date date) {

        Page<Loan> loans = loanService.find(dto, idGame, idClient, date);

        return this.beanMapper.mapPage(loans, LoanDto.class);

    }

    /**
     * Método para crear o actualizar un {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id
     * @param data datos de la entidad
     */
    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody LoanDto dto)
            throws AlreadyExistsException {
        this.loanService.save(id, dto);
    }

    /**
     * Método para crear o actualizar un {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id PK de la entidad
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        this.loanService.delete(id);

    }

    /**
     * Recupera un listado de autores
     * 
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<LoanDto> findAll() {

        List<Loan> loans = this.loanService.findAll();

        return this.beanMapper.mapList(loans, LoanDto.class);
    }

}
