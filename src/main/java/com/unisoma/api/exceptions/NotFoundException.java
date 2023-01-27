package com.unisoma.api.exceptions;

import com.unisoma.api.util.MessageUtils;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}