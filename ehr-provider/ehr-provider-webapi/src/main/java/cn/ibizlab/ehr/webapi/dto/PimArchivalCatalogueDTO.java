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
 * 服务DTO对象[PimArchivalCatalogueDTO]
 */
@Data
public class PimArchivalCatalogueDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SERIALNUMBER]
     *
     */
    @JSONField(name = "serialnumber")
    @JsonProperty("serialnumber")
    private Integer serialnumber;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ARCHIVALCATALOGUEID]
     *
     */
    @JSONField(name = "archivalcatalogueid")
    @JsonProperty("archivalcatalogueid")
    private String archivalcatalogueid;

    /**
     * 属性 [ARCHIVALCATALOGUENAME]
     *
     */
    @JSONField(name = "archivalcataloguename")
    @JsonProperty("archivalcataloguename")
    private String archivalcataloguename;

    /**
     * 属性 [PIMARCHIVESNAME]
     *
     */
    @JSONField(name = "pimarchivesname")
    @JsonProperty("pimarchivesname")
    private String pimarchivesname;

    /**
     * 属性 [PIMARCHIVESID]
     *
     */
    @JSONField(name = "pimarchivesid")
    @JsonProperty("pimarchivesid")
    private String pimarchivesid;


    /**
     * 设置 [SERIALNUMBER]
     */
    public void setSerialnumber(Integer  serialnumber){
        this.serialnumber = serialnumber ;
        this.modify("serialnumber",serialnumber);
    }

    /**
     * 设置 [ARCHIVALCATALOGUENAME]
     */
    public void setArchivalcataloguename(String  archivalcataloguename){
        this.archivalcataloguename = archivalcataloguename ;
        this.modify("archivalcataloguename",archivalcataloguename);
    }

    /**
     * 设置 [PIMARCHIVESID]
     */
    public void setPimarchivesid(String  pimarchivesid){
        this.pimarchivesid = pimarchivesid ;
        this.modify("pimarchivesid",pimarchivesid);
    }


}

