package cn.ibizlab.ehr.core.trm.domain;

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
 * 实体[开票信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMINVOICE",resultMap = "TrmInvoiceResultMap")
public class TrmInvoice extends EntityMP implements Serializable {

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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 地址
     */
    @TableField(value = "dz")
    @JSONField(name = "dz")
    @JsonProperty("dz")
    private String dz;
    /**
     * 开票人
     */
    @TableField(value = "kpr")
    @JSONField(name = "kpr")
    @JsonProperty("kpr")
    private String kpr;
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
     * 开票类型
     */
    @TableField(value = "kplx")
    @JSONField(name = "kplx")
    @JsonProperty("kplx")
    private String kplx;
    /**
     * 开户行账号
     */
    @TableField(value = "khhzh")
    @JSONField(name = "khhzh")
    @JsonProperty("khhzh")
    private String khhzh;
    /**
     * 开户行
     */
    @TableField(value = "khh")
    @JSONField(name = "khh")
    @JsonProperty("khh")
    private String khh;
    /**
     * 开票信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trminvoiceid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trminvoiceid")
    @JsonProperty("trminvoiceid")
    private String trminvoiceid;
    /**
     * 开票名称
     */
    @TableField(value = "trminvoicename")
    @JSONField(name = "trminvoicename")
    @JsonProperty("trminvoicename")
    private String trminvoicename;
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
     * 纳税人识别号
     */
    @TableField(value = "nsrsbh")
    @JSONField(name = "nsrsbh")
    @JsonProperty("nsrsbh")
    private String nsrsbh;
    /**
     * 电话
     */
    @TableField(value = "dh")
    @JSONField(name = "dh")
    @JsonProperty("dh")
    private String dh;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 培训机构名称
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 培训机构标识
     */
    @TableField(value = "trmtrainagencyid")
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;

    /**
     * 开票机构
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency trmtrainagency;



    /**
     * 设置 [地址]
     */
    public void setDz(String dz){
        this.dz = dz ;
        this.modify("dz",dz);
    }

    /**
     * 设置 [开票人]
     */
    public void setKpr(String kpr){
        this.kpr = kpr ;
        this.modify("kpr",kpr);
    }

    /**
     * 设置 [开票类型]
     */
    public void setKplx(String kplx){
        this.kplx = kplx ;
        this.modify("kplx",kplx);
    }

    /**
     * 设置 [开户行账号]
     */
    public void setKhhzh(String khhzh){
        this.khhzh = khhzh ;
        this.modify("khhzh",khhzh);
    }

    /**
     * 设置 [开户行]
     */
    public void setKhh(String khh){
        this.khh = khh ;
        this.modify("khh",khh);
    }

    /**
     * 设置 [开票名称]
     */
    public void setTrminvoicename(String trminvoicename){
        this.trminvoicename = trminvoicename ;
        this.modify("trminvoicename",trminvoicename);
    }

    /**
     * 设置 [纳税人识别号]
     */
    public void setNsrsbh(String nsrsbh){
        this.nsrsbh = nsrsbh ;
        this.modify("nsrsbh",nsrsbh);
    }

    /**
     * 设置 [电话]
     */
    public void setDh(String dh){
        this.dh = dh ;
        this.modify("dh",dh);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [培训机构标识]
     */
    public void setTrmtrainagencyid(String trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}


