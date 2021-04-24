package com.stocksproject.couchbasedataadaptor.rest.impl;

import com.stocksproject.couchbasedataadaptor.constant.ResponseMessage;
import com.stocksproject.couchbasedataadaptor.dto.AccountInfoDTO;
import com.stocksproject.couchbasedataadaptor.dto.Response;
import com.stocksproject.couchbasedataadaptor.dto.TransactionDTO;
import com.stocksproject.couchbasedataadaptor.rest.InsertApi;
import com.stocksproject.couchbasedataadaptor.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InsertApiImpl implements InsertApi {

    @Autowired
    private InsertService insertService;

    @Override
    public ResponseEntity insertRecords(TransactionDTO dto) throws Exception {
        insertService.insertTransaction(dto);
        return new ResponseEntity(new Response(ResponseMessage.SUCCESS_MESSAGE, null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity insertAccountInfo(AccountInfoDTO dto) throws Exception {
        insertService.insertAccount(dto);
        return new ResponseEntity(new Response(ResponseMessage.SUCCESS_MESSAGE, null), HttpStatus.OK);
    }
}
