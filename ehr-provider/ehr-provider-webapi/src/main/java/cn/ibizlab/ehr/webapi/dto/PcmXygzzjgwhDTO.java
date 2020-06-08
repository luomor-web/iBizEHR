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
 * 服务DTO对象[PcmXygzzjgwhDTO]
 */
@Data
public class PcmXygzzjgwhDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ND]
     *
     */
    @JSONField(name = "nd")
    @JsonProperty("nd")
    private String nd;

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
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [YGBH]
     *
     */
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ZZ]
     *
     */
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;

    /**
     * 属性 [PCMXYGZZJGWHID]
     *
     */
    @JSONField(name = "pcmxygzzjgwhid")
    @JsonProperty("pcmxygzzjgwhid")
    private String pcmxygzzjgwhid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [KHJG]
     *
     */
    @JSONField(name = "khjg")
    @JsonProperty("khjg")
    private Double khjg;

    /**
     * 属性 [PCMXYGZZJGWHNAME]
     *
     */
    @JSONField(name = "pcmxygzzjgwhname")
    @JsonProperty("pcmxygzzjgwhname")
    private String pcmxygzzjgwhname;


    /**
     * 设置 [ND]
     */
    public void setNd(String  nd){
        this.nd = nd ;
        this.modify("nd",nd);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [ZZ]
     */
    public void setZz(String  zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [KHJG]
     */
    public void setKhjg(Double  khjg){
        this.khjg = khjg ;
        this.modify("khjg",khjg);
    }

    /**
     * 设置 [PCMXYGZZJGWHNAME]
     */
    public void setPcmxygzzjgwhname(String  pcmxygzzjgwhname){
        this.pcmxygzzjgwhname = pcmxygzzjgwhname ;
        this.modify("pcmxygzzjgwhname",pcmxygzzjgwhname);
    }


}

