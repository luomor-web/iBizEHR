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
 * 服务DTO对象[PimVacationDTO]
 */
@Data
public class PimVacationDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PIMVACATIONNAME]
     *
     */
    @JSONField(name = "pimvacationname")
    @JsonProperty("pimvacationname")
    private String pimvacationname;

    /**
     * 属性 [XJTS]
     *
     */
    @JSONField(name = "xjts")
    @JsonProperty("xjts")
    private Double xjts;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [XJJSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xjjssj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("xjjssj")
    private Timestamp xjjssj;

    /**
     * 属性 [XJKSSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "xjkssj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("xjkssj")
    private Timestamp xjkssj;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [XJLX]
     *
     */
    @JSONField(name = "xjlx")
    @JsonProperty("xjlx")
    private String xjlx;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PIMVACATIONID]
     *
     */
    @JSONField(name = "pimvacationid")
    @JsonProperty("pimvacationid")
    private String pimvacationid;

    /**
     * 属性 [FJ]
     *
     */
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;

    /**
     * 属性 [BZ]
     *
     */
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [PIMVACATIONNAME]
     */
    public void setPimvacationname(String  pimvacationname){
        this.pimvacationname = pimvacationname ;
        this.modify("pimvacationname",pimvacationname);
    }

    /**
     * 设置 [XJTS]
     */
    public void setXjts(Double  xjts){
        this.xjts = xjts ;
        this.modify("xjts",xjts);
    }

    /**
     * 设置 [XJJSSJ]
     */
    public void setXjjssj(Timestamp  xjjssj){
        this.xjjssj = xjjssj ;
        this.modify("xjjssj",xjjssj);
    }

    /**
     * 设置 [XJKSSJ]
     */
    public void setXjkssj(Timestamp  xjkssj){
        this.xjkssj = xjkssj ;
        this.modify("xjkssj",xjkssj);
    }

    /**
     * 设置 [XJLX]
     */
    public void setXjlx(String  xjlx){
        this.xjlx = xjlx ;
        this.modify("xjlx",xjlx);
    }

    /**
     * 设置 [FJ]
     */
    public void setFj(String  fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }

    /**
     * 设置 [BZ]
     */
    public void setBz(String  bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

