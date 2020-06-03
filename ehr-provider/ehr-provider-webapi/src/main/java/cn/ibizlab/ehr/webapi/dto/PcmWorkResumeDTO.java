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
 * 服务DTO对象[PcmWorkResumeDTO]
 */
@Data
public class PcmWorkResumeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [WORKUNIT]
     *
     */
    @JSONField(name = "workunit")
    @JsonProperty("workunit")
    private String workunit;

    /**
     * 属性 [SERVEENDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "serveendtime" , format="yyyy-MM-dd")
    @JsonProperty("serveendtime")
    private Timestamp serveendtime;

    /**
     * 属性 [RESUMECONTENT]
     *
     */
    @JSONField(name = "resumecontent")
    @JsonProperty("resumecontent")
    private String resumecontent;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ZW]
     *
     */
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;

    /**
     * 属性 [GW]
     *
     */
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PCMWORKRESUMENAME]
     *
     */
    @JSONField(name = "pcmworkresumename")
    @JsonProperty("pcmworkresumename")
    private String pcmworkresumename;

    /**
     * 属性 [SERVEBEGINTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "servebegintime" , format="yyyy-MM-dd")
    @JsonProperty("servebegintime")
    private Timestamp servebegintime;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PCMWORKRESUMEID]
     *
     */
    @JSONField(name = "pcmworkresumeid")
    @JsonProperty("pcmworkresumeid")
    private String pcmworkresumeid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PCMPROFILENAME]
     *
     */
    @JSONField(name = "pcmprofilename")
    @JsonProperty("pcmprofilename")
    private String pcmprofilename;

    /**
     * 属性 [CERTIFICATENUMBER]
     *
     */
    @JSONField(name = "certificatenumber")
    @JsonProperty("certificatenumber")
    private String certificatenumber;

    /**
     * 属性 [PCMPROFILEID]
     *
     */
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;


    /**
     * 设置 [WORKUNIT]
     */
    public void setWorkunit(String  workunit){
        this.workunit = workunit ;
        this.modify("workunit",workunit);
    }

    /**
     * 设置 [SERVEENDTIME]
     */
    public void setServeendtime(Timestamp  serveendtime){
        this.serveendtime = serveendtime ;
        this.modify("serveendtime",serveendtime);
    }

    /**
     * 设置 [RESUMECONTENT]
     */
    public void setResumecontent(String  resumecontent){
        this.resumecontent = resumecontent ;
        this.modify("resumecontent",resumecontent);
    }

    /**
     * 设置 [ZW]
     */
    public void setZw(String  zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [GW]
     */
    public void setGw(String  gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [PCMWORKRESUMENAME]
     */
    public void setPcmworkresumename(String  pcmworkresumename){
        this.pcmworkresumename = pcmworkresumename ;
        this.modify("pcmworkresumename",pcmworkresumename);
    }

    /**
     * 设置 [SERVEBEGINTIME]
     */
    public void setServebegintime(Timestamp  servebegintime){
        this.servebegintime = servebegintime ;
        this.modify("servebegintime",servebegintime);
    }

    /**
     * 设置 [PCMPROFILEID]
     */
    public void setPcmprofileid(String  pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}

