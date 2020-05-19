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
 * 服务DTO对象[WFCustomProcessDTO]
 */
@Data
public class WFCustomProcessDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [VERSION]
     *
     */
    @JSONField(name = "version")
    @JsonProperty("version")
    private String version;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [WFCUSTOMPROCESSID]
     *
     */
    @JSONField(name = "wfcustomprocessid")
    @JsonProperty("wfcustomprocessid")
    private String wfcustomprocessid;

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
     * 属性 [PROCESSOBJECT]
     *
     */
    @JSONField(name = "processobject")
    @JsonProperty("processobject")
    private String processobject;

    /**
     * 属性 [WFCUSTOMPROCESSNAME]
     *
     */
    @JSONField(name = "wfcustomprocessname")
    @JsonProperty("wfcustomprocessname")
    private String wfcustomprocessname;


    /**
     * 设置 [VERSION]
     */
    public void setVersion(String  version){
        this.version = version ;
        this.modify("version",version);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [PROCESSOBJECT]
     */
    public void setProcessobject(String  processobject){
        this.processobject = processobject ;
        this.modify("processobject",processobject);
    }

    /**
     * 设置 [WFCUSTOMPROCESSNAME]
     */
    public void setWfcustomprocessname(String  wfcustomprocessname){
        this.wfcustomprocessname = wfcustomprocessname ;
        this.modify("wfcustomprocessname",wfcustomprocessname);
    }


}

