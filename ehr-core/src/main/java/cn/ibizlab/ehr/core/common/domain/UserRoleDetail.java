package cn.ibizlab.ehr.core.common.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[用户角色成员]
 */
@Data
@TableName(value = "T_SRFUSERROLEDETAIL",resultMap = "UserRoleDetailResultMap")
public class UserRoleDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 用户角色成员标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "userroledetailid",type=IdType.UUID)
    @JSONField(name = "userroledetailid")
    @JsonProperty("userroledetailid")
    private String userroledetailid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 用户数据
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 保留字段4
     */
    @TableField(value = "reserver4")
    @JSONField(name = "reserver4")
    @JsonProperty("reserver4")
    private String reserver4;
    /**
     * 保留字段3
     */
    @TableField(value = "reserver3")
    @JSONField(name = "reserver3")
    @JsonProperty("reserver3")
    private String reserver3;
    /**
     * 用户自定义
     */
    @TableField(value = "usertag")
    @JSONField(name = "usertag")
    @JsonProperty("usertag")
    private String usertag;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 用户角色成员名称
     */
    @DEField(defaultValue = "用户角色成员")
    @TableField(value = "userroledetailname")
    @JSONField(name = "userroledetailname")
    @JsonProperty("userroledetailname")
    private String userroledetailname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 用户数据2
     */
    @TableField(value = "userdata2")
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
    /**
     * 用户对象
     */
    @TableField(exist = false)
    @JSONField(name = "userobjectname")
    @JsonProperty("userobjectname")
    private String userobjectname;
    /**
     * 用户角色
     */
    @TableField(exist = false)
    @JSONField(name = "userrolename")
    @JsonProperty("userrolename")
    private String userrolename;
    /**
     * 用户对象
     */
    @TableField(value = "userobjectid")
    @JSONField(name = "userobjectid")
    @JsonProperty("userobjectid")
    private String userobjectid;
    /**
     * 用户角色
     */
    @TableField(value = "userroleid")
    @JSONField(name = "userroleid")
    @JsonProperty("userroleid")
    private String userroleid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.UserObject userobject;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.UserRole userrole;



    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
    /**
     * 设置 [保留字段2]
     */
    public void setReserver2(String reserver2){
        this.reserver2 = reserver2 ;
        this.modify("reserver2",reserver2);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }
    /**
     * 设置 [保留字段4]
     */
    public void setReserver4(String reserver4){
        this.reserver4 = reserver4 ;
        this.modify("reserver4",reserver4);
    }
    /**
     * 设置 [保留字段3]
     */
    public void setReserver3(String reserver3){
        this.reserver3 = reserver3 ;
        this.modify("reserver3",reserver3);
    }
    /**
     * 设置 [用户自定义]
     */
    public void setUsertag(String usertag){
        this.usertag = usertag ;
        this.modify("usertag",usertag);
    }
    /**
     * 设置 [用户角色成员名称]
     */
    public void setUserroledetailname(String userroledetailname){
        this.userroledetailname = userroledetailname ;
        this.modify("userroledetailname",userroledetailname);
    }
    /**
     * 设置 [用户数据2]
     */
    public void setUserdata2(String userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }
    /**
     * 设置 [用户对象]
     */
    public void setUserobjectid(String userobjectid){
        this.userobjectid = userobjectid ;
        this.modify("userobjectid",userobjectid);
    }
    /**
     * 设置 [用户角色]
     */
    public void setUserroleid(String userroleid){
        this.userroleid = userroleid ;
        this.modify("userroleid",userroleid);
    }
}






