package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.util.List;

public interface AccountTransactionTranslator {

    AccountTransactionDto create(AccountTransactionDto accountTransaction);

    List<AccountTransactionDto> getAllTransactions();
}
