package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[社保信息]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMSOCIALSECURITY",resultMap = "PimSocialSecurityResultMap")
public class PimSocialSecurity extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 社保信息名称
     */
    @TableField(value = "pimsocialsecurityname")
    @JSONField(name = "pimsocialsecurityname")
    @JsonProperty("pimsocialsecurityname")
    private String pimsocialsecurityname;
    /**
     * 缴纳单位
     */
    @TableField(value = "jndw")
    @JSONField(name = "jndw")
    @JsonProperty("jndw")
    private String jndw;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 社保信息标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimsocialsecurityid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimsocialsecurityid")
    @JsonProperty("pimsocialsecurityid")
    private String pimsocialsecurityid;
    /**
     * 社保比例(%)
     */
    @TableField(value = "sbbl")
    @JSONField(name = "sbbl")
    @JsonProperty("sbbl")
    private String sbbl;
    /**
     * 类型
     */
    @TableField(value = "lx")
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;
    /**
     * 保险基数
     */
    @TableField(value = "bxjs")
    @JSONField(name = "bxjs")
    @JsonProperty("bxjs")
    private String bxjs;
    /**
     * 参保地区
     */
    @TableField(value = "cbdq")
    @JSONField(name = "cbdq")
    @JsonProperty("cbdq")
    private String cbdq;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 缴纳主体
     */
    @TableField(value = "jnzt")
    @JSONField(name = "jnzt")
    @JsonProperty("jnzt")
    private String jnzt;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 社保信息
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [社保信息名称]
     */
    public void setPimsocialsecurityname(String pimsocialsecurityname){
        this.pimsocialsecurityname = pimsocialsecurityname ;
        this.modify("pimsocialsecurityname",pimsocialsecurityname);
    }

    /**
     * 设置 [缴纳单位]
     */
    public void setJndw(String jndw){
        this.jndw = jndw ;
        this.modify("jndw",jndw);
    }

    /**
     * 设置 [社保比例(%)]
     */
    public void setSbbl(String sbbl){
        this.sbbl = sbbl ;
        this.modify("sbbl",sbbl);
    }

    /**
     * 设置 [类型]
     */
    public void setLx(String lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [保险基数]
     */
    public void setBxjs(String bxjs){
        this.bxjs = bxjs ;
        this.modify("bxjs",bxjs);
    }

    /**
     * 设置 [参保地区]
     */
    public void setCbdq(String cbdq){
        this.cbdq = cbdq ;
        this.modify("cbdq",cbdq);
    }

    /**
     * 设置 [缴纳主体]
     */
    public void setJnzt(String jnzt){
        this.jnzt = jnzt ;
        this.modify("jnzt",jnzt);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


