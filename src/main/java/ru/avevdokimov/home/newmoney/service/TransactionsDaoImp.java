package ru.avevdokimov.home.newmoney.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.avevdokimov.home.newmoney.model.Transactions;
import ru.avevdokimov.home.newmoney.repo.TransactionsDao;

@Service
@Data
@AllArgsConstructor
public class TransactionsDaoImp {
    private final TransactionsDao transactionsDao;

    public Transactions save(Transactions transaction) {
        return transactionsDao.save(transaction);
    }

    public Double getSummaByExpenditure(Long id) {
        Double d = transactionsDao.getSummaByExpenditure(id);
        if (d != null) {
            return d;
        }
        return 0D;
    }

    public Double getSummaByIncomee(Long id) {
        Double d = transactionsDao.getSummaByIncome(id);
        if (d != null) {
            return d;
        }
        return 0D;
    }

}
