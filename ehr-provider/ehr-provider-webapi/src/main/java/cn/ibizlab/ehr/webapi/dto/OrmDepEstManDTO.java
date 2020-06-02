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
 * 服务DTO对象[OrmDepEstManDTO]
 */
@Data
public class OrmDepEstManDTO extends DTOBase implements Serializable {

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
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [NUMCOMPILATION]
     *
     */
    @JSONField(name = "numcompilation")
    @JsonProperty("numcompilation")
    private Integer numcompilation;

    /**
     * 属性 [ORMDEPESTMANNAME]
     *
     */
    @JSONField(name = "ormdepestmanname")
    @JsonProperty("ormdepestmanname")
    private String ormdepestmanname;

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
     * 属性 [ORMDEPESTMANID]
     *
     */
    @JSONField(name = "ormdepestmanid")
    @JsonProperty("ormdepestmanid")
    private String ormdepestmanid;

    /**
     * 属性 [ZWZZSM]
     *
     */
    @JSONField(name = "zwzzsm")
    @JsonProperty("zwzzsm")
    private String zwzzsm;

    /**
     * 属性 [ORMDUTYNAME]
     *
     */
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;

    /**
     * 属性 [ORMZWBZMC]
     *
     */
    @JSONField(name = "ormzwbzmc")
    @JsonProperty("ormzwbzmc")
    private String ormzwbzmc;

    /**
     * 属性 [ORMZWBZID]
     *
     */
    @JSONField(name = "ormzwbzid")
    @JsonProperty("ormzwbzid")
    private String ormzwbzid;

    /**
     * 属性 [ORMDUTYID]
     *
     */
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;


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
     * 设置 [ORMDEPESTMANNAME]
     */
    public void setOrmdepestmanname(String  ormdepestmanname){
        this.ormdepestmanname = ormdepestmanname ;
        this.modify("ormdepestmanname",ormdepestmanname);
    }

    /**
     * 设置 [ZWZZSM]
     */
    public void setZwzzsm(String  zwzzsm){
        this.zwzzsm = zwzzsm ;
        this.modify("zwzzsm",zwzzsm);
    }

    /**
     * 设置 [ORMZWBZID]
     */
    public void setOrmzwbzid(String  ormzwbzid){
        this.ormzwbzid = ormzwbzid ;
        this.modify("ormzwbzid",ormzwbzid);
    }

    /**
     * 设置 [ORMDUTYID]
     */
    public void setOrmdutyid(String  ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }


}

