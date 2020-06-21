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
 * 服务DTO对象[TrmTrainActmentDTO]
 */
@Data
public class TrmTrainActmentDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DCWJTM]
     *
     */
    @JSONField(name = "dcwjtm")
    @JsonProperty("dcwjtm")
    private String dcwjtm;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [TRMTRAINACTMENTID]
     *
     */
    @JSONField(name = "trmtrainactmentid")
    @JsonProperty("trmtrainactmentid")
    private String trmtrainactmentid;

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
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [PXJG]
     *
     */
    @JSONField(name = "pxjg")
    @JsonProperty("pxjg")
    private String pxjg;

    /**
     * 属性 [TRMTRAINACTMENTNAME]
     *
     */
    @JSONField(name = "trmtrainactmentname")
    @JsonProperty("trmtrainactmentname")
    private String trmtrainactmentname;

    /**
     * 属性 [TRMTRAINACTAPPLYNAME]
     *
     */
    @JSONField(name = "trmtrainactapplyname")
    @JsonProperty("trmtrainactapplyname")
    private String trmtrainactapplyname;

    /**
     * 属性 [TRMTRAINACTAPPLYID]
     *
     */
    @JSONField(name = "trmtrainactapplyid")
    @JsonProperty("trmtrainactapplyid")
    private String trmtrainactapplyid;

    /**
     * 属性 [EVALTARGET]
     *
     */
    @JSONField(name = "evaltarget")
    @JsonProperty("evaltarget")
    private String evaltarget;

    /**
     * 属性 [EVALCONTENTS]
     *
     */
    @JSONField(name = "evalcontents")
    @JsonProperty("evalcontents")
    private String evalcontents;

    /**
     * 属性 [EVALTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "evaltime" , format="yyyy-MM-dd")
    @JsonProperty("evaltime")
    private Timestamp evaltime;


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
     * 设置 [PXJG]
     */
    public void setPxjg(String  pxjg){
        this.pxjg = pxjg ;
        this.modify("pxjg",pxjg);
    }

    /**
     * 设置 [TRMTRAINACTMENTNAME]
     */
    public void setTrmtrainactmentname(String  trmtrainactmentname){
        this.trmtrainactmentname = trmtrainactmentname ;
        this.modify("trmtrainactmentname",trmtrainactmentname);
    }

    /**
     * 设置 [TRMTRAINACTAPPLYID]
     */
    public void setTrmtrainactapplyid(String  trmtrainactapplyid){
        this.trmtrainactapplyid = trmtrainactapplyid ;
        this.modify("trmtrainactapplyid",trmtrainactapplyid);
    }

    /**
     * 设置 [EVALTARGET]
     */
    public void setEvaltarget(String  evaltarget){
        this.evaltarget = evaltarget ;
        this.modify("evaltarget",evaltarget);
    }

    /**
     * 设置 [EVALCONTENTS]
     */
    public void setEvalcontents(String  evalcontents){
        this.evalcontents = evalcontents ;
        this.modify("evalcontents",evalcontents);
    }

    /**
     * 设置 [EVALTIME]
     */
    public void setEvaltime(Timestamp  evaltime){
        this.evaltime = evaltime ;
        this.modify("evaltime",evaltime);
    }


}

