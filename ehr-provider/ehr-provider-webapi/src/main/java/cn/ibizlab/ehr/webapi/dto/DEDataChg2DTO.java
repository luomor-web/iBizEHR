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
 * 服务DTO对象[DEDataChg2DTO]
 */
@Data
public class DEDataChg2DTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DEDATACHG2NAME]
     *
     */
    @JSONField(name = "dedatachg2name")
    @JsonProperty("dedatachg2name")
    private String dedatachg2name;

    /**
     * 属性 [EVENTTYPE]
     *
     */
    @JSONField(name = "eventtype")
    @JsonProperty("eventtype")
    private Integer eventtype;

    /**
     * 属性 [DATAKEY]
     *
     */
    @JSONField(name = "datakey")
    @JsonProperty("datakey")
    private String datakey;

    /**
     * 属性 [DATA]
     *
     */
    @JSONField(name = "data")
    @JsonProperty("data")
    private String data;

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
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DEDATACHG2ID]
     *
     */
    @JSONField(name = "dedatachg2id")
    @JsonProperty("dedatachg2id")
    private String dedatachg2id;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ERROR]
     *
     */
    @JSONField(name = "error")
    @JsonProperty("error")
    private String error;

    /**
     * 属性 [DISPERROR]
     *
     */
    @JSONField(name = "disperror")
    @JsonProperty("disperror")
    private String disperror;

    /**
     * 属性 [LOGICDATA]
     *
     */
    @JSONField(name = "logicdata")
    @JsonProperty("logicdata")
    private String logicdata;

    /**
     * 属性 [DENAME]
     *
     */
    @JSONField(name = "dename")
    @JsonProperty("dename")
    private String dename;

    /**
     * 属性 [DEID]
     *
     */
    @JSONField(name = "deid")
    @JsonProperty("deid")
    private String deid;


    /**
     * 设置 [DEDATACHG2NAME]
     */
    public void setDedatachg2name(String  dedatachg2name){
        this.dedatachg2name = dedatachg2name ;
        this.modify("dedatachg2name",dedatachg2name);
    }

    /**
     * 设置 [EVENTTYPE]
     */
    public void setEventtype(Integer  eventtype){
        this.eventtype = eventtype ;
        this.modify("eventtype",eventtype);
    }

    /**
     * 设置 [DATAKEY]
     */
    public void setDatakey(String  datakey){
        this.datakey = datakey ;
        this.modify("datakey",datakey);
    }

    /**
     * 设置 [DATA]
     */
    public void setData(String  data){
        this.data = data ;
        this.modify("data",data);
    }

    /**
     * 设置 [ERROR]
     */
    public void setError(String  error){
        this.error = error ;
        this.modify("error",error);
    }

    /**
     * 设置 [DISPERROR]
     */
    public void setDisperror(String  disperror){
        this.disperror = disperror ;
        this.modify("disperror",disperror);
    }

    /**
     * 设置 [LOGICDATA]
     */
    public void setLogicdata(String  logicdata){
        this.logicdata = logicdata ;
        this.modify("logicdata",logicdata);
    }

    /**
     * 设置 [DENAME]
     */
    public void setDename(String  dename){
        this.dename = dename ;
        this.modify("dename",dename);
    }

    /**
     * 设置 [DEID]
     */
    public void setDeid(String  deid){
        this.deid = deid ;
        this.modify("deid",deid);
    }


}

