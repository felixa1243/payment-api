package com.iqbalnetwork.Models.Response;

import com.iqbalnetwork.Models.Constant.Status;
import lombok.Data;

public abstract class GeneralResponse {
    protected String code;
    protected Status status;
    protected String message;
}
