package cn.ibizlab.ehr.webapi.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.ehr.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[PimSearchFieldSetDTO]
 */
@Data
public class PimSearchFieldSetDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [LINKFIELDNAME]
     *
     */
    @JSONField(name = "linkfieldname")
    @JsonProperty("linkfieldname")
    private String linkfieldname;

    /**
     * 属性 [SEARCHTAG]
     *
     */
    @JSONField(name = "searchtag")
    @JsonProperty("searchtag")
    private Integer searchtag;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PXH2]
     *
     */
    @JSONField(name = "pxh2")
    @JsonProperty("pxh2")
    private Integer pxh2;

    /**
     * 属性 [ISSHOWN]
     *
     */
    @JSONField(name = "isshown")
    @JsonProperty("isshown")
    private Integer isshown;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [COLUMNNAME]
     *
     */
    @JSONField(name = "columnname")
    @JsonProperty("columnname")
    private String columnname;

    /**
     * 属性 [COLUMNWIDTH]
     *
     */
    @JSONField(name = "columnwidth")
    @JsonProperty("columnwidth")
    private Integer columnwidth;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ENTITYLOGICNAME]
     *
     */
    @JSONField(name = "entitylogicname")
    @JsonProperty("entitylogicname")
    private String entitylogicname;

    /**
     * 属性 [PIMSEARCHFIELDSETID]
     *
     */
    @JSONField(name = "pimsearchfieldsetid")
    @JsonProperty("pimsearchfieldsetid")
    private String pimsearchfieldsetid;

    /**
     * 属性 [PIMSEARCHFIELDSETNAME]
     *
     */
    @JSONField(name = "pimsearchfieldsetname")
    @JsonProperty("pimsearchfieldsetname")
    private String pimsearchfieldsetname;

    /**
     * 属性 [ENTITYID]
     *
     */
    @JSONField(name = "entityid")
    @JsonProperty("entityid")
    private String entityid;

    /**
     * 属性 [COLUMNLOGICNAME]
     *
     */
    @JSONField(name = "columnlogicname")
    @JsonProperty("columnlogicname")
    private String columnlogicname;

    /**
     * 属性 [VNAME]
     *
     */
    @JSONField(name = "vname")
    @JsonProperty("vname")
    private String vname;

    /**
     * 属性 [FIELDTYPE]
     *
     */
    @JSONField(name = "fieldtype")
    @JsonProperty("fieldtype")
    private String fieldtype;

    /**
     * 属性 [CODELISTID]
     *
     */
    @JSONField(name = "codelistid")
    @JsonProperty("codelistid")
    private String codelistid;

    /**
     * 属性 [ENTITYNAME]
     *
     */
    @JSONField(name = "entityname")
    @JsonProperty("entityname")
    private String entityname;

    /**
     * 属性 [TNAME]
     *
     */
    @JSONField(name = "tname")
    @JsonProperty("tname")
    private String tname;

    /**
     * 属性 [PXH]
     *
     */
    @JSONField(name = "pxh")
    @JsonProperty("pxh")
    private Integer pxh;


    /**
     * 设置 [LINKFIELDNAME]
     */
    public void setLinkfieldname(String  linkfieldname){
        this.linkfieldname = linkfieldname ;
        this.modify("linkfieldname",linkfieldname);
    }

    /**
     * 设置 [SEARCHTAG]
     */
    public void setSearchtag(Integer  searchtag){
        this.searchtag = searchtag ;
        this.modify("searchtag",searchtag);
    }

    /**
     * 设置 [PXH2]
     */
    public void setPxh2(Integer  pxh2){
        this.pxh2 = pxh2 ;
        this.modify("pxh2",pxh2);
    }

    /**
     * 设置 [ISSHOWN]
     */
    public void setIsshown(Integer  isshown){
        this.isshown = isshown ;
        this.modify("isshown",isshown);
    }

    /**
     * 设置 [COLUMNNAME]
     */
    public void setColumnname(String  columnname){
        this.columnname = columnname ;
        this.modify("columnname",columnname);
    }

    /**
     * 设置 [COLUMNWIDTH]
     */
    public void setColumnwidth(Integer  columnwidth){
        this.columnwidth = columnwidth ;
        this.modify("columnwidth",columnwidth);
    }

    /**
     * 设置 [ENTITYLOGICNAME]
     */
    public void setEntitylogicname(String  entitylogicname){
        this.entitylogicname = entitylogicname ;
        this.modify("entitylogicname",entitylogicname);
    }

    /**
     * 设置 [PIMSEARCHFIELDSETNAME]
     */
    public void setPimsearchfieldsetname(String  pimsearchfieldsetname){
        this.pimsearchfieldsetname = pimsearchfieldsetname ;
        this.modify("pimsearchfieldsetname",pimsearchfieldsetname);
    }

    /**
     * 设置 [ENTITYID]
     */
    public void setEntityid(String  entityid){
        this.entityid = entityid ;
        this.modify("entityid",entityid);
    }

    /**
     * 设置 [COLUMNLOGICNAME]
     */
    public void setColumnlogicname(String  columnlogicname){
        this.columnlogicname = columnlogicname ;
        this.modify("columnlogicname",columnlogicname);
    }

    /**
     * 设置 [VNAME]
     */
    public void setVname(String  vname){
        this.vname = vname ;
        this.modify("vname",vname);
    }

    /**
     * 设置 [FIELDTYPE]
     */
    public void setFieldtype(String  fieldtype){
        this.fieldtype = fieldtype ;
        this.modify("fieldtype",fieldtype);
    }

    /**
     * 设置 [CODELISTID]
     */
    public void setCodelistid(String  codelistid){
        this.codelistid = codelistid ;
        this.modify("codelistid",codelistid);
    }

    /**
     * 设置 [ENTITYNAME]
     */
    public void setEntityname(String  entityname){
        this.entityname = entityname ;
        this.modify("entityname",entityname);
    }

    /**
     * 设置 [TNAME]
     */
    public void setTname(String  tname){
        this.tname = tname ;
        this.modify("tname",tname);
    }

    /**
     * 设置 [PXH]
     */
    public void setPxh(Integer  pxh){
        this.pxh = pxh ;
        this.modify("pxh",pxh);
    }


}

