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
 * 实体[绩效主观评测]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXZGPC",resultMap = "ParJxzgpcResultMap")
public class ParJxzgpc extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 绩效主观评测标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxzgpcid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxzgpcid")
    @JsonProperty("parjxzgpcid")
    private String parjxzgpcid;
    /**
     * 员工
     */
    @TableField(value = "ygname")
    @JSONField(name = "ygname")
    @JsonProperty("ygname")
    private String ygname;
    /**
     * 评分领导
     */
    @TableField(value = "pfld")
    @JSONField(name = "pfld")
    @JsonProperty("pfld")
    private String pfld;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 考核项
     */
    @TableField(value = "khx")
    @JSONField(name = "khx")
    @JsonProperty("khx")
    private String khx;
    /**
     * 考核类型
     */
    @TableField(value = "khlx")
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;
    /**
     * 所属组织ID
     */
    @TableField(value = "sszzid")
    @JSONField(name = "sszzid")
    @JsonProperty("sszzid")
    private String sszzid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 所属部门ID
     */
    @TableField(value = "ssbmid")
    @JSONField(name = "ssbmid")
    @JsonProperty("ssbmid")
    private String ssbmid;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 标题
     */
    @TableField(value = "parjxzgpcname")
    @JSONField(name = "parjxzgpcname")
    @JsonProperty("parjxzgpcname")
    private String parjxzgpcname;
    /**
     * 评分领导ID
     */
    @TableField(value = "pfldid")
    @JSONField(name = "pfldid")
    @JsonProperty("pfldid")
    private String pfldid;
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
     * 总得分
     */
    @TableField(value = "zdf")
    @JSONField(name = "zdf")
    @JsonProperty("zdf")
    private Double zdf;
    /**
     * 所属部门
     */
    @TableField(value = "ssbm")
    @JSONField(name = "ssbm")
    @JsonProperty("ssbm")
    private String ssbm;
    /**
     * 员工ID
     */
    @TableField(value = "ygid")
    @JSONField(name = "ygid")
    @JsonProperty("ygid")
    private String ygid;
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
     * 所属组织
     */
    @TableField(value = "sszz")
    @JSONField(name = "sszz")
    @JsonProperty("sszz")
    private String sszz;



    /**
     * 设置 [员工]
     */
    public void setYgname(String ygname){
        this.ygname = ygname ;
        this.modify("ygname",ygname);
    }

    /**
     * 设置 [评分领导]
     */
    public void setPfld(String pfld){
        this.pfld = pfld ;
        this.modify("pfld",pfld);
    }

    /**
     * 设置 [考核项]
     */
    public void setKhx(String khx){
        this.khx = khx ;
        this.modify("khx",khx);
    }

    /**
     * 设置 [考核类型]
     */
    public void setKhlx(String khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [所属组织ID]
     */
    public void setSszzid(String sszzid){
        this.sszzid = sszzid ;
        this.modify("sszzid",sszzid);
    }

    /**
     * 设置 [所属部门ID]
     */
    public void setSsbmid(String ssbmid){
        this.ssbmid = ssbmid ;
        this.modify("ssbmid",ssbmid);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [标题]
     */
    public void setParjxzgpcname(String parjxzgpcname){
        this.parjxzgpcname = parjxzgpcname ;
        this.modify("parjxzgpcname",parjxzgpcname);
    }

    /**
     * 设置 [评分领导ID]
     */
    public void setPfldid(String pfldid){
        this.pfldid = pfldid ;
        this.modify("pfldid",pfldid);
    }

    /**
     * 设置 [总得分]
     */
    public void setZdf(Double zdf){
        this.zdf = zdf ;
        this.modify("zdf",zdf);
    }

    /**
     * 设置 [所属部门]
     */
    public void setSsbm(String ssbm){
        this.ssbm = ssbm ;
        this.modify("ssbm",ssbm);
    }

    /**
     * 设置 [员工ID]
     */
    public void setYgid(String ygid){
        this.ygid = ygid ;
        this.modify("ygid",ygid);
    }

    /**
     * 设置 [所属组织]
     */
    public void setSszz(String sszz){
        this.sszz = sszz ;
        this.modify("sszz",sszz);
    }


}


