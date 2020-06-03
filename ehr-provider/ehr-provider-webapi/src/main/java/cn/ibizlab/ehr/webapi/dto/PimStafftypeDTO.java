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
 * 服务DTO对象[PimStafftypeDTO]
 */
@Data
public class PimStafftypeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PIMSTAFFTYPEID]
     *
     */
    @JSONField(name = "pimstafftypeid")
    @JsonProperty("pimstafftypeid")
    private String pimstafftypeid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [SHGZ]
     *
     */
    @JSONField(name = "shgz")
    @JsonProperty("shgz")
    private String shgz;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SBM]
     *
     */
    @JSONField(name = "sbm")
    @JsonProperty("sbm")
    private String sbm;

    /**
     * 属性 [PIMSTAFFTYPENAME]
     *
     */
    @JSONField(name = "pimstafftypename")
    @JsonProperty("pimstafftypename")
    private String pimstafftypename;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;


    /**
     * 设置 [SHGZ]
     */
    public void setShgz(String  shgz){
        this.shgz = shgz ;
        this.modify("shgz",shgz);
    }

    /**
     * 设置 [SBM]
     */
    public void setSbm(String  sbm){
        this.sbm = sbm ;
        this.modify("sbm",sbm);
    }

    /**
     * 设置 [PIMSTAFFTYPENAME]
     */
    public void setPimstafftypename(String  pimstafftypename){
        this.pimstafftypename = pimstafftypename ;
        this.modify("pimstafftypename",pimstafftypename);
    }


}

