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
 * 服务DTO对象[VacSituationDetailDTO]
 */
@Data
public class VacSituationDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [XJLX]
     *
     */
    @JSONField(name = "xjlx")
    @JsonProperty("xjlx")
    private String xjlx;

    /**
     * 属性 [VACSITUATIONDETAILNAME]
     *
     */
    @JSONField(name = "vacsituationdetailname")
    @JsonProperty("vacsituationdetailname")
    private String vacsituationdetailname;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [XJTS]
     *
     */
    @JSONField(name = "xjts")
    @JsonProperty("xjts")
    private Integer xjts;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [VACSITUATIONDETAILID]
     *
     */
    @JSONField(name = "vacsituationdetailid")
    @JsonProperty("vacsituationdetailid")
    private String vacsituationdetailid;


    /**
     * 设置 [XJLX]
     */
    public void setXjlx(String  xjlx){
        this.xjlx = xjlx ;
        this.modify("xjlx",xjlx);
    }

    /**
     * 设置 [VACSITUATIONDETAILNAME]
     */
    public void setVacsituationdetailname(String  vacsituationdetailname){
        this.vacsituationdetailname = vacsituationdetailname ;
        this.modify("vacsituationdetailname",vacsituationdetailname);
    }

    /**
     * 设置 [XJTS]
     */
    public void setXjts(Integer  xjts){
        this.xjts = xjts ;
        this.modify("xjts",xjts);
    }


}

