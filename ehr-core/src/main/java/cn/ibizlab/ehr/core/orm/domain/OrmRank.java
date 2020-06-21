package cn.ibizlab.ehr.core.orm.domain;

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
 * 实体[职级管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMRANK",resultMap = "OrmRankResultMap")
public class OrmRank extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 建议交流年限（年）
     */
    @TableField(value = "jyjlnx")
    @JSONField(name = "jyjlnx")
    @JsonProperty("jyjlnx")
    private Integer jyjlnx;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 职级说明
     */
    @TableField(value = "zjsm")
    @JSONField(name = "zjsm")
    @JsonProperty("zjsm")
    private String zjsm;
    /**
     * 职级
     */
    @TableField(value = "ormrankname")
    @JSONField(name = "ormrankname")
    @JsonProperty("ormrankname")
    private String ormrankname;
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
     * 职级标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormrankid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormrankid")
    @JsonProperty("ormrankid")
    private String ormrankid;



    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [建议交流年限（年）]
     */
    public void setJyjlnx(Integer jyjlnx){
        this.jyjlnx = jyjlnx ;
        this.modify("jyjlnx",jyjlnx);
    }

    /**
     * 设置 [职级说明]
     */
    public void setZjsm(String zjsm){
        this.zjsm = zjsm ;
        this.modify("zjsm",zjsm);
    }

    /**
     * 设置 [职级]
     */
    public void setOrmrankname(String ormrankname){
        this.ormrankname = ormrankname ;
        this.modify("ormrankname",ormrankname);
    }


}


