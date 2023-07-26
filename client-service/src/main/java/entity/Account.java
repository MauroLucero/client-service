package entity;

import entity.enums.AccountStatus;
import entity.enums.currencyType;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name="client_id",nullable = false)
    private Client client;
    private String accountNumber;
    private String alias;
    private double tax;
    private double balance;
    private AccountStatus status;
    private currencyType currency;

    private LocalDate dateOfOpening;


    public Account() {
    }


    public Account(Long id, Client client, String accountNumber, String alias, double tax, double balance, AccountStatus status, currencyType currency, LocalDate dateOfOpening) {
        this.id = id;
        this.client = client;
        this.accountNumber = accountNumber;
        this.alias = alias;
        this.tax = tax;
        this.balance = balance;
        this.status = status;
        this.currency = currency;
        this.dateOfOpening = dateOfOpening;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public currencyType getCurrency() {
        return currency;
    }

    public void setCurrency(currencyType currency) {
        this.currency = currency;
    }

    public LocalDate getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(LocalDate dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }
}
