package com.stocksproject.couchbasedataadaptor.dao;

import com.couchbase.client.java.json.JsonObject;
import com.stocksproject.couchbasedataadaptor.document.AccountEntry;
import com.stocksproject.couchbasedataadaptor.document.TransactionEntry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FetchDao {

    List<TransactionEntry> getAllTransactionEntries() throws Exception;

    List<AccountEntry> getAllAccountEntries();
}
