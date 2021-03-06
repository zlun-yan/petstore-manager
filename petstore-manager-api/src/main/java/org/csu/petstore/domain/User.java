package org.csu.petstore.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "用户账号")
    private String username;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户头像url")
    private String avatar_url;

    @ApiModelProperty(value = "用户默认收货地址")
    private Integer default_addr_id;

    @ApiModelProperty(value = "用户保存地址数量")
    private Integer address_num;
}
