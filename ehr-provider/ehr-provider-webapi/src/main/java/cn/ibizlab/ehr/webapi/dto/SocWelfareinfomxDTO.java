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
 * 服务DTO对象[SocWelfareinfomxDTO]
 */
@Data
public class SocWelfareinfomxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SOCWELFAREINFOMXID]
     *
     */
    @JSONField(name = "socwelfareinfomxid")
    @JsonProperty("socwelfareinfomxid")
    private String socwelfareinfomxid;

    /**
     * 属性 [DWJS]
     *
     */
    @JSONField(name = "dwjs")
    @JsonProperty("dwjs")
    private String dwjs;

    /**
     * 属性 [SOCWELFAREINFOMXNAME]
     *
     */
    @JSONField(name = "socwelfareinfomxname")
    @JsonProperty("socwelfareinfomxname")
    private String socwelfareinfomxname;

    /**
     * 属性 [GRJS]
     *
     */
    @JSONField(name = "grjs")
    @JsonProperty("grjs")
    private String grjs;

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
    private String bz;

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
     * 属性 [SM]
     *
     */
    @JSONField(name = "sm")
    @JsonProperty("sm")
    private String sm;

    /**
     * 属性 [SOCWELFAREINFONAME]
     *
     */
    @JSONField(name = "socwelfareinfoname")
    @JsonProperty("socwelfareinfoname")
    private String socwelfareinfoname;

    /**
     * 属性 [DWBL]
     *
     */
    @JSONField(name = "dwbl")
    @JsonProperty("dwbl")
    private String dwbl;

    /**
     * 属性 [DE]
     *
     */
    @JSONField(name = "de")
    @JsonProperty("de")
    private String de;

    /**
     * 属性 [GRBL]
     *
     */
    @JSONField(name = "grbl")
    @JsonProperty("grbl")
    private String grbl;

    /**
     * 属性 [SBFLLX]
     *
     */
    @JSONField(name = "sbfllx")
    @JsonProperty("sbfllx")
    private String sbfllx;

    /**
     * 属性 [SOCSELFAREBASEMXID]
     *
     */
    @JSONField(name = "socselfarebasemxid")
    @JsonProperty("socselfarebasemxid")
    private String socselfarebasemxid;

    /**
     * 属性 [SOCWELFAREINFOID]
     *
     */
    @JSONField(name = "socwelfareinfoid")
    @JsonProperty("socwelfareinfoid")
    private String socwelfareinfoid;


    /**
     * 设置 [DWJS]
     */
    public void setDwjs(String  dwjs){
        this.dwjs = dwjs ;
        this.modify("dwjs",dwjs);
    }

    /**
     * 设置 [SOCWELFAREINFOMXNAME]
     */
    public void setSocwelfareinfomxname(String  socwelfareinfomxname){
        this.socwelfareinfomxname = socwelfareinfomxname ;
        this.modify("socwelfareinfomxname",socwelfareinfomxname);
    }

    /**
     * 设置 [GRJS]
     */
    public void setGrjs(String  grjs){
        this.grjs = grjs ;
        this.modify("grjs",grjs);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [SOCSELFAREBASEMXID]
     */
    public void setSocselfarebasemxid(String  socselfarebasemxid){
        this.socselfarebasemxid = socselfarebasemxid ;
        this.modify("socselfarebasemxid",socselfarebasemxid);
    }

    /**
     * 设置 [SOCWELFAREINFOID]
     */
    public void setSocwelfareinfoid(String  socwelfareinfoid){
        this.socwelfareinfoid = socwelfareinfoid ;
        this.modify("socwelfareinfoid",socwelfareinfoid);
    }


}

