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
 * 实体[绩效结果]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXJG",resultMap = "ParJxjgResultMap")
public class ParJxjg extends EntityMP implements Serializable {

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
     * 排名
     */
    @TableField(value = "pm")
    @JSONField(name = "pm")
    @JsonProperty("pm")
    private Integer pm;
    /**
     * 绩效结果标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxjgid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxjgid")
    @JsonProperty("parjxjgid")
    private String parjxjgid;
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
     * 部门
     */
    @TableField(value = "bm")
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 考核定级
     */
    @TableField(value = "khpgdj")
    @JSONField(name = "khpgdj")
    @JsonProperty("khpgdj")
    private String khpgdj;
    /**
     * 绩效结果名称
     */
    @TableField(value = "parjxjgname")
    @JSONField(name = "parjxjgname")
    @JsonProperty("parjxjgname")
    private String parjxjgname;
    /**
     * 员工
     */
    @TableField(value = "yg")
    @JSONField(name = "yg")
    @JsonProperty("yg")
    private String yg;
    /**
     * 考核年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 考核对象
     */
    @TableField(value = "khlx")
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;
    /**
     * 员工ID
     */
    @TableField(value = "ygid")
    @JSONField(name = "ygid")
    @JsonProperty("ygid")
    private String ygid;
    /**
     * 总分
     */
    @TableField(value = "zf")
    @JSONField(name = "zf")
    @JsonProperty("zf")
    private Double zf;
    /**
     * 组织
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
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
     * 设置 [排名]
     */
    public void setPm(Integer pm){
        this.pm = pm ;
        this.modify("pm",pm);
    }

    /**
     * 设置 [部门]
     */
    public void setBm(String bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [考核定级]
     */
    public void setKhpgdj(String khpgdj){
        this.khpgdj = khpgdj ;
        this.modify("khpgdj",khpgdj);
    }

    /**
     * 设置 [绩效结果名称]
     */
    public void setParjxjgname(String parjxjgname){
        this.parjxjgname = parjxjgname ;
        this.modify("parjxjgname",parjxjgname);
    }

    /**
     * 设置 [员工]
     */
    public void setYg(String yg){
        this.yg = yg ;
        this.modify("yg",yg);
    }

    /**
     * 设置 [考核年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [考核对象]
     */
    public void setKhlx(String khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [员工ID]
     */
    public void setYgid(String ygid){
        this.ygid = ygid ;
        this.modify("ygid",ygid);
    }

    /**
     * 设置 [总分]
     */
    public void setZf(Double zf){
        this.zf = zf ;
        this.modify("zf",zf);
    }

    /**
     * 设置 [组织]
     */
    public void setZz(String zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }


}


