package org.csu.petstore.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel(value="AdminRole对象", description="")
public class AdminRole {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "职位名称")
    private String role_name;

    @ApiModelProperty(value = "职位设置时间")
    private Date createDate;
}
