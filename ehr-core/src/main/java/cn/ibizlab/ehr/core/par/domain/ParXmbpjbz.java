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
 * 实体[项目部评级标准]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PARXMBPJBZ",resultMap = "ParXmbpjbzResultMap")
public class ParXmbpjbz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 档级比例(%)
     */
    @TableField(value = "djbl")
    @JSONField(name = "djbl")
    @JsonProperty("djbl")
    private Integer djbl;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 项目部评级标准标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "parxmbpjbzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "parxmbpjbzid")
    @JsonProperty("parxmbpjbzid")
    private String parxmbpjbzid;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 岗位类型
     */
    @TableField(value = "gwlx")
    @JSONField(name = "gwlx")
    @JsonProperty("gwlx")
    private String gwlx;
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
     * 项目部评级标准名称
     */
    @TableField(value = "parxmbpjbzname")
    @JSONField(name = "parxmbpjbzname")
    @JsonProperty("parxmbpjbzname")
    private String parxmbpjbzname;
    /**
     * 档级
     */
    @TableField(value = "dj")
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 项目部评级标准
     */
    @TableField(exist = false)
    @JSONField(name = "xmbpjbzmc")
    @JsonProperty("xmbpjbzmc")
    private String xmbpjbzmc;
    /**
     * 组织ID
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 评级标准ID
     */
    @TableField(value = "xmbpjbzid")
    @JSONField(name = "xmbpjbzid")
    @JsonProperty("xmbpjbzid")
    private String xmbpjbzid;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 评级标准
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.par.domain.ParXmbpjbz parxmbpjbz;



    /**
     * 设置 [档级比例(%)]
     */
    public void setDjbl(Integer djbl){
        this.djbl = djbl ;
        this.modify("djbl",djbl);
    }

    /**
     * 设置 [岗位类型]
     */
    public void setGwlx(String gwlx){
        this.gwlx = gwlx ;
        this.modify("gwlx",gwlx);
    }

    /**
     * 设置 [项目部评级标准名称]
     */
    public void setParxmbpjbzname(String parxmbpjbzname){
        this.parxmbpjbzname = parxmbpjbzname ;
        this.modify("parxmbpjbzname",parxmbpjbzname);
    }

    /**
     * 设置 [档级]
     */
    public void setDj(String dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [组织ID]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [评级标准ID]
     */
    public void setXmbpjbzid(String xmbpjbzid){
        this.xmbpjbzid = xmbpjbzid ;
        this.modify("xmbpjbzid",xmbpjbzid);
    }


}


