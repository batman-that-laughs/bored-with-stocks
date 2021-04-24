package com.stocksproject.couchbasedataadaptor.service;

import com.couchbase.client.java.json.JsonObject;
import com.stocksproject.couchbasedataadaptor.dto.AccountInfoDTO;
import com.stocksproject.couchbasedataadaptor.dto.TransactionDTO;

import java.util.List;

public interface FetchService {

    List<TransactionDTO> getAllTransactionData() throws Exception;

    List<AccountInfoDTO> getAllUserData() throws Exception;
}
