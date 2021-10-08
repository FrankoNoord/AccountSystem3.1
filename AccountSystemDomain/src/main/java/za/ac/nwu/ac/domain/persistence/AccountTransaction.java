package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="ACCOUNTTRANSACTION", schema = "HR")
public class AccountTransaction implements Serializable {



    private Long ACCOUNT_TR_ID;
    private AccountType accountType; //Foreign Key
    private Long MEMBERID;
    private Long AMOUNT;
    private LocalDate TR_DATE;

    public AccountTransaction(Long accountTypeId, Long memberId, Long amount, LocalDate trDate){

    }

    public AccountTransaction(Long transactionId, AccountType accountType, Long memberId, Long amount, LocalDate transactionDate) {
        this.ACCOUNT_TR_ID = transactionId;
        this.accountType = accountType;
        this.MEMBERID = memberId;
        this.AMOUNT = amount;
        this.TR_DATE = transactionDate;
    }

    @Id
    @SequenceGenerator(name="ACCOUNTTRANSACTION_SEQ", sequenceName = "HR.ACCOUNTTRANSACTION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTTRANSACTION_SEQ")
    @Column(name = "ACCOUNT_TR_ID")
    public Long getTransactionId() {
        return ACCOUNT_TR_ID;
    }

    @Column(name = "MEMBERID")
    public Long getMemberId() {
        return MEMBERID;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return AMOUNT;
    }

    @Column(name = "TR_DATE")
    public LocalDate getTrDate() {
        return TR_DATE;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType(){
        return accountType;
    }

    public void setTransactionId(Long transactionId) {
        this.ACCOUNT_TR_ID = transactionId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountType = accountTypeId;
    }

    public void setMemberId(Long memberId) {
        this.MEMBERID = memberId;
    }

    public void setAmount(Long amount) {
        this.AMOUNT = amount;
    }

    public void setTrDate(LocalDate transactionDate) {
        this.TR_DATE = transactionDate;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + ACCOUNT_TR_ID +
                ", accountType=" + accountType +
                ", memberId=" + MEMBERID +
                ", amount=" + AMOUNT +
                ", transactionDate=" + TR_DATE +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(ACCOUNT_TR_ID, that.ACCOUNT_TR_ID) && Objects.equals(accountType, that.accountType) && Objects.equals(MEMBERID, that.MEMBERID) && Objects.equals(AMOUNT, that.AMOUNT) && Objects.equals(TR_DATE, that.TR_DATE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACCOUNT_TR_ID, accountType, MEMBERID, AMOUNT, TR_DATE);
    }
}