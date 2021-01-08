package com.example.demo.helper.responseBuider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseForm<T> {
    int code;
    String message;
    T data;

    public static <T> ResponseForm<T> responseOkBuider(T data, int code, String message){
        ResponseForm<T> responseBuider = new ResponseForm<T>();
        responseBuider.data=data;
        responseBuider.code=code;
        responseBuider.message=message;
        return responseBuider;
    }
}
