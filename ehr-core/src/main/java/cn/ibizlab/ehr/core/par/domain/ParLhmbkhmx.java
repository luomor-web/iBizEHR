package cn.ibizlab.ehr.core.par.domain;

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
 * 实体[量化目标考核明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARLHMBKHMX",resultMap = "ParLhmbkhmxResultMap")
public class ParLhmbkhmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 完成标准
     */
    @TableField(value = "wcbz")
    @JSONField(name = "wcbz")
    @JsonProperty("wcbz")
    private String wcbz;
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
     * 标准分值
     */
    @TableField(value = "bzfz")
    @JSONField(name = "bzfz")
    @JsonProperty("bzfz")
    private Double bzfz;
    /**
     * 考核办法
     */
    @TableField(value = "khbf")
    @JSONField(name = "khbf")
    @JsonProperty("khbf")
    private String khbf;
    /**
     * 量化目标考核明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parlhmbkhmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parlhmbkhmxid")
    @JsonProperty("parlhmbkhmxid")
    private String parlhmbkhmxid;
    /**
     * 举证要求
     */
    @TableField(value = "jzyq")
    @JSONField(name = "jzyq")
    @JsonProperty("jzyq")
    private String jzyq;
    /**
     * 量化目标考核明细名称
     */
    @TableField(value = "parlhmbkhmxname")
    @JSONField(name = "parlhmbkhmxname")
    @JsonProperty("parlhmbkhmxname")
    private String parlhmbkhmxname;
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
     * 领导打分
     */
    @TableField(value = "lddf")
    @JSONField(name = "lddf")
    @JsonProperty("lddf")
    private Double lddf;
    /**
     * 量化目标考核
     */
    @TableField(exist = false)
    @JSONField(name = "parndlhmbkhname")
    @JsonProperty("parndlhmbkhname")
    private String parndlhmbkhname;
    /**
     * 量化目标考核ID
     */
    @TableField(value = "parndlhmbkhid")
    @JSONField(name = "parndlhmbkhid")
    @JsonProperty("parndlhmbkhid")
    private String parndlhmbkhid;

    /**
     * 量化目标考核
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParNdlhmbkh parndlhmbkh;



    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [完成标准]
     */
    public void setWcbz(String wcbz){
        this.wcbz = wcbz ;
        this.modify("wcbz",wcbz);
    }

    /**
     * 设置 [标准分值]
     */
    public void setBzfz(Double bzfz){
        this.bzfz = bzfz ;
        this.modify("bzfz",bzfz);
    }

    /**
     * 设置 [考核办法]
     */
    public void setKhbf(String khbf){
        this.khbf = khbf ;
        this.modify("khbf",khbf);
    }

    /**
     * 设置 [举证要求]
     */
    public void setJzyq(String jzyq){
        this.jzyq = jzyq ;
        this.modify("jzyq",jzyq);
    }

    /**
     * 设置 [量化目标考核明细名称]
     */
    public void setParlhmbkhmxname(String parlhmbkhmxname){
        this.parlhmbkhmxname = parlhmbkhmxname ;
        this.modify("parlhmbkhmxname",parlhmbkhmxname);
    }

    /**
     * 设置 [领导打分]
     */
    public void setLddf(Double lddf){
        this.lddf = lddf ;
        this.modify("lddf",lddf);
    }

    /**
     * 设置 [量化目标考核ID]
     */
    public void setParndlhmbkhid(String parndlhmbkhid){
        this.parndlhmbkhid = parndlhmbkhid ;
        this.modify("parndlhmbkhid",parndlhmbkhid);
    }


}


