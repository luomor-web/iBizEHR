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
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
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
 * 实体[考核内容]
 */
@Data
@TableName(value = "T_PARKHZCMX",resultMap = "PARKHZCMXResultMap")
public class PARKHZCMX extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考核权重（%）
     */
    @TableField(value = "szqz")
    @JSONField(name = "szqz")
    @JsonProperty("szqz")
    private Double szqz;
    /**
     * 考核内容标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parkhzcmxid",type=IdType.UUID)
    @JSONField(name = "parkhzcmxid")
    @JsonProperty("parkhzcmxid")
    private String parkhzcmxid;
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
     * 是否启用
     */
    @TableField(value = "sfqy")
    @JSONField(name = "sfqy")
    @JsonProperty("sfqy")
    private Integer sfqy;
    /**
     * 考核内容
     */
    @TableField(value = "parkhzcmxname")
    @JSONField(name = "parkhzcmxname")
    @JsonProperty("parkhzcmxname")
    private String parkhzcmxname;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 考核对象
     */
    @TableField(exist = false)
    @JSONField(name = "khdx")
    @JsonProperty("khdx")
    private String khdx;
    /**
     * 考核方案
     */
    @TableField(exist = false)
    @JSONField(name = "parjxkhjcszname")
    @JsonProperty("parjxkhjcszname")
    private String parjxkhjcszname;
    /**
     * 考核方案ID
     */
    @TableField(value = "parjxkhjcszid")
    @JSONField(name = "parjxkhjcszid")
    @JsonProperty("parjxkhjcszid")
    private String parjxkhjcszid;

    /**
     * 考核方案
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.PARJXKHJCSZ parjxkhjcsz;



    /**
     * 设置 [考核权重（%）]
     */
    public void setSzqz(Double szqz){
        this.szqz = szqz ;
        this.modify("szqz",szqz);
    }
    /**
     * 设置 [是否启用]
     */
    public void setSfqy(Integer sfqy){
        this.sfqy = sfqy ;
        this.modify("sfqy",sfqy);
    }
    /**
     * 设置 [考核内容]
     */
    public void setParkhzcmxname(String parkhzcmxname){
        this.parkhzcmxname = parkhzcmxname ;
        this.modify("parkhzcmxname",parkhzcmxname);
    }
    /**
     * 设置 [考核方案ID]
     */
    public void setParjxkhjcszid(String parjxkhjcszid){
        this.parjxkhjcszid = parjxkhjcszid ;
        this.modify("parjxkhjcszid",parjxkhjcszid);
    }

}


