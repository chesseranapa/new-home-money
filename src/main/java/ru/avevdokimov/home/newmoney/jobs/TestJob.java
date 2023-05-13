package ru.avevdokimov.home.newmoney.jobs;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.avevdokimov.home.newmoney.model.*;
import ru.avevdokimov.home.newmoney.service.KindOfExpenditureDaoImp;
import ru.avevdokimov.home.newmoney.service.KindOfIncomeDaoImp;
import ru.avevdokimov.home.newmoney.service.MoneyFromAccessDaoImp;
import ru.avevdokimov.home.newmoney.service.TransactionsDaoImp;

import java.util.List;
import java.util.logging.Logger;

@Component
@Data
@AllArgsConstructor
public class TestJob {
    private final MoneyFromAccessDaoImp moneyFromAccessDaoImp;
    private final KindOfExpenditureDaoImp kindOfExpenditureDaoImp;
    private final KindOfIncomeDaoImp kindOfIncomeDaoImp;
    private final TransactionsDaoImp transactionsDaoImp;
/*    //импорт справочника видов расходов
    @Scheduled(initialDelayString = "1000", fixedRateString = "60000")
    public void testJob() {
        Logger.getLogger("TestLog").info("start job");
        List<AccessVidRashod> list =  moneyFromAccessDaoImp.getKindExpenditureList();
        for (AccessVidRashod vid: list) {
            KindOfExpenditure kind = new KindOfExpenditure(vid.getId(), vid.getVid(), false);
            kindOfExpenditureDaoImp.save(kind);
            Logger.getLogger("TestLog").info(vid.toString());
        }

    }*/

/*    //импорт справочника видов прихода
    @Scheduled(initialDelayString = "1000", fixedRateString = "60000")
    public void testJob2() {
        Logger.getLogger("TestLog").info("start job2");
        List<AccessVidPrihod> list =  moneyFromAccessDaoImp.getKindIncomeList();
        for (AccessVidPrihod vid: list) {
            KindOfIncome kind = new KindOfIncome(vid.getId(), vid.getVid(), vid.isActive(), false);
            kindOfIncomeDaoImp.save(kind);
            Logger.getLogger("TestLog").info(vid.toString());
        }
    }*/

    //импорт из access
    //@Scheduled(initialDelayString = "1000", fixedRateString = "3600000")
    public void testJob3() {
        Logger.getLogger("TestLog").info("start job3");
        List<AccessTransactions> list =  moneyFromAccessDaoImp.getTransactionListGtIdRec(46000L);
        for (AccessTransactions vid: list) {
            if (kindOfExpenditureDaoImp.findById(vid.getKredit()) != null
                    && kindOfIncomeDaoImp.findById(vid.getDebet()) != null) {
                if (vid.getId() > 46000) {
                    Transactions transactions = new Transactions(
                            vid.getId(),
                            kindOfExpenditureDaoImp.findById(vid.getKredit()),
                            kindOfIncomeDaoImp.findById(vid.getDebet()),
                            vid.getSumma(),
                            vid.getDateTransaction(),
                            vid.getPrim(),
                            null,
                            null);
                    transactionsDaoImp.save(transactions);
                    Logger.getLogger("TestLog").info(vid.toString());
                } else {
                    Logger.getLogger("TestLog").info(Long.toString(vid.getId()));
                }

            } else {
                Logger.getLogger("TestLog").severe("don't find code in table");
            }
            //Logger.getLogger("TestLog").info(vid.toString());
        }
    }

    //расчёт остатков
    //@Scheduled(initialDelayString = "1000", fixedRateString = "60000")
    public void testJob4() {
        Double summa = 0D;
        Logger.getLogger("TestLog").info("start job4");
        List<KindOfIncome> list =  kindOfIncomeDaoImp.getAllByActiveTrue(true);
        for (KindOfIncome kind: list) {
            Logger.getLogger("TestLog").info(kind.toString());
            summa = summa + transactionsDaoImp.getSummaByExpenditure(kind.getId()) - transactionsDaoImp.getSummaByIncomee(kind.getId());
            Logger.getLogger("TestLog").info(Double.toString(transactionsDaoImp.getSummaByExpenditure(kind.getId()) - transactionsDaoImp.getSummaByIncomee(kind.getId())));
        }
        Logger.getLogger("TestLog").info("Итого: " + Double.toString(summa));
    }

    @Scheduled(initialDelayString = "1000", fixedRateString = "60000")
    public void testJob5() {
/*        moneyFromAccessDaoImp.getKindExpenditureList().forEach(e -> Logger.getLogger("OutLog")
                .info(e.toString()));
        moneyFromAccessDaoImp.getKindIncomeList().forEach(e -> Logger.getLogger("InLog")
                .info(e.toString()));*/
/*        moneyFromAccessDaoImp.insertPrihod(63, "'OzonKartaLeha'", 1);
        Logger.getLogger("InsertLog").info("ok");*/
    }
}
