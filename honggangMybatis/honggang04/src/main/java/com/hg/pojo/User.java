package com.hg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 考察实体类中名程不一致的情况
 *
 *
 *
 */
@Data
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private String password;


}
