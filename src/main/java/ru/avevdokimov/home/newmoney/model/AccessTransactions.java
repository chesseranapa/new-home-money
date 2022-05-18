package ru.avevdokimov.home.newmoney.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccessTransactions {
    private long id;
    private long debet;
    private long kredit;
    private double summa;
    private Date dateTransaction;
    private String prim;
}
