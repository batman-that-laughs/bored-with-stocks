package com.stocksproject.couchbasedataadaptor.rest;

import com.stocksproject.couchbasedataadaptor.constant.ResponseMessage;
import com.stocksproject.couchbasedataadaptor.dto.AccountInfoDTO;
import com.stocksproject.couchbasedataadaptor.dto.TransactionDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/insert")
public interface InsertApi {

    @PostMapping(path = "/transaction", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "save a transaction record")
    @ApiResponses(value = {@ApiResponse(code= HttpServletResponse.SC_OK, message = ResponseMessage.SUCCESS_MESSAGE),
            @ApiResponse(code= HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = ResponseMessage.ERROR_MESSAGE)})
    ResponseEntity insertRecords(@RequestBody TransactionDTO dto) throws Exception;


    @PostMapping(path = "/account", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "save a account record")
    @ApiResponses(value = {@ApiResponse(code= HttpServletResponse.SC_OK, message = ResponseMessage.SUCCESS_MESSAGE),
            @ApiResponse(code= HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = ResponseMessage.ERROR_MESSAGE)})
    ResponseEntity insertAccountInfo(@RequestBody AccountInfoDTO dto) throws Exception;



}
