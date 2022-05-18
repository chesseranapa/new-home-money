package ru.avevdokimov.home.newmoney.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.avevdokimov.home.newmoney.model.KindOfExpenditure;

import java.util.List;
import java.util.Optional;

@Repository
public interface KindOfExpenditureDao extends JpaRepository<KindOfExpenditure, Long> {
    @Override
    List<KindOfExpenditure> findAll();

    @Override
    Optional<KindOfExpenditure> findById(Long id);

    @Override
    <S extends KindOfExpenditure> S save(S s);

    void deleteById(Long id);

}
