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
 * 实体[系统]
 */
@Data
@TableName(value = "T_SYSTEM",resultMap = "SystemResultMap")
public class System extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 认证请求地址
     */
    @TableField(value = "aurloginaddr")
    @JSONField(name = "aurloginaddr")
    @JsonProperty("aurloginaddr")
    private String aurloginaddr;
    /**
     * 系统名称
     */
    @TableField(value = "systemname")
    @JSONField(name = "systemname")
    @JsonProperty("systemname")
    private String systemname;
    /**
     * 系统类型
     */
    @TableField(value = "systemtype")
    @JSONField(name = "systemtype")
    @JsonProperty("systemtype")
    private String systemtype;
    /**
     * 系统集成功能
     */
    @TableField(value = "systemfun")
    @JSONField(name = "systemfun")
    @JsonProperty("systemfun")
    private Integer systemfun;
    /**
     * 系统地址
     */
    @TableField(value = "systemaddr")
    @JSONField(name = "systemaddr")
    @JsonProperty("systemaddr")
    private String systemaddr;
    /**
     * 图标
     */
    @TableField(value = "bigicon")
    @JSONField(name = "bigicon")
    @JsonProperty("bigicon")
    private String bigicon;
    /**
     * 系统标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "systemid",type=IdType.UUID)
    @JSONField(name = "systemid")
    @JsonProperty("systemid")
    private String systemid;
    /**
     * 厂商备注
     */
    @TableField(value = "service")
    @JSONField(name = "service")
    @JsonProperty("service")
    private String service;
    /**
     * 系统参数
     */
    @TableField(value = "systemparam")
    @JSONField(name = "systemparam")
    @JsonProperty("systemparam")
    private String systemparam;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 集成服务授权码
     */
    @TableField(value = "funlic")
    @JSONField(name = "funlic")
    @JsonProperty("funlic")
    private String funlic;
    /**
     * 认证注销地址
     */
    @TableField(value = "aurlogoutaddr")
    @JSONField(name = "aurlogoutaddr")
    @JsonProperty("aurlogoutaddr")
    private String aurlogoutaddr;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;



    /**
     * 设置 [认证请求地址]
     */
    public void setAurloginaddr(String aurloginaddr){
        this.aurloginaddr = aurloginaddr ;
        this.modify("aurloginaddr",aurloginaddr);
    }
    /**
     * 设置 [系统名称]
     */
    public void setSystemname(String systemname){
        this.systemname = systemname ;
        this.modify("systemname",systemname);
    }
    /**
     * 设置 [系统类型]
     */
    public void setSystemtype(String systemtype){
        this.systemtype = systemtype ;
        this.modify("systemtype",systemtype);
    }
    /**
     * 设置 [系统集成功能]
     */
    public void setSystemfun(Integer systemfun){
        this.systemfun = systemfun ;
        this.modify("systemfun",systemfun);
    }
    /**
     * 设置 [系统地址]
     */
    public void setSystemaddr(String systemaddr){
        this.systemaddr = systemaddr ;
        this.modify("systemaddr",systemaddr);
    }
    /**
     * 设置 [图标]
     */
    public void setBigicon(String bigicon){
        this.bigicon = bigicon ;
        this.modify("bigicon",bigicon);
    }
    /**
     * 设置 [厂商备注]
     */
    public void setService(String service){
        this.service = service ;
        this.modify("service",service);
    }
    /**
     * 设置 [系统参数]
     */
    public void setSystemparam(String systemparam){
        this.systemparam = systemparam ;
        this.modify("systemparam",systemparam);
    }
    /**
     * 设置 [集成服务授权码]
     */
    public void setFunlic(String funlic){
        this.funlic = funlic ;
        this.modify("funlic",funlic);
    }
    /**
     * 设置 [认证注销地址]
     */
    public void setAurlogoutaddr(String aurlogoutaddr){
        this.aurlogoutaddr = aurlogoutaddr ;
        this.modify("aurlogoutaddr",aurlogoutaddr);
    }

}


