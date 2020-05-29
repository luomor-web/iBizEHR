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
 * 服务DTO对象[TrmLgbDetailDTO]
 */
@Data
public class TrmLgbDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [TRMLGBDETAILNAME]
     *
     */
    @JSONField(name = "trmlgbdetailname")
    @JsonProperty("trmlgbdetailname")
    private String trmlgbdetailname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [TRMLGBDETAILID]
     *
     */
    @JSONField(name = "trmlgbdetailid")
    @JsonProperty("trmlgbdetailid")
    private String trmlgbdetailid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [TRMLGBCOSTNAME]
     *
     */
    @JSONField(name = "trmlgbcostname")
    @JsonProperty("trmlgbcostname")
    private String trmlgbcostname;

    /**
     * 属性 [ZJHM]
     *
     */
    @JSONField(name = "zjhm")
    @JsonProperty("zjhm")
    private String zjhm;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [TRMLGBCOSTID]
     *
     */
    @JSONField(name = "trmlgbcostid")
    @JsonProperty("trmlgbcostid")
    private String trmlgbcostid;


    /**
     * 设置 [TRMLGBDETAILNAME]
     */
    public void setTrmlgbdetailname(String  trmlgbdetailname){
        this.trmlgbdetailname = trmlgbdetailname ;
        this.modify("trmlgbdetailname",trmlgbdetailname);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [TRMLGBCOSTID]
     */
    public void setTrmlgbcostid(String  trmlgbcostid){
        this.trmlgbcostid = trmlgbcostid ;
        this.modify("trmlgbcostid",trmlgbcostid);
    }


}

