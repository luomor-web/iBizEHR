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
 * 实体[服务]
 */
@Data
@TableName(value = "T_SRFSERVICE",resultMap = "ServiceRTResultMap")
public class ServiceRT extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 启动模式
     */
    @TableField(value = "startmode")
    @JSONField(name = "startmode")
    @JsonProperty("startmode")
    private String startmode;
    /**
     * 服务名称
     */
    @TableField(value = "servicename")
    @JSONField(name = "servicename")
    @JsonProperty("servicename")
    private String servicename;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 服务对象
     */
    @TableField(value = "serviceobject")
    @JSONField(name = "serviceobject")
    @JsonProperty("serviceobject")
    private String serviceobject;
    /**
     * 服务运行状态
     */
    @TableField(value = "servicestate")
    @JSONField(name = "servicestate")
    @JsonProperty("servicestate")
    private String servicestate;
    /**
     * 服务次序
     */
    @TableField(value = "runorder")
    @JSONField(name = "runorder")
    @JsonProperty("runorder")
    private Integer runorder;
    /**
     * 服务标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "serviceid",type=IdType.UUID)
    @JSONField(name = "serviceid")
    @JsonProperty("serviceid")
    private String serviceid;
    /**
     * 服务容器
     */
    @TableField(value = "container")
    @JSONField(name = "container")
    @JsonProperty("container")
    private String container;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 服务参数
     */
    @TableField(value = "serviceparam")
    @JSONField(name = "serviceparam")
    @JsonProperty("serviceparam")
    private String serviceparam;
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
     * 错误信息
     */
    @TableField(value = "errorinfo")
    @JSONField(name = "errorinfo")
    @JsonProperty("errorinfo")
    private String errorinfo;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;



    /**
     * 设置 [启动模式]
     */
    public void setStartmode(String startmode){
        this.startmode = startmode ;
        this.modify("startmode",startmode);
    }
    /**
     * 设置 [服务名称]
     */
    public void setServicename(String servicename){
        this.servicename = servicename ;
        this.modify("servicename",servicename);
    }
    /**
     * 设置 [服务对象]
     */
    public void setServiceobject(String serviceobject){
        this.serviceobject = serviceobject ;
        this.modify("serviceobject",serviceobject);
    }
    /**
     * 设置 [服务运行状态]
     */
    public void setServicestate(String servicestate){
        this.servicestate = servicestate ;
        this.modify("servicestate",servicestate);
    }
    /**
     * 设置 [服务次序]
     */
    public void setRunorder(Integer runorder){
        this.runorder = runorder ;
        this.modify("runorder",runorder);
    }
    /**
     * 设置 [服务容器]
     */
    public void setContainer(String container){
        this.container = container ;
        this.modify("container",container);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [服务参数]
     */
    public void setServiceparam(String serviceparam){
        this.serviceparam = serviceparam ;
        this.modify("serviceparam",serviceparam);
    }
    /**
     * 设置 [错误信息]
     */
    public void setErrorinfo(String errorinfo){
        this.errorinfo = errorinfo ;
        this.modify("errorinfo",errorinfo);
    }
    /**
     * 设置 [保留字段]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }
}






