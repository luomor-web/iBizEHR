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
 * 实体[培训设施]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRAINFACIES",resultMap = "TrmTrainFaciesResultMap")
public class TrmTrainFacies extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地址
     */
    @TableField(value = "dd")
    @JSONField(name = "dd")
    @JsonProperty("dd")
    private String dd;
    /**
     * 培训设施标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrainfaciesid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrainfaciesid")
    @JsonProperty("trmtrainfaciesid")
    private String trmtrainfaciesid;
    /**
     * 特殊设备
     */
    @TableField(value = "sb")
    @JSONField(name = "sb")
    @JsonProperty("sb")
    private String sb;
    /**
     * 是否封存
     */
    @TableField(value = "sffc")
    @JSONField(name = "sffc")
    @JsonProperty("sffc")
    private Integer sffc;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 影音设备
     */
    @TableField(value = "yysb")
    @JSONField(name = "yysb")
    @JsonProperty("yysb")
    private String yysb;
    /**
     * 类型
     */
    @TableField(value = "sslb")
    @JSONField(name = "sslb")
    @JsonProperty("sslb")
    private String sslb;
    /**
     * 办公设备
     */
    @TableField(value = "bgsb")
    @JSONField(name = "bgsb")
    @JsonProperty("bgsb")
    private String bgsb;
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
     * 灯光设备
     */
    @TableField(value = "dgsb")
    @JSONField(name = "dgsb")
    @JsonProperty("dgsb")
    private String dgsb;
    /**
     * 培训设施名称
     */
    @TableField(value = "trmtrainfaciesname")
    @JSONField(name = "trmtrainfaciesname")
    @JsonProperty("trmtrainfaciesname")
    private String trmtrainfaciesname;
    /**
     * 设施编码
     */
    @TableField(value = "ssbm")
    @JSONField(name = "ssbm")
    @JsonProperty("ssbm")
    private String ssbm;
    /**
     * 是否共享
     */
    @TableField(value = "sfgx")
    @JSONField(name = "sfgx")
    @JsonProperty("sfgx")
    private Integer sfgx;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 可容纳人数
     */
    @TableField(value = "sssl")
    @JSONField(name = "sssl")
    @JsonProperty("sssl")
    private Integer sssl;
    /**
     * 设施照片
     */
    @TableField(value = "sszp")
    @JSONField(name = "sszp")
    @JsonProperty("sszp")
    private String sszp;
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
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 培训地点
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;
    /**
     * 培训地点标识
     */
    @TableField(value = "trmtrainaddressid")
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;

    /**
     * 培训地点
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress trmtrainaddress;



    /**
     * 设置 [地址]
     */
    public void setDd(String dd){
        this.dd = dd ;
        this.modify("dd",dd);
    }

    /**
     * 设置 [特殊设备]
     */
    public void setSb(String sb){
        this.sb = sb ;
        this.modify("sb",sb);
    }

    /**
     * 设置 [是否封存]
     */
    public void setSffc(Integer sffc){
        this.sffc = sffc ;
        this.modify("sffc",sffc);
    }

    /**
     * 设置 [影音设备]
     */
    public void setYysb(String yysb){
        this.yysb = yysb ;
        this.modify("yysb",yysb);
    }

    /**
     * 设置 [类型]
     */
    public void setSslb(String sslb){
        this.sslb = sslb ;
        this.modify("sslb",sslb);
    }

    /**
     * 设置 [办公设备]
     */
    public void setBgsb(String bgsb){
        this.bgsb = bgsb ;
        this.modify("bgsb",bgsb);
    }

    /**
     * 设置 [灯光设备]
     */
    public void setDgsb(String dgsb){
        this.dgsb = dgsb ;
        this.modify("dgsb",dgsb);
    }

    /**
     * 设置 [培训设施名称]
     */
    public void setTrmtrainfaciesname(String trmtrainfaciesname){
        this.trmtrainfaciesname = trmtrainfaciesname ;
        this.modify("trmtrainfaciesname",trmtrainfaciesname);
    }

    /**
     * 设置 [设施编码]
     */
    public void setSsbm(String ssbm){
        this.ssbm = ssbm ;
        this.modify("ssbm",ssbm);
    }

    /**
     * 设置 [是否共享]
     */
    public void setSfgx(Integer sfgx){
        this.sfgx = sfgx ;
        this.modify("sfgx",sfgx);
    }

    /**
     * 设置 [可容纳人数]
     */
    public void setSssl(Integer sssl){
        this.sssl = sssl ;
        this.modify("sssl",sssl);
    }

    /**
     * 设置 [设施照片]
     */
    public void setSszp(String sszp){
        this.sszp = sszp ;
        this.modify("sszp",sszp);
    }

    /**
     * 设置 [培训地点标识]
     */
    public void setTrmtrainaddressid(String trmtrainaddressid){
        this.trmtrainaddressid = trmtrainaddressid ;
        this.modify("trmtrainaddressid",trmtrainaddressid);
    }


}


