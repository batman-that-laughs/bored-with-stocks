package com.stocksproject.couchbasedataadaptor.dao;

import com.stocksproject.couchbasedataadaptor.document.AccountEntry;
import com.stocksproject.couchbasedataadaptor.document.TransactionEntry;
import org.springframework.stereotype.Repository;

@Repository
public interface InsertDao {

    void insertEntry(TransactionEntry transactionEntry);

    void insertAccount(AccountEntry entry);
}
