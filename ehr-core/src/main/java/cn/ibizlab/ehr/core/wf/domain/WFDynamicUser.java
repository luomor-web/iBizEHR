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
 * 实体[工作流动态用户]
 */
@Data
@TableName(value = "T_WFDYNAMICUSER",resultMap = "WFDynamicUserResultMap")
public class WFDynamicUser extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 处理变量
     */
    @TableField(value = "params")
    @JSONField(name = "params")
    @JsonProperty("params")
    private String params;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 工作流动态用户标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfdynamicuserid",type=IdType.UUID)
    @JSONField(name = "wfdynamicuserid")
    @JsonProperty("wfdynamicuserid")
    private String wfdynamicuserid;
    /**
     * 用户类型
     */
    @TableField(value = "usertype")
    @JSONField(name = "usertype")
    @JsonProperty("usertype")
    private String usertype;
    /**
     * 用户处理对象
     */
    @TableField(value = "userobject")
    @JSONField(name = "userobject")
    @JsonProperty("userobject")
    private String userobject;
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
     * 工作流动态用户名称
     */
    @TableField(value = "wfdynamicusername")
    @JSONField(name = "wfdynamicusername")
    @JsonProperty("wfdynamicusername")
    private String wfdynamicusername;



    /**
     * 设置 [处理变量]
     */
    public void setParams(String params){
        this.params = params ;
        this.modify("params",params);
    }
    /**
     * 设置 [用户类型]
     */
    public void setUsertype(String usertype){
        this.usertype = usertype ;
        this.modify("usertype",usertype);
    }
    /**
     * 设置 [用户处理对象]
     */
    public void setUserobject(String userobject){
        this.userobject = userobject ;
        this.modify("userobject",userobject);
    }
    /**
     * 设置 [工作流动态用户名称]
     */
    public void setWfdynamicusername(String wfdynamicusername){
        this.wfdynamicusername = wfdynamicusername ;
        this.modify("wfdynamicusername",wfdynamicusername);
    }

}


