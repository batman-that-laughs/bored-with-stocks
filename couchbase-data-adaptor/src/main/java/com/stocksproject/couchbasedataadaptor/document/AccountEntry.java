package com.stocksproject.couchbasedataadaptor.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntry {

    private Long id;

    private String name;

    private String identifier;
}
