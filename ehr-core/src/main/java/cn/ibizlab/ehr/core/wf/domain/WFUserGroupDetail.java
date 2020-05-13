package cn.ibizlab.ehr.core.wf.domain;

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
 * 实体[工作流用户组成员]
 */
@Data
@TableName(value = "T_SRFWFUSERGROUPDETAIL",resultMap = "WFUserGroupDetailResultMap")
public class WFUserGroupDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
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
     * 工作流用户组成员标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfusergroupdetailid",type=IdType.UUID)
    @JSONField(name = "wfusergroupdetailid")
    @JsonProperty("wfusergroupdetailid")
    private String wfusergroupdetailid;
    /**
     * 工作流用户名称
     */
    @DEField(defaultValue = "工作流用户")
    @TableField(value = "wfusergroupdetailname")
    @JSONField(name = "wfusergroupdetailname")
    @JsonProperty("wfusergroupdetailname")
    private String wfusergroupdetailname;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 工作流用户组
     */
    @TableField(exist = false)
    @JSONField(name = "wfusergroupname")
    @JsonProperty("wfusergroupname")
    private String wfusergroupname;
    /**
     * 工作流用户
     */
    @TableField(exist = false)
    @JSONField(name = "wfusername")
    @JsonProperty("wfusername")
    private String wfusername;
    /**
     * 用户
     */
    @TableField(value = "wfuserid")
    @JSONField(name = "wfuserid")
    @JsonProperty("wfuserid")
    private String wfuserid;
    /**
     * 用户组
     */
    @TableField(value = "wfusergroupid")
    @JSONField(name = "wfusergroupid")
    @JsonProperty("wfusergroupid")
    private String wfusergroupid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUserGroup wfusergroup;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.wf.domain.WFUser wfuser;



    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [工作流用户名称]
     */
    public void setWfusergroupdetailname(String wfusergroupdetailname){
        this.wfusergroupdetailname = wfusergroupdetailname ;
        this.modify("wfusergroupdetailname",wfusergroupdetailname);
    }
    /**
     * 设置 [用户]
     */
    public void setWfuserid(String wfuserid){
        this.wfuserid = wfuserid ;
        this.modify("wfuserid",wfuserid);
    }
    /**
     * 设置 [用户组]
     */
    public void setWfusergroupid(String wfusergroupid){
        this.wfusergroupid = wfusergroupid ;
        this.modify("wfusergroupid",wfusergroupid);
    }
}






