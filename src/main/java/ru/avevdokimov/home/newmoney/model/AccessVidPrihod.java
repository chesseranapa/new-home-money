package ru.avevdokimov.home.newmoney.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccessVidPrihod {
    private long id;
    private String vid;
    private boolean isActive;
}
