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
 * 服务DTO对象[PimVocationalCatalogDTO]
 */
@Data
public class PimVocationalCatalogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DH]
     *
     */
    @JSONField(name = "dh")
    @JsonProperty("dh")
    private String dh;

    /**
     * 属性 [PIMVOCATIONALCATALOGNAME]
     *
     */
    @JSONField(name = "pimvocationalcatalogname")
    @JsonProperty("pimvocationalcatalogname")
    private String pimvocationalcatalogname;

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
     * 属性 [PIMVOCATIONALCATALOGID]
     *
     */
    @JSONField(name = "pimvocationalcatalogid")
    @JsonProperty("pimvocationalcatalogid")
    private String pimvocationalcatalogid;

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
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;


    /**
     * 设置 [DH]
     */
    public void setDh(String  dh){
        this.dh = dh ;
        this.modify("dh",dh);
    }

    /**
     * 设置 [PIMVOCATIONALCATALOGNAME]
     */
    public void setPimvocationalcatalogname(String  pimvocationalcatalogname){
        this.pimvocationalcatalogname = pimvocationalcatalogname ;
        this.modify("pimvocationalcatalogname",pimvocationalcatalogname);
    }

    /**
     * 设置 [PXH]
     */
    public void setPxh(Integer  pxh){
        this.pxh = pxh ;
        this.modify("pxh",pxh);
    }


}

