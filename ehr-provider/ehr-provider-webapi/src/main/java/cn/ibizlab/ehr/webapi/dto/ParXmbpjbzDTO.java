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
 * 服务DTO对象[ParXmbpjbzDTO]
 */
@Data
public class ParXmbpjbzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DJBL]
     *
     */
    @JSONField(name = "djbl")
    @JsonProperty("djbl")
    private Integer djbl;

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
     * 属性 [PARXMBPJBZID]
     *
     */
    @JSONField(name = "parxmbpjbzid")
    @JsonProperty("parxmbpjbzid")
    private String parxmbpjbzid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [GWLX]
     *
     */
    @JSONField(name = "gwlx")
    @JsonProperty("gwlx")
    private String gwlx;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PARXMBPJBZNAME]
     *
     */
    @JSONField(name = "parxmbpjbzname")
    @JsonProperty("parxmbpjbzname")
    private String parxmbpjbzname;

    /**
     * 属性 [DJ]
     *
     */
    @JSONField(name = "dj")
    @JsonProperty("dj")
    private String dj;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [XMBPJBZMC]
     *
     */
    @JSONField(name = "xmbpjbzmc")
    @JsonProperty("xmbpjbzmc")
    private String xmbpjbzmc;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [XMBPJBZID]
     *
     */
    @JSONField(name = "xmbpjbzid")
    @JsonProperty("xmbpjbzid")
    private String xmbpjbzid;


    /**
     * 设置 [DJBL]
     */
    public void setDjbl(Integer  djbl){
        this.djbl = djbl ;
        this.modify("djbl",djbl);
    }

    /**
     * 设置 [GWLX]
     */
    public void setGwlx(String  gwlx){
        this.gwlx = gwlx ;
        this.modify("gwlx",gwlx);
    }

    /**
     * 设置 [PARXMBPJBZNAME]
     */
    public void setParxmbpjbzname(String  parxmbpjbzname){
        this.parxmbpjbzname = parxmbpjbzname ;
        this.modify("parxmbpjbzname",parxmbpjbzname);
    }

    /**
     * 设置 [DJ]
     */
    public void setDj(String  dj){
        this.dj = dj ;
        this.modify("dj",dj);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [XMBPJBZID]
     */
    public void setXmbpjbzid(String  xmbpjbzid){
        this.xmbpjbzid = xmbpjbzid ;
        this.modify("xmbpjbzid",xmbpjbzid);
    }


}

