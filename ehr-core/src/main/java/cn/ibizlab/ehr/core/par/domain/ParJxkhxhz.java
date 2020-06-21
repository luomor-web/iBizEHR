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
 * 实体[考核方案]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXKHXHZ",resultMap = "ParJxkhxhzResultMap")
public class ParJxkhxhz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
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
     * 月度计划
     */
    @TableField(value = "jswmjc")
    @JSONField(name = "jswmjc")
    @JsonProperty("jswmjc")
    private Double jswmjc;
    /**
     * 集中述职评审
     */
    @TableField(value = "szmzpy")
    @JSONField(name = "szmzpy")
    @JsonProperty("szmzpy")
    private Double szmzpy;
    /**
     * 考核对象
     */
    @TableField(value = "khlx")
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;
    /**
     * 工作周报
     */
    @TableField(value = "ywnlks")
    @JSONField(name = "ywnlks")
    @JsonProperty("ywnlks")
    private Double ywnlks;
    /**
     * 绩效考核项得分汇总名称
     */
    @TableField(value = "parjxkhxhzname")
    @JSONField(name = "parjxkhxhzname")
    @JsonProperty("parjxkhxhzname")
    private String parjxkhxhzname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 所属组织
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 员工ID
     */
    @TableField(value = "ygid")
    @JSONField(name = "ygid")
    @JsonProperty("ygid")
    private String ygid;
    /**
     * 工作能力及态度评价（上半年）
     */
    @TableField(value = "gznljtd")
    @JSONField(name = "gznljtd")
    @JsonProperty("gznljtd")
    private Double gznljtd;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 工作能力及态度评价
     */
    @DEField(name = "gznljtd_xbn")
    @TableField(value = "gznljtd_xbn")
    @JSONField(name = "gznljtd_xbn")
    @JsonProperty("gznljtd_xbn")
    private Double gznljtdXbn;
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
     * 绩效考核项得分汇总标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxkhxhzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxkhxhzid")
    @JsonProperty("parjxkhxhzid")
    private String parjxkhxhzid;
    /**
     * 量化目标
     */
    @TableField(value = "gzjx")
    @JSONField(name = "gzjx")
    @JsonProperty("gzjx")
    private Double gzjx;
    /**
     * 员工
     */
    @TableField(value = "yg")
    @JSONField(name = "yg")
    @JsonProperty("yg")
    private String yg;
    /**
     * 部门
     */
    @TableField(value = "bm")
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 考核模板标识
     */
    @TableField(value = "parassesstemplateid")
    @JSONField(name = "parassesstemplateid")
    @JsonProperty("parassesstemplateid")
    private String parassesstemplateid;
    /**
     * 考核模板名称
     */
    @TableField(exist = false)
    @JSONField(name = "parassesstemplatename")
    @JsonProperty("parassesstemplatename")
    private String parassesstemplatename;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

    /**
     * 考核模板
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParAssessTemplate parassesstemplate;



    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [月度计划]
     */
    public void setJswmjc(Double jswmjc){
        this.jswmjc = jswmjc ;
        this.modify("jswmjc",jswmjc);
    }

    /**
     * 设置 [集中述职评审]
     */
    public void setSzmzpy(Double szmzpy){
        this.szmzpy = szmzpy ;
        this.modify("szmzpy",szmzpy);
    }

    /**
     * 设置 [考核对象]
     */
    public void setKhlx(String khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [工作周报]
     */
    public void setYwnlks(Double ywnlks){
        this.ywnlks = ywnlks ;
        this.modify("ywnlks",ywnlks);
    }

    /**
     * 设置 [绩效考核项得分汇总名称]
     */
    public void setParjxkhxhzname(String parjxkhxhzname){
        this.parjxkhxhzname = parjxkhxhzname ;
        this.modify("parjxkhxhzname",parjxkhxhzname);
    }

    /**
     * 设置 [所属组织]
     */
    public void setZz(String zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [员工ID]
     */
    public void setYgid(String ygid){
        this.ygid = ygid ;
        this.modify("ygid",ygid);
    }

    /**
     * 设置 [工作能力及态度评价（上半年）]
     */
    public void setGznljtd(Double gznljtd){
        this.gznljtd = gznljtd ;
        this.modify("gznljtd",gznljtd);
    }

    /**
     * 设置 [工作能力及态度评价]
     */
    public void setGznljtdXbn(Double gznljtdXbn){
        this.gznljtdXbn = gznljtdXbn ;
        this.modify("gznljtd_xbn",gznljtdXbn);
    }

    /**
     * 设置 [量化目标]
     */
    public void setGzjx(Double gzjx){
        this.gzjx = gzjx ;
        this.modify("gzjx",gzjx);
    }

    /**
     * 设置 [员工]
     */
    public void setYg(String yg){
        this.yg = yg ;
        this.modify("yg",yg);
    }

    /**
     * 设置 [部门]
     */
    public void setBm(String bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [考核模板标识]
     */
    public void setParassesstemplateid(String parassesstemplateid){
        this.parassesstemplateid = parassesstemplateid ;
        this.modify("parassesstemplateid",parassesstemplateid);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }


}


