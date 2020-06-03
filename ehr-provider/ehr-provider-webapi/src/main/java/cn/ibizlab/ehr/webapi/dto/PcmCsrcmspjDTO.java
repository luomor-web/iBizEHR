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
 * 服务DTO对象[PcmCsrcmspjDTO]
 */
@Data
public class PcmCsrcmspjDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PCMCSRCMSPJID]
     *
     */
    @JSONField(name = "pcmcsrcmspjid")
    @JsonProperty("pcmcsrcmspjid")
    private String pcmcsrcmspjid;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [MSPJ]
     *
     */
    @JSONField(name = "mspj")
    @JsonProperty("mspj")
    private String mspj;

    /**
     * 属性 [MSCJ]
     *
     */
    @JSONField(name = "mscj")
    @JsonProperty("mscj")
    private Double mscj;

    /**
     * 属性 [YGMC]
     *
     */
    @JSONField(name = "ygmc")
    @JsonProperty("ygmc")
    private String ygmc;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

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
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PCMCSRCMSPJNAME]
     *
     */
    @JSONField(name = "pcmcsrcmspjname")
    @JsonProperty("pcmcsrcmspjname")
    private String pcmcsrcmspjname;


    /**
     * 设置 [MSPJ]
     */
    public void setMspj(String  mspj){
        this.mspj = mspj ;
        this.modify("mspj",mspj);
    }

    /**
     * 设置 [MSCJ]
     */
    public void setMscj(Double  mscj){
        this.mscj = mscj ;
        this.modify("mscj",mscj);
    }

    /**
     * 设置 [YGMC]
     */
    public void setYgmc(String  ygmc){
        this.ygmc = ygmc ;
        this.modify("ygmc",ygmc);
    }

    /**
     * 设置 [YGBH]
     */
    public void setYgbh(String  ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [PCMCSRCMSPJNAME]
     */
    public void setPcmcsrcmspjname(String  pcmcsrcmspjname){
        this.pcmcsrcmspjname = pcmcsrcmspjname ;
        this.modify("pcmcsrcmspjname",pcmcsrcmspjname);
    }


}

