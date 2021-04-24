package com.stocksproject.couchbasedataadaptor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfoDTO {

    private Long id;

    private String name;

    private String identifier;

}
