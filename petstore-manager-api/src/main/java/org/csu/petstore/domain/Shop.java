package org.csu.petstore.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="Shop对象", description="")
public class Shop {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "商店名称")
    private String name;

    @ApiModelProperty(value = "商店描述")
    private String description;

    @ApiModelProperty(value = "店铺收藏数")
    private Integer likes;

    @ApiModelProperty(value = "店铺banner_url")
    private String banner_url;

    @ApiModelProperty(value = "店铺地址")
    private String location;
}
