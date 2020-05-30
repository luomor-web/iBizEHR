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
 * 服务DTO对象[PimCityDTO]
 */
@Data
public class PimCityDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 属性 [PIMCITYID]
     *
     */
    @JSONField(name = "pimcityid")
    @JsonProperty("pimcityid")
    private String pimcityid;

    /**
     * 属性 [PROTYPE]
     *
     */
    @JSONField(name = "protype")
    @JsonProperty("protype")
    private String protype;

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
     * 属性 [PIMCITYNAME]
     *
     */
    @JSONField(name = "pimcityname")
    @JsonProperty("pimcityname")
    private String pimcityname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [PROTYPE]
     */
    public void setProtype(String  protype){
        this.protype = protype ;
        this.modify("protype",protype);
    }

    /**
     * 设置 [PIMCITYNAME]
     */
    public void setPimcityname(String  pimcityname){
        this.pimcityname = pimcityname ;
        this.modify("pimcityname",pimcityname);
    }


}

