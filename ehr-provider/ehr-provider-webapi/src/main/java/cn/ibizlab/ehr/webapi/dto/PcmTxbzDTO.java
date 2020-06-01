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
 * 服务DTO对象[PcmTxbzDTO]
 */
@Data
public class PcmTxbzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [PCMTXBZID]
     *
     */
    @JSONField(name = "pcmtxbzid")
    @JsonProperty("pcmtxbzid")
    private String pcmtxbzid;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private String xh;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [XB]
     *
     */
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [TXNL]
     *
     */
    @JSONField(name = "txnl")
    @JsonProperty("txnl")
    private Integer txnl;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [PCMTXBZNAME]
     *
     */
    @JSONField(name = "pcmtxbzname")
    @JsonProperty("pcmtxbzname")
    private String pcmtxbzname;


    /**
     * 设置 [XH]
     */
    public void setXh(String  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [XB]
     */
    public void setXb(String  xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [TXNL]
     */
    public void setTxnl(Integer  txnl){
        this.txnl = txnl ;
        this.modify("txnl",txnl);
    }

    /**
     * 设置 [PCMTXBZNAME]
     */
    public void setPcmtxbzname(String  pcmtxbzname){
        this.pcmtxbzname = pcmtxbzname ;
        this.modify("pcmtxbzname",pcmtxbzname);
    }


}

