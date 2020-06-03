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
 * 服务DTO对象[ParJxzgpcmxDTO]
 */
@Data
public class ParJxzgpcmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [FZFW]
     *
     */
    @JSONField(name = "fzfw")
    @JsonProperty("fzfw")
    private String fzfw;

    /**
     * 属性 [ZGDF]
     *
     */
    @JSONField(name = "zgdf")
    @JsonProperty("zgdf")
    private Double zgdf;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ZB]
     *
     */
    @JSONField(name = "zb")
    @JsonProperty("zb")
    private String zb;

    /**
     * 属性 [PARJXZGPCMXNAME]
     *
     */
    @JSONField(name = "parjxzgpcmxname")
    @JsonProperty("parjxzgpcmxname")
    private String parjxzgpcmxname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PF]
     *
     */
    @JSONField(name = "pf")
    @JsonProperty("pf")
    private Double pf;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PARJXZGPCMXID]
     *
     */
    @JSONField(name = "parjxzgpcmxid")
    @JsonProperty("parjxzgpcmxid")
    private String parjxzgpcmxid;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [ZDDF]
     *
     */
    @JSONField(name = "zddf")
    @JsonProperty("zddf")
    private Double zddf;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [PARJXZGPCNAME]
     *
     */
    @JSONField(name = "parjxzgpcname")
    @JsonProperty("parjxzgpcname")
    private String parjxzgpcname;

    /**
     * 属性 [PARJXZGPCID]
     *
     */
    @JSONField(name = "parjxzgpcid")
    @JsonProperty("parjxzgpcid")
    private String parjxzgpcid;


    /**
     * 设置 [FZFW]
     */
    public void setFzfw(String  fzfw){
        this.fzfw = fzfw ;
        this.modify("fzfw",fzfw);
    }

    /**
     * 设置 [ZGDF]
     */
    public void setZgdf(Double  zgdf){
        this.zgdf = zgdf ;
        this.modify("zgdf",zgdf);
    }

    /**
     * 设置 [ZB]
     */
    public void setZb(String  zb){
        this.zb = zb ;
        this.modify("zb",zb);
    }

    /**
     * 设置 [PARJXZGPCMXNAME]
     */
    public void setParjxzgpcmxname(String  parjxzgpcmxname){
        this.parjxzgpcmxname = parjxzgpcmxname ;
        this.modify("parjxzgpcmxname",parjxzgpcmxname);
    }

    /**
     * 设置 [PF]
     */
    public void setPf(Double  pf){
        this.pf = pf ;
        this.modify("pf",pf);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [ZDDF]
     */
    public void setZddf(Double  zddf){
        this.zddf = zddf ;
        this.modify("zddf",zddf);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [PARJXZGPCID]
     */
    public void setParjxzgpcid(String  parjxzgpcid){
        this.parjxzgpcid = parjxzgpcid ;
        this.modify("parjxzgpcid",parjxzgpcid);
    }


}

