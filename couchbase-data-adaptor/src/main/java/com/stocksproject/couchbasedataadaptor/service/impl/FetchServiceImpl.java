package com.stocksproject.couchbasedataadaptor.service.impl;

import com.couchbase.client.java.json.JsonObject;
import com.stocksproject.couchbasedataadaptor.dao.FetchDao;
import com.stocksproject.couchbasedataadaptor.dto.AccountInfoDTO;
import com.stocksproject.couchbasedataadaptor.dto.TransactionDTO;
import com.stocksproject.couchbasedataadaptor.service.FetchService;
import com.stocksproject.couchbasedataadaptor.utils.BeanMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchServiceImpl implements FetchService {

    @Autowired
    private FetchDao fetchDao;

    @Autowired
    private BeanMapperUtil beanMapperUtil;

    @Override
    public List<TransactionDTO> getAllTransactionData() throws Exception{
        return this.beanMapperUtil.mapList(this.fetchDao.getAllTransactionEntries(), TransactionDTO.class);
//        return this.fetchDao.getAllTransactionEntries();
    }

    @Override
    public List<AccountInfoDTO> getAllUserData() throws Exception{
        return this.beanMapperUtil.mapList(this.fetchDao.getAllAccountEntries(), AccountInfoDTO.class);
//        return this.getAllUserData();
    }
}
