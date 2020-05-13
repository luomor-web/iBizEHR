package cn.ibizlab.ehr.core.pcm.domain;

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
 * 实体[变动申请单（停用）]
 */
@Data
@TableName(value = "T_PCMBDSQD",resultMap = "PCMBDSQDResultMap")
public class PCMBDSQD extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 备注说明
     */
    @TableField(value = "bzsm")
    @JSONField(name = "bzsm")
    @JsonProperty("bzsm")
    private String bzsm;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 类型
     */
    @TableField(value = "lx")
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;
    /**
     * 标题
     */
    @TableField(value = "pcmbdsqdname")
    @JSONField(name = "pcmbdsqdname")
    @JsonProperty("pcmbdsqdname")
    private String pcmbdsqdname;
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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 变动申请单标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmbdsqdid",type=IdType.UUID)
    @JSONField(name = "pcmbdsqdid")
    @JsonProperty("pcmbdsqdid")
    private String pcmbdsqdid;
    /**
     * 申请时间
     */
    @TableField(value = "sqsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sqsj" , format="yyyy-MM-dd")
    @JsonProperty("sqsj")
    private Timestamp sqsj;
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
     * 申请人
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 申请人ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 申请人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson;



    /**
     * 设置 [备注说明]
     */
    public void setBzsm(String bzsm){
        this.bzsm = bzsm ;
        this.modify("bzsm",bzsm);
    }
    /**
     * 设置 [类型]
     */
    public void setLx(String lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }
    /**
     * 设置 [标题]
     */
    public void setPcmbdsqdname(String pcmbdsqdname){
        this.pcmbdsqdname = pcmbdsqdname ;
        this.modify("pcmbdsqdname",pcmbdsqdname);
    }
    /**
     * 设置 [申请时间]
     */
    public void setSqsj(Timestamp sqsj){
        this.sqsj = sqsj ;
        this.modify("sqsj",sqsj);
    }
    /**
     * 设置 [申请人ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }
}






