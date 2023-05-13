package ru.avevdokimov.home.newmoney.repo;

import org.springframework.stereotype.Repository;
import ru.avevdokimov.home.newmoney.model.AccessTransactions;
import ru.avevdokimov.home.newmoney.model.AccessVidPrihod;
import ru.avevdokimov.home.newmoney.model.AccessVidRashod;

import java.util.List;

@Repository
public interface MoneyFromAccessDao {
    List<AccessVidRashod> getKindExpenditureList();
    List<AccessVidPrihod> getKindIncomeList();
    List<AccessTransactions> getTransactionList();
    List<AccessTransactions> getTransactionListGtIdRec(Long idRec);
    boolean insertPrihod(int idPrihod, String kindPrihod, int visible);
}
