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
public class KindOfIncome {
    @Id
    private long id;
    private String kind;
    private boolean isActive;
    private boolean isHome;
}
