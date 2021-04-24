package com.stocksproject.couchbasedataadaptor.service.impl;

import com.stocksproject.couchbasedataadaptor.dao.InsertDao;
import com.stocksproject.couchbasedataadaptor.document.AccountEntry;
import com.stocksproject.couchbasedataadaptor.document.TransactionEntry;
import com.stocksproject.couchbasedataadaptor.dto.AccountInfoDTO;
import com.stocksproject.couchbasedataadaptor.dto.TransactionDTO;
import com.stocksproject.couchbasedataadaptor.service.InsertService;
import com.stocksproject.couchbasedataadaptor.utils.BeanMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertServiceImpl implements InsertService {

    @Autowired
    private BeanMapperUtil beanMapperUtil;

    @Autowired
    private InsertDao insertDao;

    @Override
    public void insertTransaction(TransactionDTO transaction) throws Exception {
       TransactionEntry entry = beanMapperUtil.map(transaction, TransactionEntry.class);
       insertDao.insertEntry(entry);
    }

    @Override
    public void insertAccount(AccountInfoDTO dto) throws Exception{
        AccountEntry accountEntry = beanMapperUtil.map(dto, AccountEntry.class);
        insertDao.insertAccount(accountEntry);
    }
}
