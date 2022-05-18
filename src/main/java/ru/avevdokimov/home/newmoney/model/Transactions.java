package ru.avevdokimov.home.newmoney.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
    @Id
    private long id;
    @ManyToOne
    private KindOfExpenditure expenditure;
    @ManyToOne
    private KindOfIncome income;

    //@Column(columnDefinition="Decimal(10,2)")
    private double summaTransaction;
    private Date dateTransaction;
    private String comment;
    private String incomeTags;
    private String expenditureTags;
}
