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
 * 实体[部门评级标准]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARJGBMPJBZ",resultMap = "ParJgbmpjbzResultMap")
public class ParJgbmpjbz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评级
     */
    @TableField(value = "pj")
    @JSONField(name = "pj")
    @JsonProperty("pj")
    private String pj;
    /**
     * 部门评级
     */
    @TableField(value = "bmpj")
    @JSONField(name = "bmpj")
    @JsonProperty("bmpj")
    private String bmpj;
    /**
     * 评级比例(%)
     */
    @TableField(value = "pjbl")
    @JSONField(name = "pjbl")
    @JsonProperty("pjbl")
    private Integer pjbl;
    /**
     * 部门评级标准标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parjgbmpjbzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parjgbmpjbzid")
    @JsonProperty("parjgbmpjbzid")
    private String parjgbmpjbzid;
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
     * 部门评级标准名称
     */
    @TableField(value = "parjgbmpjbzname")
    @JSONField(name = "parjgbmpjbzname")
    @JsonProperty("parjgbmpjbzname")
    private String parjgbmpjbzname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 档级
     */
    @TableField(value = "dj")
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 评级
     */
    @TableField(exist = false)
    @JSONField(name = "pjbzmc")
    @JsonProperty("pjbzmc")
    private String pjbzmc;
    /**
     * 评级ID
     */
    @TableField(value = "pjbzid")
    @JSONField(name = "pjbzid")
    @JsonProperty("pjbzid")
    private String pjbzid;
    /**
     * 组织ID
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 部门ID
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 评级
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParJgbmpjbz pjbz;



    /**
     * 设置 [评级]
     */
    public void setPj(String pj){
        this.pj = pj ;
        this.modify("pj",pj);
    }

    /**
     * 设置 [部门评级]
     */
    public void setBmpj(String bmpj){
        this.bmpj = bmpj ;
        this.modify("bmpj",bmpj);
    }

    /**
     * 设置 [评级比例(%)]
     */
    public void setPjbl(Integer pjbl){
        this.pjbl = pjbl ;
        this.modify("pjbl",pjbl);
    }

    /**
     * 设置 [部门评级标准名称]
     */
    public void setParjgbmpjbzname(String parjgbmpjbzname){
        this.parjgbmpjbzname = parjgbmpjbzname ;
        this.modify("parjgbmpjbzname",parjgbmpjbzname);
    }

    /**
     * 设置 [档级]
     */
    public void setDj(String dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [评级ID]
     */
    public void setPjbzid(String pjbzid){
        this.pjbzid = pjbzid ;
        this.modify("pjbzid",pjbzid);
    }

    /**
     * 设置 [组织ID]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [部门ID]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }


}


