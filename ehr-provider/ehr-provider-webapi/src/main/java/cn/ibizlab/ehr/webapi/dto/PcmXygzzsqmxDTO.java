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
 * 服务DTO对象[PcmXygzzsqmxDTO]
 */
@Data
public class PcmXygzzsqmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [FINISHED]
     *
     */
    @JSONField(name = "finished")
    @JsonProperty("finished")
    private Integer finished;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

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
     * 属性 [PCMXYGZZSQMXID]
     *
     */
    @JSONField(name = "pcmxygzzsqmxid")
    @JsonProperty("pcmxygzzsqmxid")
    private String pcmxygzzsqmxid;

    /**
     * 属性 [PCMXYGZZSQMXNAME]
     *
     */
    @JSONField(name = "pcmxygzzsqmxname")
    @JsonProperty("pcmxygzzsqmxname")
    private String pcmxygzzsqmxname;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [ZJ]
     *
     */
    @JSONField(name = "zj")
    @JsonProperty("zj")
    private String zj;

    /**
     * 属性 [PCMXYGZZSQNAME]
     *
     */
    @JSONField(name = "pcmxygzzsqname")
    @JsonProperty("pcmxygzzsqname")
    private String pcmxygzzsqname;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [PCMXYGZZSQID]
     *
     */
    @JSONField(name = "pcmxygzzsqid")
    @JsonProperty("pcmxygzzsqid")
    private String pcmxygzzsqid;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;


    /**
     * 设置 [FINISHED]
     */
    public void setFinished(Integer  finished){
        this.finished = finished ;
        this.modify("finished",finished);
    }

    /**
     * 设置 [ENABLE]
     */
    public void setEnable(Integer  enable){
        this.enable = enable ;
        this.modify("enable",enable);
    }

    /**
     * 设置 [PCMXYGZZSQMXNAME]
     */
    public void setPcmxygzzsqmxname(String  pcmxygzzsqmxname){
        this.pcmxygzzsqmxname = pcmxygzzsqmxname ;
        this.modify("pcmxygzzsqmxname",pcmxygzzsqmxname);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [GW]
     */
    public void setGw(String  gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [ZJ]
     */
    public void setZj(String  zj){
        this.zj = zj ;
        this.modify("zj",zj);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [ZW]
     */
    public void setZw(String  zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [PCMXYGZZSQID]
     */
    public void setPcmxygzzsqid(String  pcmxygzzsqid){
        this.pcmxygzzsqid = pcmxygzzsqid ;
        this.modify("pcmxygzzsqid",pcmxygzzsqid);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

