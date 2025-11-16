package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Column(nullable = false)
    private LocalDate creationDate;

    //Relationship (1): One portfolio belongs to one client (1:1)
    //Creates 'clientID' foreign key
    //unique enforces 1:1 constraint in db

    @OneToOne
    @JoinColumn(name = "clientid", unique = true, nullable = false)
    private Client client;

    //Relationship (2): One portfolio has many securities (1:M)
    //'mappedBy' points to 'portfolio' field in Security entity
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    //no-arg constructor (Required by JPA)
    protected Portfolio() {
    }

    public Portfolio(LocalDate creationDate, Client client, List<Security> securities) {
        this.creationDate = creationDate;
        this.client = client;
        this.securities = securities;
    }

    //getters & setters

    public Long getPortfolioId() {
        return portfolioId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
