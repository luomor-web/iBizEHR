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
 * 实体[绩效标准管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJXBZGL",resultMap = "ParJxbzglResultMap")
public class ParJxbzgl extends EntityMP implements Serializable {

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
     * 绩效标准管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjxbzglid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjxbzglid")
    @JsonProperty("parjxbzglid")
    private String parjxbzglid;
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
     * 考核类型
     */
    @TableField(value = "khlx")
    @JSONField(name = "khlx")
    @JsonProperty("khlx")
    private String khlx;
    /**
     * 绩效标准管理名称
     */
    @TableField(value = "parjxbzglname")
    @JSONField(name = "parjxbzglname")
    @JsonProperty("parjxbzglname")
    private String parjxbzglname;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 是否启用
     */
    @TableField(value = "sfqy")
    @JSONField(name = "sfqy")
    @JsonProperty("sfqy")
    private Integer sfqy;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 组织ID
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;



    /**
     * 设置 [考核类型]
     */
    public void setKhlx(String khlx){
        this.khlx = khlx ;
        this.modify("khlx",khlx);
    }

    /**
     * 设置 [绩效标准管理名称]
     */
    public void setParjxbzglname(String parjxbzglname){
        this.parjxbzglname = parjxbzglname ;
        this.modify("parjxbzglname",parjxbzglname);
    }

    /**
     * 设置 [年度]
     */
    public void setNd(String nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [是否启用]
     */
    public void setSfqy(Integer sfqy){
        this.sfqy = sfqy ;
        this.modify("sfqy",sfqy);
    }

    /**
     * 设置 [组织ID]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


