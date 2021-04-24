package com.stocksproject.couchbasedataadaptor.service;

import com.stocksproject.couchbasedataadaptor.dto.AccountInfoDTO;
import com.stocksproject.couchbasedataadaptor.dto.TransactionDTO;

public interface InsertService {

    void insertTransaction(TransactionDTO transaction) throws Exception;

    void insertAccount(AccountInfoDTO dto) throws Exception;
}
