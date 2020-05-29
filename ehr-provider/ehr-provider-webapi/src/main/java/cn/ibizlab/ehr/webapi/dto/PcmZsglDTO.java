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
 * 服务DTO对象[PcmZsglDTO]
 */
@Data
public class PcmZsglDTO extends DTOBase implements Serializable {

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
     * 属性 [ZJNAME]
     *
     */
    @JSONField(name = "zjname")
    @JsonProperty("zjname")
    private String zjname;

    /**
     * 属性 [PCMZSGLID]
     *
     */
    @JSONField(name = "pcmzsglid")
    @JsonProperty("pcmzsglid")
    private String pcmzsglid;

    /**
     * 属性 [ZS]
     *
     */
    @JSONField(name = "zs")
    @JsonProperty("zs")
    private Integer zs;

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
     * 属性 [ZZNAME]
     *
     */
    @JSONField(name = "zzname")
    @JsonProperty("zzname")
    private String zzname;

    /**
     * 属性 [ZJID]
     *
     */
    @JSONField(name = "zjid")
    @JsonProperty("zjid")
    private String zjid;

    /**
     * 属性 [ZZID]
     *
     */
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;

    /**
     * 属性 [PCMZSGLNAME]
     *
     */
    @JSONField(name = "pcmzsglname")
    @JsonProperty("pcmzsglname")
    private String pcmzsglname;


    /**
     * 设置 [ZJNAME]
     */
    public void setZjname(String  zjname){
        this.zjname = zjname ;
        this.modify("zjname",zjname);
    }

    /**
     * 设置 [ZS]
     */
    public void setZs(Integer  zs){
        this.zs = zs ;
        this.modify("zs",zs);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [ZZNAME]
     */
    public void setZzname(String  zzname){
        this.zzname = zzname ;
        this.modify("zzname",zzname);
    }

    /**
     * 设置 [ZJID]
     */
    public void setZjid(String  zjid){
        this.zjid = zjid ;
        this.modify("zjid",zjid);
    }

    /**
     * 设置 [ZZID]
     */
    public void setZzid(String  zzid){
        this.zzid = zzid ;
        this.modify("zzid",zzid);
    }

    /**
     * 设置 [PCMZSGLNAME]
     */
    public void setPcmzsglname(String  pcmzsglname){
        this.pcmzsglname = pcmzsglname ;
        this.modify("pcmzsglname",pcmzsglname);
    }


}

