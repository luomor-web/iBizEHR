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
 * 服务DTO对象[PcmProfileSpyyDTO]
 */
@Data
public class PcmProfileSpyyDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [YYBM]
     *
     */
    @JSONField(name = "yybm")
    @JsonProperty("yybm")
    private String yybm;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PCMPROFILESPYYNAME]
     *
     */
    @JSONField(name = "pcmprofilespyyname")
    @JsonProperty("pcmprofilespyyname")
    private String pcmprofilespyyname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [PCMPROFILESPYYID]
     *
     */
    @JSONField(name = "pcmprofilespyyid")
    @JsonProperty("pcmprofilespyyid")
    private String pcmprofilespyyid;

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
     * 属性 [YYMC]
     *
     */
    @JSONField(name = "yymc")
    @JsonProperty("yymc")
    private String yymc;


    /**
     * 设置 [YYBM]
     */
    public void setYybm(String  yybm){
        this.yybm = yybm ;
        this.modify("yybm",yybm);
    }

    /**
     * 设置 [PCMPROFILESPYYNAME]
     */
    public void setPcmprofilespyyname(String  pcmprofilespyyname){
        this.pcmprofilespyyname = pcmprofilespyyname ;
        this.modify("pcmprofilespyyname",pcmprofilespyyname);
    }

    /**
     * 设置 [YYMC]
     */
    public void setYymc(String  yymc){
        this.yymc = yymc ;
        this.modify("yymc",yymc);
    }


}

