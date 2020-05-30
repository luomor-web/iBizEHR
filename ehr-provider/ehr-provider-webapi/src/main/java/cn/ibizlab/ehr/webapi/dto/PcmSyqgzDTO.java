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
 * 服务DTO对象[PcmSyqgzDTO]
 */
@Data
public class PcmSyqgzDTO extends DTOBase implements Serializable {

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
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private String xh;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [MINPERIOD]
     *
     */
    @JSONField(name = "minperiod")
    @JsonProperty("minperiod")
    private Double minperiod;

    /**
     * 属性 [LDHTQXJS]
     *
     */
    @JSONField(name = "ldhtqxjs")
    @JsonProperty("ldhtqxjs")
    private Double ldhtqxjs;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [LDHTQX]
     *
     */
    @JSONField(name = "ldhtqx")
    @JsonProperty("ldhtqx")
    private String ldhtqx;

    /**
     * 属性 [PCMSYQGZID]
     *
     */
    @JSONField(name = "pcmsyqgzid")
    @JsonProperty("pcmsyqgzid")
    private String pcmsyqgzid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DURATION]
     *
     */
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private String duration;

    /**
     * 属性 [SYQJS]
     *
     */
    @JSONField(name = "syqjs")
    @JsonProperty("syqjs")
    private Double syqjs;

    /**
     * 属性 [PCMSYQGZNAME]
     *
     */
    @JSONField(name = "pcmsyqgzname")
    @JsonProperty("pcmsyqgzname")
    private String pcmsyqgzname;

    /**
     * 属性 [MAXPERIOD]
     *
     */
    @JSONField(name = "maxperiod")
    @JsonProperty("maxperiod")
    private Double maxperiod;

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
     * 设置 [XH]
     */
    public void setXh(String  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [MINPERIOD]
     */
    public void setMinperiod(Double  minperiod){
        this.minperiod = minperiod ;
        this.modify("minperiod",minperiod);
    }

    /**
     * 设置 [LDHTQXJS]
     */
    public void setLdhtqxjs(Double  ldhtqxjs){
        this.ldhtqxjs = ldhtqxjs ;
        this.modify("ldhtqxjs",ldhtqxjs);
    }

    /**
     * 设置 [LDHTQX]
     */
    public void setLdhtqx(String  ldhtqx){
        this.ldhtqx = ldhtqx ;
        this.modify("ldhtqx",ldhtqx);
    }

    /**
     * 设置 [DURATION]
     */
    public void setDuration(String  duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [SYQJS]
     */
    public void setSyqjs(Double  syqjs){
        this.syqjs = syqjs ;
        this.modify("syqjs",syqjs);
    }

    /**
     * 设置 [PCMSYQGZNAME]
     */
    public void setPcmsyqgzname(String  pcmsyqgzname){
        this.pcmsyqgzname = pcmsyqgzname ;
        this.modify("pcmsyqgzname",pcmsyqgzname);
    }

    /**
     * 设置 [MAXPERIOD]
     */
    public void setMaxperiod(Double  maxperiod){
        this.maxperiod = maxperiod ;
        this.modify("maxperiod",maxperiod);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

