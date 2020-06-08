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
 * 服务DTO对象[PcmJxsygzzsqmxDTO]
 */
@Data
public class PcmJxsygzzsqmxDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [STATUS]
     *
     */
    @JSONField(name = "status")
    @JsonProperty("status")
    private String status;

    /**
     * 属性 [PCMJXSYGZZSQMXID]
     *
     */
    @JSONField(name = "pcmjxsygzzsqmxid")
    @JsonProperty("pcmjxsygzzsqmxid")
    private String pcmjxsygzzsqmxid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PCMJXSYGZZSQMXNAME]
     *
     */
    @JSONField(name = "pcmjxsygzzsqmxname")
    @JsonProperty("pcmjxsygzzsqmxname")
    private String pcmjxsygzzsqmxname;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [PIMPERSONNAME]
     *
     */
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [ZJ]
     *
     */
    @JSONField(name = "zj")
    @JsonProperty("zj")
    private String zj;

    /**
     * 属性 [PCMJXSYGZZSQNAME]
     *
     */
    @JSONField(name = "pcmjxsygzzsqname")
    @JsonProperty("pcmjxsygzzsqname")
    private String pcmjxsygzzsqname;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [PIMPERSONID]
     *
     */
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;

    /**
     * 属性 [PCMJXSYGZZSQID]
     *
     */
    @JSONField(name = "pcmjxsygzzsqid")
    @JsonProperty("pcmjxsygzzsqid")
    private String pcmjxsygzzsqid;


    /**
     * 设置 [STATUS]
     */
    public void setStatus(String  status){
        this.status = status ;
        this.modify("status",status);
    }

    /**
     * 设置 [PCMJXSYGZZSQMXNAME]
     */
    public void setPcmjxsygzzsqmxname(String  pcmjxsygzzsqmxname){
        this.pcmjxsygzzsqmxname = pcmjxsygzzsqmxname ;
        this.modify("pcmjxsygzzsqmxname",pcmjxsygzzsqmxname);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
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
     * 设置 [ZW]
     */
    public void setZw(String  zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [PCMJXSYGZZSQID]
     */
    public void setPcmjxsygzzsqid(String  pcmjxsygzzsqid){
        this.pcmjxsygzzsqid = pcmjxsygzzsqid ;
        this.modify("pcmjxsygzzsqid",pcmjxsygzzsqid);
    }


}

