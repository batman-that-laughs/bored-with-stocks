package com.stocksproject.couchbasedataadaptor.rest.impl;

import com.stocksproject.couchbasedataadaptor.dto.Response;
import com.stocksproject.couchbasedataadaptor.rest.FetchApi;
import com.stocksproject.couchbasedataadaptor.service.FetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FetchApiImpl implements FetchApi {

    @Autowired
    private FetchService fetchService;

    @Override
    public ResponseEntity getAllTransactionData() throws Exception {
        return new ResponseEntity(new Response(this.fetchService.getAllTransactionData(), null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getAllUserData() throws Exception {
        return new ResponseEntity(new Response(this.fetchService.getAllUserData(), null), HttpStatus.OK);
    }
}
