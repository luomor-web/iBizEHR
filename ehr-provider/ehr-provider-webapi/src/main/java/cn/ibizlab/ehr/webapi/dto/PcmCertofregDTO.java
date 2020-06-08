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
 * 服务DTO对象[PcmCertofregDTO]
 */
@Data
public class PcmCertofregDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [LX]
     *
     */
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PCMCERTOFREGNAME]
     *
     */
    @JSONField(name = "pcmcertofregname")
    @JsonProperty("pcmcertofregname")
    private String pcmcertofregname;

    /**
     * 属性 [BH]
     *
     */
    @JSONField(name = "bh")
    @JsonProperty("bh")
    private String bh;

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
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PCMCERTOFREGID]
     *
     */
    @JSONField(name = "pcmcertofregid")
    @JsonProperty("pcmcertofregid")
    private String pcmcertofregid;

    /**
     * 属性 [ZSFJ]
     *
     */
    @JSONField(name = "zsfj")
    @JsonProperty("zsfj")
    private String zsfj;

    /**
     * 属性 [CERTIFICATENUMBER]
     *
     */
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;

    /**
     * 属性 [ZYZGZY]
     *
     */
    @JSONField(name = "zyzgzy")
    @JsonProperty("zyzgzy")
    private String zyzgzy;

    /**
     * 属性 [PCMPROFILENAME]
     *
     */
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;

    /**
     * 属性 [PIMQUALMAJORID]
     *
     */
    @JSONField(name = "pimqualmajorid")
    @JsonProperty("pimqualmajorid")
    private String pimqualmajorid;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;


    /**
     * 设置 [LX]
     */
    public void setLx(String  lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [PCMCERTOFREGNAME]
     */
    public void setPcmcertofregname(String  pcmcertofregname){
        this.pcmcertofregname = pcmcertofregname ;
        this.modify("pcmcertofregname",pcmcertofregname);
    }

    /**
     * 设置 [BH]
     */
    public void setBh(String  bh){
        this.bh = bh ;
        this.modify("bh",bh);
    }

    /**
     * 设置 [ZSFJ]
     */
    public void setZsfj(String  zsfj){
        this.zsfj = zsfj ;
        this.modify("zsfj",zsfj);
    }

    /**
     * 设置 [PIMQUALMAJORID]
     */
    public void setPimqualmajorid(String  pimqualmajorid){
        this.pimqualmajorid = pimqualmajorid ;
        this.modify("pimqualmajorid",pimqualmajorid);
    }

    /**
     * 设置 [PCMPROFILEID]
     */
    public void setPcmprofileid(String  pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}

