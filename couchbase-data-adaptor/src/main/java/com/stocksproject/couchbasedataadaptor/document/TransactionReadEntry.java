package com.stocksproject.couchbasedataadaptor.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionReadEntry {

    @JsonIgnore
    private TransactionEntry purchase;

    @JsonIgnore
    private TransactionEntry sale;

}
