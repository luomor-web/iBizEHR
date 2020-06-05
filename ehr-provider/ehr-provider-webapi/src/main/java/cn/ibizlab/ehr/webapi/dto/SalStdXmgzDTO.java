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
 * 服务DTO对象[SalStdXmgzDTO]
 */
@Data
public class SalStdXmgzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DJ]
     *
     */
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private Double bz;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SALSTDXMGZID]
     *
     */
    @JSONField(name = "salstdxmgzid")
    @JsonProperty("salstdxmgzid")
    private String salstdxmgzid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [XMJB]
     *
     */
    @JSONField(name = "xmjb")
    @JsonProperty("xmjb")
    private String xmjb;

    /**
     * 属性 [SALSTDXMGZNAME]
     *
     */
    @JSONField(name = "salstdxmgzname")
    @JsonProperty("salstdxmgzname")
    private String salstdxmgzname;

    /**
     * 属性 [JXGZBL]
     *
     */
    @JSONField(name = "jxgzbl")
    @JsonProperty("jxgzbl")
    private Double jxgzbl;

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
     * 属性 [JBGZBL]
     *
     */
    @JSONField(name = "jbgzbl")
    @JsonProperty("jbgzbl")
    private Double jbgzbl;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

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
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;


    /**
     * 设置 [DJ]
     */
    public void setDj(String  dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(Double  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [XMJB]
     */
    public void setXmjb(String  xmjb){
        this.xmjb = xmjb ;
        this.modify("xmjb",xmjb);
    }

    /**
     * 设置 [SALSTDXMGZNAME]
     */
    public void setSalstdxmgzname(String  salstdxmgzname){
        this.salstdxmgzname = salstdxmgzname ;
        this.modify("salstdxmgzname",salstdxmgzname);
    }

    /**
     * 设置 [JXGZBL]
     */
    public void setJxgzbl(Double  jxgzbl){
        this.jxgzbl = jxgzbl ;
        this.modify("jxgzbl",jxgzbl);
    }

    /**
     * 设置 [JBGZBL]
     */
    public void setJbgzbl(Double  jbgzbl){
        this.jbgzbl = jbgzbl ;
        this.modify("jbgzbl",jbgzbl);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }


}

