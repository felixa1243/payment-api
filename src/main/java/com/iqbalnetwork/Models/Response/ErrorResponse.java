package com.iqbalnetwork.Models.Response;

import com.iqbalnetwork.Models.Constant.Status;
import lombok.Data;

@Data
public class ErrorResponse extends GeneralResponse {
    public ErrorResponse(String message) {
        this.code = "X01";
        this.status = Status.FAILED;
        this.message = message;
    }
}
