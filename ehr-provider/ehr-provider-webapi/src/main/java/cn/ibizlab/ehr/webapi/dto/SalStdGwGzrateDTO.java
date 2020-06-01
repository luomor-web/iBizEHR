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
 * 服务DTO对象[SalStdGwGzrateDTO]
 */
@Data
public class SalStdGwGzrateDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [KHJL]
     *
     */
    @JSONField(name = "khjl")
    @JsonProperty("khjl")
    private String khjl;

    /**
     * 属性 [SALSTDGWGZRATENAME]
     *
     */
    @JSONField(name = "salstdgwgzratename")
    @JsonProperty("salstdgwgzratename")
    private String salstdgwgzratename;

    /**
     * 属性 [SALSTDGWGZRATEID]
     *
     */
    @JSONField(name = "salstdgwgzrateid")
    @JsonProperty("salstdgwgzrateid")
    private String salstdgwgzrateid;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [JXGZBL]
     *
     */
    @JSONField(name = "jxgzbl")
    @JsonProperty("jxgzbl")
    private Double jxgzbl;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

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
     * 设置 [KHJL]
     */
    public void setKhjl(String  khjl){
        this.khjl = khjl ;
        this.modify("khjl",khjl);
    }

    /**
     * 设置 [SALSTDGWGZRATENAME]
     */
    public void setSalstdgwgzratename(String  salstdgwgzratename){
        this.salstdgwgzratename = salstdgwgzratename ;
        this.modify("salstdgwgzratename",salstdgwgzratename);
    }

    /**
     * 设置 [JXGZBL]
     */
    public void setJxgzbl(Double  jxgzbl){
        this.jxgzbl = jxgzbl ;
        this.modify("jxgzbl",jxgzbl);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

