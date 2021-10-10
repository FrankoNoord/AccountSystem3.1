package za.ac.nwu.ac.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator=accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto){
        if (null == accountTypeDto.getCreationDate()){
            accountTypeDto.setCreationDate(LocalDate.now());
        }
        AccountType accountType = accountTypeDto.getAccountType();
        Set<AccountTransaction> accountTransaction = new HashSet<>();
        accountTransaction.add(new AccountTransaction(accountType, 132L , 123L, LocalDate.now()));
        accountType.setAccountTransactions(accountTransaction);

        return accountTypeTranslator.save(accountType);
    }
}






