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
 * 服务DTO对象[TrmTrainResmentDTO]
 */
@Data
public class TrmTrainResmentDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DCWJTM]
     *
     */
    @JSONField(name = "dcwjtm")
    @JsonProperty("dcwjtm")
    private String dcwjtm;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [PGJG]
     *
     */
    @JSONField(name = "pgjg")
    @JsonProperty("pgjg")
    private String pgjg;

    /**
     * 属性 [TRMTRAINRESMENTNAME]
     *
     */
    @JSONField(name = "trmtrainresmentname")
    @JsonProperty("trmtrainresmentname")
    private String trmtrainresmentname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [TRMTRAINRESMENTID]
     *
     */
    @JSONField(name = "trmtrainresmentid")
    @JsonProperty("trmtrainresmentid")
    private String trmtrainresmentid;


    /**
     * 设置 [DCWJTM]
     */
    public void setDcwjtm(String  dcwjtm){
        this.dcwjtm = dcwjtm ;
        this.modify("dcwjtm",dcwjtm);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [PGJG]
     */
    public void setPgjg(String  pgjg){
        this.pgjg = pgjg ;
        this.modify("pgjg",pgjg);
    }

    /**
     * 设置 [TRMTRAINRESMENTNAME]
     */
    public void setTrmtrainresmentname(String  trmtrainresmentname){
        this.trmtrainresmentname = trmtrainresmentname ;
        this.modify("trmtrainresmentname",trmtrainresmentname);
    }


}

