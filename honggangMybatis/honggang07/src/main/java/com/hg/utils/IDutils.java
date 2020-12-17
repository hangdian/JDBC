package com.hg.utils;

import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class IDutils {
    public  static  String getId(){
        return UUID.randomUUID().toString().replaceAll("-"," ");

    }


}
