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
 * 服务DTO对象[PCMDDSQDDTO]
 */
@Data
public class PCMDDSQDDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [SQSJ]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sqsj" , format="yyyy-MM-dd")
    @JsonProperty("sqsj")
    private Timestamp sqsj;

    /**
     * 属性 [PCMDDSQDID]
     *
     */
    @JSONField(name = "pcmddsqdid")
    @JsonProperty("pcmddsqdid")
    private String pcmddsqdid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [BZSM]
     *
     */
    @JSONField(name = "bzsm")
    @JsonProperty("bzsm")
    private String bzsm;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PCMDDSQDNAME]
     *
     */
    @JSONField(name = "pcmddsqdname")
    @JsonProperty("pcmddsqdname")
    private String pcmddsqdname;

    /**
     * 属性 [LX]
     *
     */
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

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
     * 设置 [SQSJ]
     */
    public void setSqsj(Timestamp  sqsj){
        this.sqsj = sqsj ;
        this.modify("sqsj",sqsj);
    }

    /**
     * 设置 [BZSM]
     */
    public void setBzsm(String  bzsm){
        this.bzsm = bzsm ;
        this.modify("bzsm",bzsm);
    }

    /**
     * 设置 [PCMDDSQDNAME]
     */
    public void setPcmddsqdname(String  pcmddsqdname){
        this.pcmddsqdname = pcmddsqdname ;
        this.modify("pcmddsqdname",pcmddsqdname);
    }

    /**
     * 设置 [LX]
     */
    public void setLx(String  lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [PIMPERSONID]
     */
    public void setPimpersonid(String  pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }


}

