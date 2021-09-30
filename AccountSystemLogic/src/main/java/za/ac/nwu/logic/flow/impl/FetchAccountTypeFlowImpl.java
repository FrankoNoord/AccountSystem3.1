package za.ac.nwu.logic.flow.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    /*private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        return accountTypeTranslator.getAllAccountTypes();

    }*/
}
