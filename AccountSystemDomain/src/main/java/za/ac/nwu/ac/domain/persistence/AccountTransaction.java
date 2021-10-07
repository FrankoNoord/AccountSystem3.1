package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNTTRANSACTION",schema = "HR")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 1199041377884282633L;
    private Long Account_TR_ID;
    private AccountType accountType;
    private Long accountTypeId;
    private Long memberId;
    private Long amount;
    private LocalDate txDate;

 /*   public AccountTransaction(Long accountTypeId, Long memberId, Long amount, LocalDate txDate) {

    }*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")


    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountTransaction(Long accountTxId,Long accountTypeId, Long memberId, Long amount, LocalDate txDate) {
        this.Account_TR_ID = accountTxId;
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.txDate = txDate;
    }

    public AccountTransaction(Long accountTypeId, Long memberId, Long amount, LocalDate txDate) {
        this.accountTypeId = accountTypeId;
        this.memberId = memberId;
        this.amount = amount;
        this.txDate = txDate;
    }

    public AccountTransaction(Long memberId, Long amount, LocalDate txDate) {
        this.memberId = memberId;
        this.amount = amount;
        this.txDate = txDate;
    }

 /*   public AccountTransaction(Long accountTypeId, Long memberId, Long amount, LocalDate txDate) {
    }*/

    public void setAccountTxId(Long accountTxId) {
        this.Account_TR_ID = accountTxId;
    }

    @Id
    @SequenceGenerator(name="ACCOUNTTRANSACTION_SEQ",sequenceName = "HR.ACCOUNTTRANSACTION_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACCOUNTTRANSACTION_SEQ")
    @Column(name = "Account_TR_ID")
    public Long getAccountTxId() {
        return Account_TR_ID;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }


/*
    @JoinColumn(name = "Account_Type_ID")
    public Number getAccountTypeId() {
        return accountTypeId;
    }
*/

    public void setMemberID(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name="Member_ID")
    public Long getMemberID() {
        return memberId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name="Amount")
    public Long getAmount() {
        return amount;
    }

    public void setTxDate(LocalDate txDate) {
        this.txDate = txDate;
    }

    @Column(name="TX_Date")
    public LocalDate getTxDate() {
        return txDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(Account_TR_ID, that.Account_TR_ID) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(txDate, that.txDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Account_TR_ID, accountTypeId, memberId, amount, txDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTxId=" + Account_TR_ID +
                ", accountTypeID=" + accountTypeId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", txDate=" + txDate +
                '}';
    }
}
