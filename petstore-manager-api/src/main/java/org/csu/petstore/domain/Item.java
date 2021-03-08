package org.csu.petstore.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel(value="Item对象", description="")
public class Item {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "商品名")
    private String name;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "主键")
    private Integer left_num;

    @ApiModelProperty(value = "主键")
    private Integer shop_id;

    @ApiModelProperty(value = "主键")
    private Integer type_id;

    @ApiModelProperty(value = "主键")
    private String tags;

    @ApiModelProperty(value = "主键")
    private String details;

    @ApiModelProperty(value = "主键")
    private String pic_url;

    @ApiModelProperty(value = "主键")
    private Date date;

    @ApiModelProperty(value = "主键")
    private Integer sale;
}
