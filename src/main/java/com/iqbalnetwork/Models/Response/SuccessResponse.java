package com.iqbalnetwork.Models.Response;

import com.iqbalnetwork.Models.Constant.Status;
import lombok.Data;

@Data
public class SuccessResponse<T> extends GeneralResponse {
    private T data;

    public SuccessResponse(String code, String message, T data) {
        this.code = code;
        this.status = Status.OK;
        this.message = message;
        this.data = data;
    }
}
