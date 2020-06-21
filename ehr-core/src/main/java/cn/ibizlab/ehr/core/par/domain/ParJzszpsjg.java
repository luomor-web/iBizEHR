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
 * 实体[集中述职评审结果]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJZSZPSJG",resultMap = "ParJzszpsjgResultMap")
public class ParJzszpsjg extends EntityMP implements Serializable {

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 集中述职评审结果名称
     */
    @TableField(value = "parjzszpsjgname")
    @JSONField(name = "parjzszpsjgname")
    @JsonProperty("parjzszpsjgname")
    private String parjzszpsjgname;
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
     * 年度
     */
    @TableField(value = "nd")
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;
    /**
     * 考核对象
     */
    @TableField(value = "khdx")
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;
    /**
     * 集中述职评审分数
     */
    @TableField(value = "szpsfs")
    @JSONField(name = "szpsfs")
    @JsonProperty("szpsfs")
    private Double szpsfs;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 集中述职评审结果标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjzszpsjgid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjzszpsjgid")
    @JsonProperty("parjzszpsjgid")
    private String parjzszpsjgid;
    /**
     * 领导姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 身份证号码
     */
    @TableField(exist = false)
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;
    /**
     * 员工ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 员工
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [集中述职评审结果名称]
     */
    public void setParjzszpsjgname(String parjzszpsjgname){
        this.parjzszpsjgname = parjzszpsjgname ;
        this.modify("parjzszpsjgname",parjzszpsjgname);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [考核对象]
     */
    public void setKhdx(String khdx){
        this.khdx = khdx ;
        this.modify("khdx",khdx);
    }

    /**
     * 设置 [集中述职评审分数]
     */
    public void setSzpsfs(Double szpsfs){
        this.szpsfs = szpsfs ;
        this.modify("szpsfs",szpsfs);
    }

    /**
     * 设置 [员工ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}


