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
 * 实体[绩效主观评测明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXZGPCMX",resultMap = "ParJxzgpcmxResultMap")
public class ParJxzgpcmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分值范围
     */
    @TableField(value = "fzfw")
    @JSONField(name = "fzfw")
    @JsonProperty("fzfw")
    private String fzfw;
    /**
     * 最高得分
     */
    @TableField(value = "zgdf")
    @JSONField(name = "zgdf")
    @JsonProperty("zgdf")
    private Double zgdf;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 指标
     */
    @TableField(value = "zb")
    @JSONField(name = "zb")
    @JsonProperty("zb")
    private String zb;
    /**
     * 绩效主观评测明细名称
     */
    @TableField(value = "parjxzgpcmxname")
    @JSONField(name = "parjxzgpcmxname")
    @JsonProperty("parjxzgpcmxname")
    private String parjxzgpcmxname;
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
     * 评分
     */
    @TableField(value = "pf")
    @JSONField(name = "pf")
    @JsonProperty("pf")
    private Double pf;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
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
     * 绩效主观评测明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxzgpcmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxzgpcmxid")
    @JsonProperty("parjxzgpcmxid")
    private String parjxzgpcmxid;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 最低得分
     */
    @TableField(value = "zddf")
    @JSONField(name = "zddf")
    @JsonProperty("zddf")
    private Double zddf;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 标题
     */
    @TableField(exist = false)
    @JSONField(name = "parjxzgpcname")
    @JsonProperty("parjxzgpcname")
    private String parjxzgpcname;
    /**
     * 主观评测ID
     */
    @TableField(value = "parjxzgpcid")
    @JSONField(name = "parjxzgpcid")
    @JsonProperty("parjxzgpcid")
    private String parjxzgpcid;

    /**
     * 主观评测
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParJxzgpc parjxzgpc;



    /**
     * 设置 [分值范围]
     */
    public void setFzfw(String fzfw){
        this.fzfw = fzfw ;
        this.modify("fzfw",fzfw);
    }

    /**
     * 设置 [最高得分]
     */
    public void setZgdf(Double zgdf){
        this.zgdf = zgdf ;
        this.modify("zgdf",zgdf);
    }

    /**
     * 设置 [指标]
     */
    public void setZb(String zb){
        this.zb = zb ;
        this.modify("zb",zb);
    }

    /**
     * 设置 [绩效主观评测明细名称]
     */
    public void setParjxzgpcmxname(String parjxzgpcmxname){
        this.parjxzgpcmxname = parjxzgpcmxname ;
        this.modify("parjxzgpcmxname",parjxzgpcmxname);
    }

    /**
     * 设置 [评分]
     */
    public void setPf(Double pf){
        this.pf = pf ;
        this.modify("pf",pf);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [最低得分]
     */
    public void setZddf(Double zddf){
        this.zddf = zddf ;
        this.modify("zddf",zddf);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [主观评测ID]
     */
    public void setParjxzgpcid(String parjxzgpcid){
        this.parjxzgpcid = parjxzgpcid ;
        this.modify("parjxzgpcid",parjxzgpcid);
    }


}


