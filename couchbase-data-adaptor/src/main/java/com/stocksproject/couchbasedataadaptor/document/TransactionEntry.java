package com.stocksproject.couchbasedataadaptor.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntry {

    private Long id;

    private String type;

    private String companyName;

    private String companyCode;

    private String accountIdentifier;

    private Long quantity;

    private Double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date date;

}
