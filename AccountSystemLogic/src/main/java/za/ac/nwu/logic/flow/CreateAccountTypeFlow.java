package za.ac.nwu.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

public interface CreateAccountTypeFlow {
    AccountTypeDto create(AccountTypeDto accountTypeDTO);
}
