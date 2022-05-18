package ru.avevdokimov.home.newmoney.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KindOfExpenditure {
    @Id
    private long id;
    private String kind;
    private boolean isHome;
}
