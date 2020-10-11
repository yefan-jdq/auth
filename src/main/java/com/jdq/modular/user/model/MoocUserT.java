package com.jdq.modular.user.model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jindiqing
 * @since 2020-10-10
 */
@Data
@Accessors(chain = true)
@TableName("mooc_user_t")
public class MoocUserT extends Model<MoocUserT> {

private static final long serialVersionUID=1L;

    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPwd;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户性别 0-男，1-女
     */
    private Integer userSex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户手机号
     */
    private String userPhone;
    /**
     * 用户住址
     */
    private String address;
    /**
     * 头像URL
     */
    private String headUrl;
    /**
     * 个人介绍
     */
    private String biography;
    /**
     * 生活状态 0-单身，1-热恋中，2-已婚，3-为人父母
     */
    private Integer lifeState;
    /**
     * 更改信息人姓名
     */
    private String modifier;
    /**
     * 创建时间
     */
    private LocalDateTime beginTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal(){
                return this.id;
            }

}
