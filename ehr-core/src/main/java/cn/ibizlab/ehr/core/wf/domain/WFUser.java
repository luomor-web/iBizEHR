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
 * 实体[工作流用户]
 */
@Data
@TableName(value = "T_SRFWFUSER",resultMap = "WFUserResultMap")
public class WFUser extends EntityMP implements Serializable {

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
     * 工作流用户标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "wfuserid",type=IdType.UUID)
    @JSONField(name = "wfuserid")
    @JsonProperty("wfuserid")
    private String wfuserid;
    /**
     * 工作流用户名称
     */
    @TableField(value = "wfusername")
    @JSONField(name = "wfusername")
    @JsonProperty("wfusername")
    private String wfusername;
    /**
     * 接收工作通知
     */
    @TableField(value = "recvinform")
    @JSONField(name = "recvinform")
    @JsonProperty("recvinform")
    private Integer recvinform;
    /**
     * 保留字段
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 保留字段2
     */
    @TableField(value = "reserver2")
    @JSONField(name = "reserver2")
    @JsonProperty("reserver2")
    private String reserver2;
    /**
     * 有效标志
     */
    @DEField(defaultValue = "1")
    @TableField(value = "validflag")
    @JSONField(name = "validflag")
    @JsonProperty("validflag")
    private Integer validflag;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 是否接收工作
     */
    @DEField(defaultValue = "1")
    @TableField(value = "isrecvwork")
    @JSONField(name = "isrecvwork")
    @JsonProperty("isrecvwork")
    private Integer isrecvwork;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;



    /**
     * 设置 [工作流用户名称]
     */
    public void setWfusername(String wfusername){
        this.wfusername = wfusername ;
        this.modify("wfusername",wfusername);
    }
    /**
     * 设置 [接收工作通知]
     */
    public void setRecvinform(Integer recvinform){
        this.recvinform = recvinform ;
        this.modify("recvinform",recvinform);
    }
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
     * 设置 [有效标志]
     */
    public void setValidflag(Integer validflag){
        this.validflag = validflag ;
        this.modify("validflag",validflag);
    }
    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }
    /**
     * 设置 [是否接收工作]
     */
    public void setIsrecvwork(Integer isrecvwork){
        this.isrecvwork = isrecvwork ;
        this.modify("isrecvwork",isrecvwork);
    }
}






