package cn.ibizlab.ehr.core.sal.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[员工薪酬标准明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_SALPERSONSTDDETAIL",resultMap = "SALPERSONSTDDETAILResultMap")
public class SALPERSONSTDDETAIL extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实际业务值
     */
    @TableField(value = "ywz")
    @JSONField(name = "ywz")
    @JsonProperty("ywz")
    private String ywz;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 薪酬
     */
    @TableField(value = "xc")
    @JSONField(name = "xc")
    @JsonProperty("xc")
    private Double xc;
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
     * 实际情况描述
     */
    @TableField(value = "ywms")
    @JSONField(name = "ywms")
    @JsonProperty("ywms")
    private String ywms;
    /**
     * 员工薪酬标准明细名称
     */
    @TableField(value = "salpersonstddetailname")
    @JSONField(name = "salpersonstddetailname")
    @JsonProperty("salpersonstddetailname")
    private String salpersonstddetailname;
    /**
     * 员工薪酬标准明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "salpersonstddetailid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "salpersonstddetailid")
    @JsonProperty("salpersonstddetailid")
    private String salpersonstddetailid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 员工薪酬标准名称
     */
    @TableField(exist = false)
    @JSONField(name = "salpersonstdname")
    @JsonProperty("salpersonstdname")
    private String salpersonstdname;
    /**
     * 要素项
     */
    @TableField(exist = false)
    @JSONField(name = "salschemeitemname")
    @JsonProperty("salschemeitemname")
    private String salschemeitemname;
    /**
     * 员工薪酬标准标识
     */
    @TableField(value = "salpersonstdid")
    @JSONField(name = "salpersonstdid")
    @JsonProperty("salpersonstdid")
    private String salpersonstdid;
    /**
     * 方案要素项标识
     */
    @TableField(value = "salschemeitemid")
    @JSONField(name = "salschemeitemid")
    @JsonProperty("salschemeitemid")
    private String salschemeitemid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalPersonStd salpersonstd;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.sal.domain.SalSchemeItem salschemeitem;



    /**
     * 设置 [实际业务值]
     */
    public void setYwz(String ywz){
        this.ywz = ywz ;
        this.modify("ywz",ywz);
    }

    /**
     * 设置 [薪酬]
     */
    public void setXc(Double xc){
        this.xc = xc ;
        this.modify("xc",xc);
    }

    /**
     * 设置 [实际情况描述]
     */
    public void setYwms(String ywms){
        this.ywms = ywms ;
        this.modify("ywms",ywms);
    }

    /**
     * 设置 [员工薪酬标准明细名称]
     */
    public void setSalpersonstddetailname(String salpersonstddetailname){
        this.salpersonstddetailname = salpersonstddetailname ;
        this.modify("salpersonstddetailname",salpersonstddetailname);
    }

    /**
     * 设置 [员工薪酬标准标识]
     */
    public void setSalpersonstdid(String salpersonstdid){
        this.salpersonstdid = salpersonstdid ;
        this.modify("salpersonstdid",salpersonstdid);
    }

    /**
     * 设置 [方案要素项标识]
     */
    public void setSalschemeitemid(String salschemeitemid){
        this.salschemeitemid = salschemeitemid ;
        this.modify("salschemeitemid",salschemeitemid);
    }


}


