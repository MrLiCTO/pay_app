package com.lisl.pay.app.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "payApp", description = "payApp对象")
class PayAppBean {

    @ApiModelProperty(value = "payApp的id")
    private int id;

    @ApiModelProperty(value = "payApp的名称")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}