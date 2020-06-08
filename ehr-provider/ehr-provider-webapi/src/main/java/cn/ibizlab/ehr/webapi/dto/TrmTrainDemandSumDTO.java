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
 * 服务DTO对象[TrmTrainDemandSumDTO]
 */
@Data
public class TrmTrainDemandSumDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [TRMTRAINDEMANDSUMID]
     *
     */
    @JSONField(name = "trmtraindemandsumid")
    @JsonProperty("trmtraindemandsumid")
    private String trmtraindemandsumid;

    /**
     * 属性 [XQRS]
     *
     */
    @JSONField(name = "xqrs")
    @JsonProperty("xqrs")
    private Integer xqrs;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [HZRQ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "hzrq" , format="yyyy-MM-dd")
    @JsonProperty("hzrq")
    private Timestamp hzrq;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [TRMTRAINDEMANDSUMNAME]
     *
     */
    @JSONField(name = "trmtraindemandsumname")
    @JsonProperty("trmtraindemandsumname")
    private String trmtraindemandsumname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [KCBM]
     *
     */
    @JSONField(name = "kcbm")
    @JsonProperty("kcbm")
    private String kcbm;

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
     * 属性 [TRMTRAINCOURSENAME]
     *
     */
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;

    /**
     * 属性 [TRMTRAINCOURSEID]
     *
     */
    @JSONField(name = "trmtraincourseid")
    @JsonProperty("trmtraincourseid")
    private String trmtraincourseid;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [TRMTRAINDEMANDID]
     *
     */
    @JSONField(name = "trmtraindemandid")
    @JsonProperty("trmtraindemandid")
    private String trmtraindemandid;


    /**
     * 设置 [XQRS]
     */
    public void setXqrs(Integer  xqrs){
        this.xqrs = xqrs ;
        this.modify("xqrs",xqrs);
    }

    /**
     * 设置 [HZRQ]
     */
    public void setHzrq(Timestamp  hzrq){
        this.hzrq = hzrq ;
        this.modify("hzrq",hzrq);
    }

    /**
     * 设置 [TRMTRAINDEMANDSUMNAME]
     */
    public void setTrmtraindemandsumname(String  trmtraindemandsumname){
        this.trmtraindemandsumname = trmtraindemandsumname ;
        this.modify("trmtraindemandsumname",trmtraindemandsumname);
    }

    /**
     * 设置 [TRMTRAINCOURSEID]
     */
    public void setTrmtraincourseid(String  trmtraincourseid){
        this.trmtraincourseid = trmtraincourseid ;
        this.modify("trmtraincourseid",trmtraincourseid);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [TRMTRAINDEMANDID]
     */
    public void setTrmtraindemandid(String  trmtraindemandid){
        this.trmtraindemandid = trmtraindemandid ;
        this.modify("trmtraindemandid",trmtraindemandid);
    }


}

