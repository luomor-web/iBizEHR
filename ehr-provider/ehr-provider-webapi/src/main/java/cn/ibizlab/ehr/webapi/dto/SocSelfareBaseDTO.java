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
 * 服务DTO对象[SocSelfareBaseDTO]
 */
@Data
public class SocSelfareBaseDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SOCSELFAREBASENAME]
     *
     */
    @JSONField(name = "socselfarebasename")
    @JsonProperty("socselfarebasename")
    private String socselfarebasename;

    /**
     * 属性 [CBDQ]
     *
     */
    @JSONField(name = "cbdq")
    @JsonProperty("cbdq")
    private String cbdq;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SOCSELFAREBASEID]
     *
     */
    @JSONField(name = "socselfarebaseid")
    @JsonProperty("socselfarebaseid")
    private String socselfarebaseid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

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
     * 属性 [GRSBBL]
     *
     */
    @JSONField(name = "grsbbl")
    @JsonProperty("grsbbl")
    private String grsbbl;

    /**
     * 属性 [SBLX]
     *
     */
    @JSONField(name = "sblx")
    @JsonProperty("sblx")
    private String sblx;

    /**
     * 属性 [CBDW]
     *
     */
    @JSONField(name = "cbdw")
    @JsonProperty("cbdw")
    private String cbdw;

    /**
     * 属性 [DWSBBLI]
     *
     */
    @JSONField(name = "dwsbbli")
    @JsonProperty("dwsbbli")
    private String dwsbbli;

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
     * 设置 [SOCSELFAREBASENAME]
     */
    public void setSocselfarebasename(String  socselfarebasename){
        this.socselfarebasename = socselfarebasename ;
        this.modify("socselfarebasename",socselfarebasename);
    }

    /**
     * 设置 [CBDQ]
     */
    public void setCbdq(String  cbdq){
        this.cbdq = cbdq ;
        this.modify("cbdq",cbdq);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [GRSBBL]
     */
    public void setGrsbbl(String  grsbbl){
        this.grsbbl = grsbbl ;
        this.modify("grsbbl",grsbbl);
    }

    /**
     * 设置 [SBLX]
     */
    public void setSblx(String  sblx){
        this.sblx = sblx ;
        this.modify("sblx",sblx);
    }

    /**
     * 设置 [CBDW]
     */
    public void setCbdw(String  cbdw){
        this.cbdw = cbdw ;
        this.modify("cbdw",cbdw);
    }

    /**
     * 设置 [DWSBBLI]
     */
    public void setDwsbbli(String  dwsbbli){
        this.dwsbbli = dwsbbli ;
        this.modify("dwsbbli",dwsbbli);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

