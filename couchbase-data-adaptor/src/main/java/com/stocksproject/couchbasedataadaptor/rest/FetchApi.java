package com.stocksproject.couchbasedataadaptor.rest;

import com.stocksproject.couchbasedataadaptor.constant.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/fetch")
public interface FetchApi {

    @GetMapping(path = "/all-transaction-data", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "fetch all transaction data")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK, message = ResponseMessage.SUCCESS_MESSAGE),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = ResponseMessage.ERROR_MESSAGE)})
    ResponseEntity getAllTransactionData() throws Exception;

    @GetMapping(path = "/all-user-data", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "fetch all user data")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK, message = ResponseMessage.SUCCESS_MESSAGE),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = ResponseMessage.ERROR_MESSAGE)})
    ResponseEntity getAllUserData() throws Exception;

}
