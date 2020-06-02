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
 * 服务DTO对象[SalStdglDTO]
 */
@Data
public class SalStdglDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private Double bz;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [JSGL]
     *
     */
    @JSONField(name = "jsgl")
    @JsonProperty("jsgl")
    private Integer jsgl;

    /**
     * 属性 [SALSTDGLNAME]
     *
     */
    @JSONField(name = "salstdglname")
    @JsonProperty("salstdglname")
    private String salstdglname;

    /**
     * 属性 [QSGL]
     *
     */
    @JSONField(name = "qsgl")
    @JsonProperty("qsgl")
    private Integer qsgl;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [SALSTDGLID]
     *
     */
    @JSONField(name = "salstdglid")
    @JsonProperty("salstdglid")
    private String salstdglid;

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
     * 设置 [BZ]
     */
    public void setBz(Double  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [JSGL]
     */
    public void setJsgl(Integer  jsgl){
        this.jsgl = jsgl ;
        this.modify("jsgl",jsgl);
    }

    /**
     * 设置 [SALSTDGLNAME]
     */
    public void setSalstdglname(String  salstdglname){
        this.salstdglname = salstdglname ;
        this.modify("salstdglname",salstdglname);
    }

    /**
     * 设置 [QSGL]
     */
    public void setQsgl(Integer  qsgl){
        this.qsgl = qsgl ;
        this.modify("qsgl",qsgl);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

