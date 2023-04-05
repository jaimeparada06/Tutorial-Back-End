package com.ccsw.tutorial.loan.model;

import java.sql.Date;

import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.game.model.GameDto;

/**
 * @author ccsw
 */
public class LoanDto {

    private Long id;
    private GameDto game;
    private ClientDto client;
    private Date borrowedDate;
    private Date returnDate;

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getid}.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return game
     */
    public GameDto getGame() {

        return this.game;
    }

    /**
     * @param game new value of {@link #getgame}.
     */
    public void setGame(GameDto game) {

        this.game = game;
    }

    /**
     * @return client
     */
    public ClientDto getClient() {

        return this.client;
    }

    /**
     * @param client new value of {@link #getclient}.
     */
    public void setClient(ClientDto client) {

        this.client = client;
    }

    /**
     * @return client
     */
    public Date getBorrowedDate() {

        return this.borrowedDate;
    }

    /**
     * @param fechaPres new value of {@link #getfechaPres}.
     */
    public void setBorrowedDate(Date borrowedDate) {

        this.borrowedDate = borrowedDate;
    }

    /**
     * @return client
     */
    public Date getReturnDate() {

        return this.returnDate;
    }

    /**
     * @param fechaDev new value of {@link #getfechaDev}.
     */
    public void setReturnDate(Date returnDate) {

        this.returnDate = returnDate;
    }

}
