package ru.avevdokimov.home.newmoney.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.avevdokimov.home.newmoney.model.KindOfIncome;
import ru.avevdokimov.home.newmoney.repo.KindOfIncomeDao;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class KindOfIncomeDaoImp {
    private final KindOfIncomeDao kindOfIncomeDao;

    public KindOfIncome save(KindOfIncome kindOfIncome) {
        return kindOfIncomeDao.save(kindOfIncome);
    }

    public KindOfIncome findById (Long id) {
        if (kindOfIncomeDao.findById(id).isPresent()) {
            return kindOfIncomeDao.findById(id).get();
        }
        return null;
    }

    public List<KindOfIncome> getAllByActiveTrue(boolean isActive) {
        return kindOfIncomeDao.getAllByIsActive(isActive);
    }

    public void deleteById(Long id) {
        kindOfIncomeDao.deleteById(id);
    }
}
