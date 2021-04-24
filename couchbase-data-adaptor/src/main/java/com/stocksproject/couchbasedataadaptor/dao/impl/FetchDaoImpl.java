package com.stocksproject.couchbasedataadaptor.dao.impl;

import com.couchbase.client.java.Scope;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryResult;
import com.stocksproject.couchbasedataadaptor.constant.AccountConstants;
import com.stocksproject.couchbasedataadaptor.constant.TransactionConstants;
import com.stocksproject.couchbasedataadaptor.dao.FetchDao;
import com.stocksproject.couchbasedataadaptor.document.AccountEntry;
import com.stocksproject.couchbasedataadaptor.document.TransactionEntry;
import com.stocksproject.couchbasedataadaptor.document.TransactionReadEntry;
import com.stocksproject.couchbasedataadaptor.utils.BeanMapperUtil;
import com.stocksproject.couchbasedataadaptor.utils.ConnectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class FetchDaoImpl implements FetchDao {

    @Autowired
    private ConnectionUtil connectionUtil;

    @Autowired
    private BeanMapperUtil beanMapperUtil;

    private final String bucketName = "entriesBucket";

    @Override
    public List<TransactionEntry> getAllTransactionEntries() throws Exception{
        List<TransactionEntry> transactionList = new ArrayList<>();
        String scopeName = "transaction";
        transactionList.addAll(this.getAllTransactionData(this.connectionUtil.getScope(this.bucketName, scopeName), TransactionConstants.PURCHASE));
        transactionList.addAll(this.getAllTransactionData(this.connectionUtil.getScope(this.bucketName, scopeName), TransactionConstants.SALE));
        return transactionList;
    }

    private List<TransactionEntry> getAllTransactionData(Scope transaction, String collectionName) throws Exception{

        List<TransactionEntry> purchaseTransactions = new ArrayList<>();
        String query = "SELECT * from `" + collectionName + "`";
        QueryResult result = transaction.query(query);
        List<JsonObject> rowObjects = result.rowsAsObject();
        for(JsonObject row : rowObjects){
            log.info(row.toString());
            JsonObject transactionRow = row.getObject(collectionName);
            purchaseTransactions.add(new TransactionEntry(transactionRow.getLong(TransactionConstants.ID), transactionRow.getString(TransactionConstants.TYPE),
                    transactionRow.getString(TransactionConstants.COMPANY_NAME), transactionRow.getString(TransactionConstants.COMPANY_CODE),
                    transactionRow.getString(TransactionConstants.ACCOUNT_IDENTIFIER), transactionRow.getLong(TransactionConstants.QUANTITY),
                    transactionRow.getDouble(TransactionConstants.PRICE),new SimpleDateFormat("yyyy/MM/dd").parse(transactionRow.getString(TransactionConstants.DATE))));
        }
        return purchaseTransactions;

    }

    @Override
    public List<AccountEntry> getAllAccountEntries() {

        List<AccountEntry> userInfoList = new ArrayList<>();

        Scope mapper = this.connectionUtil.getScope(this.bucketName, AccountConstants.SCOPE_NAME);
        String query = "SELECT * from `" + AccountConstants.COLLECTION_NAME + "`";
        QueryResult result = mapper.query(query);
//        userInfoList = result.rowsAs(AccountEntry.class);
        List<JsonObject> rowObjects = result.rowsAsObject();
        for(JsonObject row : rowObjects) {
            JsonObject userRow = row.getObject(AccountConstants.COLLECTION_NAME);
            userInfoList.add(new AccountEntry(userRow.getLong(AccountConstants.ID),
                    userRow.getString(AccountConstants.ACCOUNT_HOLDER_NAME),
                    userRow.getString(AccountConstants.ACCOUNT_IDENTIFIER)));
        }
        return userInfoList;
    }
}
