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
 * 实体[考核评分表]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARDXKHNRMX",resultMap = "ParDxkhnrmxResultMap")
public class ParDxkhnrmx extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 考核评分表标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pardxkhnrmxid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pardxkhnrmxid")
    @JsonProperty("pardxkhnrmxid")
    private String pardxkhnrmxid;
    /**
     * 周期
     */
    @TableField(value = "zq")
    @JSONField(name = "zq")
    @JsonProperty("zq")
    private String zq;
    /**
     * 考核评分表名称
     */
    @TableField(value = "pardxkhnrmxname")
    @JSONField(name = "pardxkhnrmxname")
    @JsonProperty("pardxkhnrmxname")
    private String pardxkhnrmxname;
    /**
     * 考核得分
     */
    @TableField(value = "khdf")
    @JSONField(name = "khdf")
    @JsonProperty("khdf")
    private Double khdf;
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
     * 评分主体
     */
    @TableField(value = "pfzt")
    @JSONField(name = "pfzt")
    @JsonProperty("pfzt")
    private String pfzt;
    /**
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
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
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 身份证号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 部门
     */
    @TableField(exist = false)
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 考核内容
     */
    @TableField(exist = false)
    @JSONField(name = "parkhzcmxname")
    @JsonProperty("parkhzcmxname")
    private String parkhzcmxname;
    /**
     * 考核对象
     */
    @TableField(exist = false)
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 员工ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 考核内容ID
     */
    @TableField(value = "parkhzcmxid")
    @JSONField(name = "parkhzcmxid")
    @JsonProperty("parkhzcmxid")
    private String parkhzcmxid;

    /**
     * 考核内容
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParKhzcmx parkhzcmx;

    /**
     * 员工
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [周期]
     */
    public void setZq(String zq){
        this.zq = zq ;
        this.modify("zq",zq);
    }

    /**
     * 设置 [考核评分表名称]
     */
    public void setPardxkhnrmxname(String pardxkhnrmxname){
        this.pardxkhnrmxname = pardxkhnrmxname ;
        this.modify("pardxkhnrmxname",pardxkhnrmxname);
    }

    /**
     * 设置 [考核得分]
     */
    public void setKhdf(Double khdf){
        this.khdf = khdf ;
        this.modify("khdf",khdf);
    }

    /**
     * 设置 [评分主体]
     */
    public void setPfzt(String pfzt){
        this.pfzt = pfzt ;
        this.modify("pfzt",pfzt);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [员工ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [考核内容ID]
     */
    public void setParkhzcmxid(String parkhzcmxid){
        this.parkhzcmxid = parkhzcmxid ;
        this.modify("parkhzcmxid",parkhzcmxid);
    }


}


