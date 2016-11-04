package com.fqc.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by fqc on 8/6/16.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "Customer Not Found")
public class CustomerNotFoundException extends RuntimeException { }
