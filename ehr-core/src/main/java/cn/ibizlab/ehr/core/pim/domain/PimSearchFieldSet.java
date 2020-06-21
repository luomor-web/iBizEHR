package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[组合查询条件设置]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PIMSEARCHFIELDSET",resultMap = "PimSearchFieldSetResultMap")
public class PimSearchFieldSet extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关系属性
     */
    @TableField(value = "linkfieldname")
    @JSONField(name = "linkfieldname")
    @JsonProperty("linkfieldname")
    private String linkfieldname;
    /**
     * 是否可查
     */
    @TableField(value = "searchtag")
    @JSONField(name = "searchtag")
    @JsonProperty("searchtag")
    private Integer searchtag;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 排序号2
     */
    @TableField(value = "pxh2")
    @JSONField(name = "pxh2")
    @JsonProperty("pxh2")
    private Integer pxh2;
    /**
     * 是否可见
     */
    @TableField(value = "isshown")
    @JSONField(name = "isshown")
    @JsonProperty("isshown")
    private Integer isshown;
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
     * 列名称
     */
    @TableField(value = "columnname")
    @JSONField(name = "columnname")
    @JsonProperty("columnname")
    private String columnname;
    /**
     * 宽度
     */
    @TableField(value = "columnwidth")
    @JSONField(name = "columnwidth")
    @JsonProperty("columnwidth")
    private Integer columnwidth;
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
     * 实体逻辑名称
     */
    @TableField(value = "entitylogicname")
    @JSONField(name = "entitylogicname")
    @JsonProperty("entitylogicname")
    private String entitylogicname;
    /**
     * 组合查询条件设置标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pimsearchfieldsetid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pimsearchfieldsetid")
    @JsonProperty("pimsearchfieldsetid")
    private String pimsearchfieldsetid;
    /**
     * 组合查询条件设置名称
     */
    @TableField(value = "pimsearchfieldsetname")
    @JSONField(name = "pimsearchfieldsetname")
    @JsonProperty("pimsearchfieldsetname")
    private String pimsearchfieldsetname;
    /**
     * 实体id
     */
    @TableField(value = "entityid")
    @JSONField(name = "entityid")
    @JsonProperty("entityid")
    private String entityid;
    /**
     * 列逻辑名称
     */
    @TableField(value = "columnlogicname")
    @JSONField(name = "columnlogicname")
    @JsonProperty("columnlogicname")
    private String columnlogicname;
    /**
     * 视图名称
     */
    @TableField(value = "vname")
    @JSONField(name = "vname")
    @JsonProperty("vname")
    private String vname;
    /**
     * 属性类型
     */
    @TableField(value = "fieldtype")
    @JSONField(name = "fieldtype")
    @JsonProperty("fieldtype")
    private String fieldtype;
    /**
     * 代码表
     */
    @TableField(value = "codelistid")
    @JSONField(name = "codelistid")
    @JsonProperty("codelistid")
    private String codelistid;
    /**
     * 实体名称
     */
    @TableField(value = "entityname")
    @JSONField(name = "entityname")
    @JsonProperty("entityname")
    private String entityname;
    /**
     * 表名称
     */
    @TableField(value = "tname")
    @JSONField(name = "tname")
    @JsonProperty("tname")
    private String tname;
    /**
     * 排序号
     */
    @TableField(value = "pxh")
    @JSONField(name = "pxh")
    @JsonProperty("pxh")
    private Integer pxh;



    /**
     * 设置 [关系属性]
     */
    public void setLinkfieldname(String linkfieldname){
        this.linkfieldname = linkfieldname ;
        this.modify("linkfieldname",linkfieldname);
    }

    /**
     * 设置 [是否可查]
     */
    public void setSearchtag(Integer searchtag){
        this.searchtag = searchtag ;
        this.modify("searchtag",searchtag);
    }

    /**
     * 设置 [排序号2]
     */
    public void setPxh2(Integer pxh2){
        this.pxh2 = pxh2 ;
        this.modify("pxh2",pxh2);
    }

    /**
     * 设置 [是否可见]
     */
    public void setIsshown(Integer isshown){
        this.isshown = isshown ;
        this.modify("isshown",isshown);
    }

    /**
     * 设置 [列名称]
     */
    public void setColumnname(String columnname){
        this.columnname = columnname ;
        this.modify("columnname",columnname);
    }

    /**
     * 设置 [宽度]
     */
    public void setColumnwidth(Integer columnwidth){
        this.columnwidth = columnwidth ;
        this.modify("columnwidth",columnwidth);
    }

    /**
     * 设置 [实体逻辑名称]
     */
    public void setEntitylogicname(String entitylogicname){
        this.entitylogicname = entitylogicname ;
        this.modify("entitylogicname",entitylogicname);
    }

    /**
     * 设置 [组合查询条件设置名称]
     */
    public void setPimsearchfieldsetname(String pimsearchfieldsetname){
        this.pimsearchfieldsetname = pimsearchfieldsetname ;
        this.modify("pimsearchfieldsetname",pimsearchfieldsetname);
    }

    /**
     * 设置 [实体id]
     */
    public void setEntityid(String entityid){
        this.entityid = entityid ;
        this.modify("entityid",entityid);
    }

    /**
     * 设置 [列逻辑名称]
     */
    public void setColumnlogicname(String columnlogicname){
        this.columnlogicname = columnlogicname ;
        this.modify("columnlogicname",columnlogicname);
    }

    /**
     * 设置 [视图名称]
     */
    public void setVname(String vname){
        this.vname = vname ;
        this.modify("vname",vname);
    }

    /**
     * 设置 [属性类型]
     */
    public void setFieldtype(String fieldtype){
        this.fieldtype = fieldtype ;
        this.modify("fieldtype",fieldtype);
    }

    /**
     * 设置 [代码表]
     */
    public void setCodelistid(String codelistid){
        this.codelistid = codelistid ;
        this.modify("codelistid",codelistid);
    }

    /**
     * 设置 [实体名称]
     */
    public void setEntityname(String entityname){
        this.entityname = entityname ;
        this.modify("entityname",entityname);
    }

    /**
     * 设置 [表名称]
     */
    public void setTname(String tname){
        this.tname = tname ;
        this.modify("tname",tname);
    }

    /**
     * 设置 [排序号]
     */
    public void setPxh(Integer pxh){
        this.pxh = pxh ;
        this.modify("pxh",pxh);
    }


}


