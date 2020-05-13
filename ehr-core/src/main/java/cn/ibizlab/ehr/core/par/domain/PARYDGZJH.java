package cn.ibizlab.ehr.core.par.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[月度工作计划]
 */
@Data
@TableName(value = "T_PARYDGZJH",resultMap = "PARYDGZJHResultMap")
public class PARYDGZJH extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 月度
     */
    @TableField(value = "yd")
    @JSONField(name = "yd")
    @JsonProperty("yd")
    private String yd;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 月度工作计划名称
     */
    @TableField(value = "parydgzjhname")
    @JSONField(name = "parydgzjhname")
    @JsonProperty("parydgzjhname")
    private String parydgzjhname;
    /**
     * 月度工作计划标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parydgzjhid",type=IdType.UUID)
    @JSONField(name = "parydgzjhid")
    @JsonProperty("parydgzjhid")
    private String parydgzjhid;
    /**
     * 日期
     */
    @TableField(value = "rq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "rq" , format="yyyy-MM-dd")
    @JsonProperty("rq")
    private Timestamp rq;
    /**
     * 填报部门
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 填报部门ID
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 填报部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector;



    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }
    /**
     * 设置 [月度]
     */
    public void setYd(String yd){
        this.yd = yd ;
        this.modify("yd",yd);
    }
    /**
     * 设置 [月度工作计划名称]
     */
    public void setParydgzjhname(String parydgzjhname){
        this.parydgzjhname = parydgzjhname ;
        this.modify("parydgzjhname",parydgzjhname);
    }
    /**
     * 设置 [日期]
     */
    public void setRq(Timestamp rq){
        this.rq = rq ;
        this.modify("rq",rq);
    }
    /**
     * 设置 [填报部门ID]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }
}





