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
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
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
 * 实体[用户组成员]
 */
@Data
@TableName(value = "T_SRFUSERGROUPDETAIL",resultMap = "UserGroupDetailResultMap")
public class UserGroupDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 用户组成员名称
     */
    @TableField(value = "usergroupdetailname")
    @JSONField(name = "usergroupdetailname")
    @JsonProperty("usergroupdetailname")
    private String usergroupdetailname;
    /**
     * 用户数据2
     */
    @TableField(value = "userdata2")
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;
    /**
     * 用户数据
     */
    @TableField(value = "userdata")
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;
    /**
     * 用户组成员标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "usergroupdetailid",type=IdType.UUID)
    @JSONField(name = "usergroupdetailid")
    @JsonProperty("usergroupdetailid")
    private String usergroupdetailid;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 用户对象
     */
    @TableField(exist = false)
    @JSONField(name = "userobjectname")
    @JsonProperty("userobjectname")
    private String userobjectname;
    /**
     * 用户组
     */
    @TableField(exist = false)
    @JSONField(name = "usergroupname")
    @JsonProperty("usergroupname")
    private String usergroupname;
    /**
     * 用户组
     */
    @TableField(value = "usergroupid")
    @JSONField(name = "usergroupid")
    @JsonProperty("usergroupid")
    private String usergroupid;
    /**
     * 用户对象
     */
    @TableField(value = "userobjectid")
    @JSONField(name = "userobjectid")
    @JsonProperty("userobjectid")
    private String userobjectid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.UserGroup usergroup;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.UserObject userobject;



    /**
     * 设置 [用户组成员名称]
     */
    public void setUsergroupdetailname(String usergroupdetailname){
        this.usergroupdetailname = usergroupdetailname ;
        this.modify("usergroupdetailname",usergroupdetailname);
    }
    /**
     * 设置 [用户数据2]
     */
    public void setUserdata2(String userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }
    /**
     * 设置 [用户数据]
     */
    public void setUserdata(String userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }
    /**
     * 设置 [用户组]
     */
    public void setUsergroupid(String usergroupid){
        this.usergroupid = usergroupid ;
        this.modify("usergroupid",usergroupid);
    }
    /**
     * 设置 [用户对象]
     */
    public void setUserobjectid(String userobjectid){
        this.userobjectid = userobjectid ;
        this.modify("userobjectid",userobjectid);
    }

    /**
     * 获取 [用户组成员标识]
     */
    public String getUsergroupdetailid(){
        if(ObjectUtils.isEmpty(usergroupdetailid)){
            usergroupdetailid=(String)getDefaultKey(true);
        }
        return usergroupdetailid;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getUsergroupid()))&&(!ObjectUtils.isEmpty(this.getUserobjectid())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getUsergroupid(),this.getUserobjectid()).getBytes());
        return null;
    }
}


