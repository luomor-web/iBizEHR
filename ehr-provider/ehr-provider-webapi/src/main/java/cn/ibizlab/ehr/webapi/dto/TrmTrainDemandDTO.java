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
 * 服务DTO对象[TrmTrainDemandDTO]
 */
@Data
public class TrmTrainDemandDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [HZND]
     *
     */
    @JSONField(name = "hznd")
    @JsonProperty("hznd")
    private String hznd;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

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
     * 属性 [HZJD]
     *
     */
    @JSONField(name = "hzjd")
    @JsonProperty("hzjd")
    private String hzjd;

    /**
     * 属性 [HZRS]
     *
     */
    @JSONField(name = "hzrs")
    @JsonProperty("hzrs")
    private Integer hzrs;

    /**
     * 属性 [TRMTRAINDEMANDID]
     *
     */
    @JSONField(name = "trmtraindemandid")
    @JsonProperty("trmtraindemandid")
    private String trmtraindemandid;

    /**
     * 属性 [TRMTRAINDEMANDNAME]
     *
     */
    @JSONField(name = "trmtraindemandname")
    @JsonProperty("trmtraindemandname")
    private String trmtraindemandname;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [HZND]
     */
    public void setHznd(String  hznd){
        this.hznd = hznd ;
        this.modify("hznd",hznd);
    }

    /**
     * 设置 [HZJD]
     */
    public void setHzjd(String  hzjd){
        this.hzjd = hzjd ;
        this.modify("hzjd",hzjd);
    }

    /**
     * 设置 [HZRS]
     */
    public void setHzrs(Integer  hzrs){
        this.hzrs = hzrs ;
        this.modify("hzrs",hzrs);
    }

    /**
     * 设置 [TRMTRAINDEMANDNAME]
     */
    public void setTrmtraindemandname(String  trmtraindemandname){
        this.trmtraindemandname = trmtraindemandname ;
        this.modify("trmtraindemandname",trmtraindemandname);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

