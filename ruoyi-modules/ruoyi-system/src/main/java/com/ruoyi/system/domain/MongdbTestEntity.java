package com.ruoyi.system.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

/**
 * @Author: wuynje
 * @Date: 2021/9/1 11:20
 * @Description:
 */
@Document(collation = "test")
@Data
public class MongdbTestEntity implements Serializable {
    @MongoId
    private Long id;

    private String title;

    private String description;

    private String by;

    private String url;
}
