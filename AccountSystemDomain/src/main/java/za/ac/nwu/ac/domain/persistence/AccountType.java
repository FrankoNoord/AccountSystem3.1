package za.ac.nwu.ac.domain.persistence;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

//@Repository
@Entity
@Table(name = "ACCOUNTTYPE", schema = "HR")
public class AccountType implements Serializable {


    private static final long serialVersionUID = -5821687458026469928L;
    private Long ACCOUNT_TYPE_ID;
    private String MNEMONIC;
    private String ACCOUNTTYPENAME;
    private LocalDate CREATIONDATE;

    private Set<AccountTransaction> accountTransactions;

    public AccountType() {

    }

    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.ACCOUNT_TYPE_ID = accountTypeId;
        this.MNEMONIC = mnemonic;
        this.ACCOUNTTYPENAME = accountTypeName;
        this.CREATIONDATE = creationDate;
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.MNEMONIC = mnemonic;
        this.ACCOUNTTYPENAME = accountTypeName;
        this.CREATIONDATE = creationDate;
    }

    @Id
    @SequenceGenerator(name = "ACCOUNTTYPE_SEQ", sequenceName = "HR.ACCOUNTTYPE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTTYPE_SEQ")

    @Column(name = "ACCOUNTTYPEID")
    public Long getAccountTypeId() {
        return ACCOUNT_TYPE_ID;
    }
    @Column(name = "MNEMONIC")
    public String getMnemonic(){

        return MNEMONIC;
    }
    @Column(name = "ACCOUNTTYPENAME")
    public String getAccountTypeName() {

        return ACCOUNTTYPENAME;
    }
    @Column(name = "CREATIONDATE")
    public LocalDate getCreationDate() {

        return CREATIONDATE;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }

    public void setAccountTypeId(Long accountTypeId) {

        this.ACCOUNT_TYPE_ID = accountTypeId;
    }

    public void setMnemonic(String mnemonic) {

        this.MNEMONIC = mnemonic;
    }

    public void setAccountTypeName(String accountTypeName) {

        this.ACCOUNTTYPENAME = accountTypeName;
    }

    public void setCreationDate(LocalDate creationDate) {

        this.CREATIONDATE = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(ACCOUNT_TYPE_ID, that.ACCOUNT_TYPE_ID) && Objects.equals(MNEMONIC, that.MNEMONIC) && Objects.equals(ACCOUNTTYPENAME, that.ACCOUNTTYPENAME) && Objects.equals(CREATIONDATE, that.CREATIONDATE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACCOUNT_TYPE_ID, MNEMONIC, ACCOUNTTYPENAME, CREATIONDATE);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + ACCOUNT_TYPE_ID +
                ", mnemonic='" + MNEMONIC + '\'' +
                ", accountTypeName='" + ACCOUNTTYPENAME + '\'' +
                ", creationDate=" + CREATIONDATE +
                '}';
    }
}
