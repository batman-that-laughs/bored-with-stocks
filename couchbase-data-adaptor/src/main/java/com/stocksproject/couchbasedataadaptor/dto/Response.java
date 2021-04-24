package com.stocksproject.couchbasedataadaptor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Object data;

    private List<String> errorMessages;

}