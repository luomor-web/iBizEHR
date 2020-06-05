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
 * 服务DTO对象[PimGwTypeDTO]
 */
@Data
public class PimGwTypeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [PIMGWTYPENAME]
     *
     */
    @JSONField(name = "pimgwtypename")
    @JsonProperty("pimgwtypename")
    private String pimgwtypename;

    /**
     * 属性 [GWLX]
     *
     */
    @JSONField(name = "gwlx")
    @JsonProperty("gwlx")
    private String gwlx;

    /**
     * 属性 [ORDERVALUE]
     *
     */
    @JSONField(name = "ordervalue")
    @JsonProperty("ordervalue")
    private Integer ordervalue;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PIMGWTYPEID]
     *
     */
    @JSONField(name = "pimgwtypeid")
    @JsonProperty("pimgwtypeid")
    private String pimgwtypeid;

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
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [PIMGWTYPENAME]
     */
    public void setPimgwtypename(String  pimgwtypename){
        this.pimgwtypename = pimgwtypename ;
        this.modify("pimgwtypename",pimgwtypename);
    }

    /**
     * 设置 [GWLX]
     */
    public void setGwlx(String  gwlx){
        this.gwlx = gwlx ;
        this.modify("gwlx",gwlx);
    }


}

