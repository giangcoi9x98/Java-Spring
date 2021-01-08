package com.example.demo.helper.responseBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseForm<T> {
    int code;
    String message;
    T data;

    public  static <T>ResponseForm<T>responseOk(T data,int code,String message){
        ResponseForm<T> responseForm = new ResponseForm<T>();
        responseForm.data=data;
        responseForm.code=code;
        responseForm.message=message;
        return responseForm;
    }
}
