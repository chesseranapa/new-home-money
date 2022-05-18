package ru.avevdokimov.home.newmoney.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.avevdokimov.home.newmoney.model.KindOfExpenditure;
import ru.avevdokimov.home.newmoney.model.Transactions;

public interface TransactionsDao extends JpaRepository<Transactions, Long> {
    @Override
    <S extends Transactions> S save(S s);

    @Query(value = "SELECT sum(summa_transaction) FROM public.transactions " +
            "group by expenditure_id having expenditure_id = ?1", nativeQuery = true)
    Double getSummaByExpenditure(Long id);

    @Query(value = "SELECT sum(summa_transaction) FROM public.transactions " +
            "group by income_id having income_id = ?1" , nativeQuery = true)
    Double getSummaByIncome(Long id);

}
