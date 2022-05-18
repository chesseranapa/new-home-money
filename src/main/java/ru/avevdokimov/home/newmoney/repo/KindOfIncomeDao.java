package ru.avevdokimov.home.newmoney.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.avevdokimov.home.newmoney.model.KindOfIncome;

import java.util.List;
import java.util.Optional;

@Repository
public interface KindOfIncomeDao extends JpaRepository<KindOfIncome, Long> {

    @Override
    List<KindOfIncome> findAll();

    @Override
    Optional<KindOfIncome> findById(Long aLong);

    @Override
    <S extends KindOfIncome> S save(S s);

    List<KindOfIncome> getAllByIsActive(Boolean isActive);

    void deleteById(Long id);
}
