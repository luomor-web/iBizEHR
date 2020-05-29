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
 * 服务DTO对象[OrmBmgwbzDTO]
 */
@Data
public class OrmBmgwbzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [GWZZSM]
     *
     */
    @JSONField(name = "gwzzsm")
    @JsonProperty("gwzzsm")
    private String gwzzsm;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORMBMGWBZID]
     *
     */
    @JSONField(name = "ormbmgwbzid")
    @JsonProperty("ormbmgwbzid")
    private String ormbmgwbzid;

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
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [NUMCOMPILATION]
     *
     */
    @JSONField(name = "numcompilation")
    @JsonProperty("numcompilation")
    private Integer numcompilation;

    /**
     * 属性 [ORMBMGWBZNAME]
     *
     */
    @JSONField(name = "ormbmgwbzname")
    @JsonProperty("ormbmgwbzname")
    private String ormbmgwbzname;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [ORMGWBZMC]
     *
     */
    @JSONField(name = "ormgwbzmc")
    @JsonProperty("ormgwbzmc")
    private String ormgwbzmc;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 属性 [ORMGWBZID]
     *
     */
    @JSONField(name = "ormgwbzid")
    @JsonProperty("ormgwbzid")
    private String ormgwbzid;


    /**
     * 设置 [GWZZSM]
     */
    public void setGwzzsm(String  gwzzsm){
        this.gwzzsm = gwzzsm ;
        this.modify("gwzzsm",gwzzsm);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [NUMCOMPILATION]
     */
    public void setNumcompilation(Integer  numcompilation){
        this.numcompilation = numcompilation ;
        this.modify("numcompilation",numcompilation);
    }

    /**
     * 设置 [ORMBMGWBZNAME]
     */
    public void setOrmbmgwbzname(String  ormbmgwbzname){
        this.ormbmgwbzname = ormbmgwbzname ;
        this.modify("ormbmgwbzname",ormbmgwbzname);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [ORMGWBZID]
     */
    public void setOrmgwbzid(String  ormgwbzid){
        this.ormgwbzid = ormgwbzid ;
        this.modify("ormgwbzid",ormgwbzid);
    }


}

