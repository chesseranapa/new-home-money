package ru.avevdokimov.home.newmoney.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.avevdokimov.home.newmoney.model.AccessTransactions;
import ru.avevdokimov.home.newmoney.model.AccessVidPrihod;
import ru.avevdokimov.home.newmoney.model.AccessVidRashod;
import ru.avevdokimov.home.newmoney.repo.MoneyFromAccessDao;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@Slf4j
public class MoneyFromAccessDaoImp implements MoneyFromAccessDao {
    private static final String SQL_FROM_RASHOD = "SELECT id_vid_rashod, vid_rashod  FROM  vidi_rashoda";
    private static final String SQL_FROM_PRIVOD = "SELECT id_vid_prihod, vid_prihod, activ  FROM  vidi_prihoda";
    private static final String SQL_FROM_PROVODKI = "SELECT " +
            "id_rec, " +
            "id_debet, " +
            "sum, " +
            "id_credit, " +
            "data_pr, " +
            "prim  " +
            "FROM  provodki";
    private static final String SQL_FROM_PROVODKI_GT_ID_REC = "SELECT " +
            "id_rec, " +
            "id_debet, " +
            "sum, " +
            "id_credit, " +
            "data_pr, " +
            "prim  " +
            "FROM  provodki " +
            "WHERE id_rec > ?";

    private static final String SQL_INSERT_PRIHOD = "INSERT INTO vidi_prihoda (id_vid_prihod, vid_prihod, activ) VALUES (%d, %s, %b)";
    private final JdbcTemplate jdbcTemplateAccess;

    @Override
    public List<AccessVidRashod> getKindExpenditureList() {
        return jdbcTemplateAccess.query(SQL_FROM_RASHOD, (r, i)->new AccessVidRashod(r.getLong(1), r.getString(2)));
    }

    @Override
    public List<AccessVidPrihod> getKindIncomeList() {
        return jdbcTemplateAccess.query(SQL_FROM_PRIVOD, (r, i)->new AccessVidPrihod(r.getLong(1), r.getString(2), r.getBoolean(3)));
    }

    @Override
    public boolean insertPrihod(int idPrihod, String kindPrihod, int visible) {
        try {
            jdbcTemplateAccess.execute(String.format(SQL_INSERT_PRIHOD, idPrihod, kindPrihod, visible));
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public List<AccessTransactions> getTransactionList() {
        return jdbcTemplateAccess.query(SQL_FROM_PROVODKI, (r, i)->new AccessTransactions(
                r.getLong(1),
                r.getLong(2),
                r.getLong(4),
                r.getDouble(3),
                r.getDate(5),
                r.getString(6)));
    }

    @Override
    public List<AccessTransactions> getTransactionListGtIdRec(Long idRec) {
        return jdbcTemplateAccess.query(SQL_FROM_PROVODKI_GT_ID_REC, (r, i)->new AccessTransactions(
                r.getLong(1),
                r.getLong(2),
                r.getLong(4),
                r.getDouble(3),
                r.getDate(5),
                r.getString(6)), idRec);
    }

}
