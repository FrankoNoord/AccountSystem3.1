package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNTTRANSACTION",schema = "HR")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 1199041377884282633L;
    private Long ACCOUNT_TR_ID;
    private AccountType accountType;
    private Long ACCOUNTTYPEID;
    private Long MEMBERID;
    private Long AMOUNT;
    private LocalDate TR_DATE;

  /*public AccountTransaction(Long ACCOUNTTYPEID, Long MEMBERID, Long AMOUNT, LocalDate TR_DATE) {

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
        this.ACCOUNT_TR_ID = accountTxId;
        this.ACCOUNTTYPEID = accountTypeId;
        this.MEMBERID = memberId;
        this.AMOUNT = amount;
        this.TR_DATE = txDate;
    }

    public AccountTransaction(Long accountTypeId, Long memberId, Long amount, LocalDate txDate) {
        this.ACCOUNTTYPEID = accountTypeId;
        this.MEMBERID = memberId;
        this.AMOUNT = amount;
        this.TR_DATE = txDate;
    }

    public AccountTransaction(Long memberId, Long amount, LocalDate txDate) {
        this.MEMBERID = memberId;
        this.AMOUNT = amount;
        this.TR_DATE = txDate;
    }

/*   public AccountTransaction(Long accountTypeId, Long memberId, Long amount, LocalDate txDate) {
    }*/

    public void setACCOUNT_TR_ID(Long accountTrId) {
        this.ACCOUNT_TR_ID = accountTrId;
    }

    @Id
    @SequenceGenerator(name="ACCOUNTTRANSACTION_SEQ",sequenceName = "HR.ACCOUNTTRANSACTION_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACCOUNTTRANSACTION_SEQ")
    @Column(name = "Account_TR_ID")
    public Long getAccountTxId() {
        return ACCOUNT_TR_ID;
    }

 /*   public void setAccountTypeId(Long accountTypeId) {
        this.ACCOUNTTYPEID = accountTypeId;
    }*/




/*    @JoinColumn(name = "Account_Type_ID")
    public Number getAccountTypeId() {
        return ACCOUNTTYPEID;
    }*/



    public void setMemberID(Long memberId) {
        this.MEMBERID = memberId;
    }

    @Column(name="Member_ID")
    public Long getMemberID() {
        return MEMBERID;
    }

    public void setAmount(Long amount) {
        this.AMOUNT = amount;
    }

    @Column(name="Amount")
    public Long getAmount() {
        return AMOUNT;
    }

    public void setTxDate(LocalDate txDate) {
        this.TR_DATE = txDate;
    }

    @Column(name="TX_Date")
    public LocalDate getTxDate() {
        return TR_DATE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(ACCOUNT_TR_ID, that.ACCOUNT_TR_ID) && Objects.equals(ACCOUNTTYPEID, that.ACCOUNTTYPEID) && Objects.equals(MEMBERID, that.MEMBERID) && Objects.equals(AMOUNT, that.AMOUNT) && Objects.equals(TR_DATE, that.TR_DATE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACCOUNT_TR_ID, ACCOUNTTYPEID, MEMBERID, AMOUNT, TR_DATE);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTxId=" + ACCOUNT_TR_ID +
                ", accountTypeID=" + ACCOUNTTYPEID +
                ", memberId=" + MEMBERID +
                ", amount=" + AMOUNT +
                ", txDate=" + TR_DATE +
                '}';
    }
}
