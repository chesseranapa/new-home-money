package ru.avevdokimov.home.newmoney.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.avevdokimov.home.newmoney.model.KindOfExpenditure;
import ru.avevdokimov.home.newmoney.repo.KindOfExpenditureDao;


@Service
@Data
@AllArgsConstructor
public class KindOfExpenditureDaoImp {
    private final KindOfExpenditureDao kindOfExpenditureDao;

    public KindOfExpenditure save(KindOfExpenditure kindOfExpenditure) {
        return kindOfExpenditureDao.save(kindOfExpenditure);
    }

    public KindOfExpenditure findById(Long id) {
        if (kindOfExpenditureDao.findById(id).isPresent()) {
            return kindOfExpenditureDao.findById(id).get();
        }
        return null;
    }

    public void deleteById(Long id) {
        kindOfExpenditureDao.deleteById(id);
    }
}
