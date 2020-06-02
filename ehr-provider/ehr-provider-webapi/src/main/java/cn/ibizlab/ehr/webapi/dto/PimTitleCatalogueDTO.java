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
 * 服务DTO对象[PimTitleCatalogueDTO]
 */
@Data
public class PimTitleCatalogueDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [DH]
     *
     */
    @JSONField(name = "dh")
    @JsonProperty("dh")
    private String dh;

    /**
     * 属性 [TITLETYPE]
     *
     */
    @JSONField(name = "titletype")
    @JsonProperty("titletype")
    private String titletype;

    /**
     * 属性 [ZCLC]
     *
     */
    @JSONField(name = "zclc")
    @JsonProperty("zclc")
    private String zclc;

    /**
     * 属性 [PIMTITLECATALOGUENAME]
     *
     */
    @JSONField(name = "pimtitlecataloguename")
    @JsonProperty("pimtitlecataloguename")
    private String pimtitlecataloguename;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ZCDJ]
     *
     */
    @JSONField(name = "zcdj")
    @JsonProperty("zcdj")
    private String zcdj;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PXH]
     *
     */
    @JSONField(name = "pxh")
    @JsonProperty("pxh")
    private Integer pxh;

    /**
     * 属性 [PIMTITLECATALOGUEID]
     *
     */
    @JSONField(name = "pimtitlecatalogueid")
    @JsonProperty("pimtitlecatalogueid")
    private String pimtitlecatalogueid;

    /**
     * 属性 [PIMTITLECATALOGUENAME2]
     *
     */
    @JSONField(name = "pimtitlecataloguename2")
    @JsonProperty("pimtitlecataloguename2")
    private String pimtitlecataloguename2;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMTITLECATALOGUEID2]
     *
     */
    @JSONField(name = "pimtitlecatalogueid2")
    @JsonProperty("pimtitlecatalogueid2")
    private String pimtitlecatalogueid2;


    /**
     * 设置 [DH]
     */
    public void setDh(String  dh){
        this.dh = dh ;
        this.modify("dh",dh);
    }

    /**
     * 设置 [TITLETYPE]
     */
    public void setTitletype(String  titletype){
        this.titletype = titletype ;
        this.modify("titletype",titletype);
    }

    /**
     * 设置 [ZCLC]
     */
    public void setZclc(String  zclc){
        this.zclc = zclc ;
        this.modify("zclc",zclc);
    }

    /**
     * 设置 [PIMTITLECATALOGUENAME]
     */
    public void setPimtitlecataloguename(String  pimtitlecataloguename){
        this.pimtitlecataloguename = pimtitlecataloguename ;
        this.modify("pimtitlecataloguename",pimtitlecataloguename);
    }

    /**
     * 设置 [ZCDJ]
     */
    public void setZcdj(String  zcdj){
        this.zcdj = zcdj ;
        this.modify("zcdj",zcdj);
    }

    /**
     * 设置 [PXH]
     */
    public void setPxh(Integer  pxh){
        this.pxh = pxh ;
        this.modify("pxh",pxh);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [PIMTITLECATALOGUEID2]
     */
    public void setPimtitlecatalogueid2(String  pimtitlecatalogueid2){
        this.pimtitlecatalogueid2 = pimtitlecatalogueid2 ;
        this.modify("pimtitlecatalogueid2",pimtitlecatalogueid2);
    }


}

