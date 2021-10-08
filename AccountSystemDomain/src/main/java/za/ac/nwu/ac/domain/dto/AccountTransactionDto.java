package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -7819344808062462808L;

    private Long ACCOUNT_TYPE_ID;
    private Long memberId;
    private Long amount;
    private LocalDate trDate;

    public AccountTransactionDto(Long memberId, Long amount, LocalDate trDate) {
        this.memberId = memberId;
        this.amount = amount;
        this.trDate = trDate;
    }

    public AccountTransactionDto(Long memberID, Long ACCOUNT_TYPE_ID, Long amount) {
        this.memberId = memberId;
        this.ACCOUNT_TYPE_ID = ACCOUNT_TYPE_ID;
        this.amount = amount;
        this.trDate = LocalDate.now();
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.setMemberId(accountTransaction.getMemberId());
        this.setAmount(accountTransaction.getAmount());
        this.setTrDate(accountTransaction.getTrDate());
    }

    public AccountTransactionDto() {

    }

    @ApiModelProperty(position = 1,
            value = "Account Type ID",
            name = "ACCOUNT_TYPE_ID",
            notes = "Uniquely identifies the account type for the transaction on the account",
            dataType = "java.lang.Long",
            example = "10000",
            required = true)

    public Long getACCOUNT_TYPE_ID() {
        return ACCOUNT_TYPE_ID;
    }

    public void setACCOUNT_TYPE_ID(Long accountTypeId) {
        ACCOUNT_TYPE_ID = accountTypeId;
    }


    @ApiModelProperty(
            position = 2,
            value = "Member ID",
            name = "memberId",
            notes = "Uniquely identifies a member",
            dataType = "java.lang.String",
            example = "1111",
            required = true
    )
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(
            position = 3,
            value = "Amount",
            name = "Amount",
            notes = "Amount on the member's account",
            dataType = "java.lang.String",
            example = "200",
            required = true
    )
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(
            position = 4,
            value = "Transaction Date",
            name = "trDate",
            notes = "The date the transaction occurred",
            dataType = "java.lang.String",
            example = "2021-02-01",
            required = true
    )
    public LocalDate getTrDate() {
        return trDate;
    }

    public void setTrDate(LocalDate trDate) {
        this.trDate = trDate;
    }


/*    @ApiModelProperty(
            position = 5,
            value = "Transaction Id",
            name = "trId",
            notes = "The transaction Id",
            dataType = "java.lang.Long",
            example = "785",
            required = true
    )

    public AccountType getAccount_Type_ID() {
        return trDate;
    }

    public void setTrDate(LocalDate trDate) {
        this.trDate = trDate;
    }*/

    @JsonIgnore
    public AccountTransaction getTransaction() {
        return new AccountTransaction(getACCOUNT_TYPE_ID(),getMemberId(),getAmount(),getTrDate());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(ACCOUNT_TYPE_ID, that.ACCOUNT_TYPE_ID) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(trDate, that.trDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACCOUNT_TYPE_ID, memberId, amount, trDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "AccountTypeId=" + ACCOUNT_TYPE_ID +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", trDate=" + trDate +
                '}';
    }
}