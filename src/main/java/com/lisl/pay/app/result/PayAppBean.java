package com.lisl.pay.app.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "payApp", description = "payApp对象")
@Getter
@Setter
class PayAppBean {

    @ApiModelProperty(value = "payApp的id")
    private int id;

    @ApiModelProperty(value = "payApp的名称")
    private String name;
}