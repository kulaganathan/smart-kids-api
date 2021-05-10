package com.kalaiworld.smartkidsapi.service;

import java.util.UUID;

public class BasicService {

    protected String generateRefId() {
        return UUID.randomUUID().toString();
    }

}
