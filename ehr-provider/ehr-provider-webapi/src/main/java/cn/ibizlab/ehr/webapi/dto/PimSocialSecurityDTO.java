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
 * 服务DTO对象[PimSocialSecurityDTO]
 */
@Data
public class PimSocialSecurityDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PIMSOCIALSECURITYNAME]
     *
     */
    @JSONField(name = "pimsocialsecurityname")
    @JsonProperty("pimsocialsecurityname")
    private String pimsocialsecurityname;

    /**
     * 属性 [JNDW]
     *
     */
    @JSONField(name = "jndw")
    @JsonProperty("jndw")
    private String jndw;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PIMSOCIALSECURITYID]
     *
     */
    @JSONField(name = "pimsocialsecurityid")
    @JsonProperty("pimsocialsecurityid")
    private String pimsocialsecurityid;

    /**
     * 属性 [SBBL]
     *
     */
    @JSONField(name = "sbbl")
    @JsonProperty("sbbl")
    private String sbbl;

    /**
     * 属性 [LX]
     *
     */
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;

    /**
     * 属性 [BXJS]
     *
     */
    @JSONField(name = "bxjs")
    @JsonProperty("bxjs")
    private String bxjs;

    /**
     * 属性 [CBDQ]
     *
     */
    @JSONField(name = "cbdq")
    @JsonProperty("cbdq")
    private String cbdq;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [JNZT]
     *
     */
    @JSONField(name = "jnzt")
    @JsonProperty("jnzt")
    private String jnzt;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [PIMSOCIALSECURITYNAME]
     */
    public void setPimsocialsecurityname(String  pimsocialsecurityname){
        this.pimsocialsecurityname = pimsocialsecurityname ;
        this.modify("pimsocialsecurityname",pimsocialsecurityname);
    }

    /**
     * 设置 [JNDW]
     */
    public void setJndw(String  jndw){
        this.jndw = jndw ;
        this.modify("jndw",jndw);
    }

    /**
     * 设置 [SBBL]
     */
    public void setSbbl(String  sbbl){
        this.sbbl = sbbl ;
        this.modify("sbbl",sbbl);
    }

    /**
     * 设置 [LX]
     */
    public void setLx(String  lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [BXJS]
     */
    public void setBxjs(String  bxjs){
        this.bxjs = bxjs ;
        this.modify("bxjs",bxjs);
    }

    /**
     * 设置 [CBDQ]
     */
    public void setCbdq(String  cbdq){
        this.cbdq = cbdq ;
        this.modify("cbdq",cbdq);
    }

    /**
     * 设置 [JNZT]
     */
    public void setJnzt(String  jnzt){
        this.jnzt = jnzt ;
        this.modify("jnzt",jnzt);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

