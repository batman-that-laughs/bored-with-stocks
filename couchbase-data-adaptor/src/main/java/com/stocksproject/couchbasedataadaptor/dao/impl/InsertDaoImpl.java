package com.stocksproject.couchbasedataadaptor.dao.impl;

import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.MutationResult;
import com.stocksproject.couchbasedataadaptor.dao.InsertDao;
import com.stocksproject.couchbasedataadaptor.document.AccountEntry;
import com.stocksproject.couchbasedataadaptor.document.TransactionEntry;
import com.stocksproject.couchbasedataadaptor.utils.ConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertDaoImpl implements InsertDao {

    @Autowired
    private ConnectionUtil connectionUtil;

    @Override
    public void insertEntry(TransactionEntry transactionEntry) {
        String bucketName = "entriesBucket";
        String scopeName = "transaction";
        String collectionName = transactionEntry.getType();

        Collection collection = connectionUtil.getCouchbaseCollection(bucketName, scopeName, collectionName);
        MutationResult result = collection.upsert(transactionEntry.getType() + transactionEntry.getId(), transactionEntry);

    }

    @Override
    public void insertAccount(AccountEntry entry) {
        String bucketName = "entriesBucket";
        String scopeName = "mappers";
        String collectionName = "accountHolder";

        Collection collection = connectionUtil.getCouchbaseCollection(bucketName, scopeName, collectionName);
        MutationResult result = collection.upsert("account_" + entry.getId(), entry);

    }
}
