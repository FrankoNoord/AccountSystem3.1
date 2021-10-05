package za.ac.nwu.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.logic.flow.CreateAccountTypeFlow;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator=accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDTO){
        AccountTypeDto accountType = new AccountTypeDto();
        if (null == accountType.getCreationDate()){
            accountType.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }
}






