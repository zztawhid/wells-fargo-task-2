package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    //Relationship (1)-> Many clients belong to 1 advisor (M:1)
    //Creates 'advisorId' foreign key column in Client table
    @ManyToOne
    @JoinColumn(name= "advisorid", nullable = false) //'false' enforces mandatory link
    private Advisor advisor;

    //Relationship (2) -> One client has one portfolio (1:1)
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Portfolio portfolio;

    //no-arg constructor (Required by JPA)
    protected Client() {
    }

    public Client(String firstName, String lastName, String address, String phone, String email, Advisor advisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.advisor = advisor;
    }

    public Long getClientId() {
        return clientId;
    }


    //Getters & Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio){
        this.portfolio = portfolio;
    }


}
