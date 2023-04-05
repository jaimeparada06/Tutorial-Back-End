package com.ccsw.tutorial.loan.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.game.model.Game;

/**
 * @author ccsw
 */
@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "borrowed_date", nullable = false)
    private Date borrowedDate;

    @Column(name = "return_date", nullable = false)
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
    public Game getGame() {

        return this.game;
    }

    /**
     * @param game new value of {@link #getgame}.
     */
    public void setGame(Game game) {

        this.game = game;
    }

    /**
     * @return client
     */
    public Client getClient() {

        return this.client;
    }

    /**
     * @param client new value of {@link #getclient}.
     */
    public void setClient(Client client) {

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
