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
 * 服务DTO对象[WFReminderDTO]
 */
@Data
public class WFReminderDTO extends DTOBase implements Serializable {

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
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [WFREMINDERID]
     *
     */
    @JSONField(name = "wfreminderid")
    @JsonProperty("wfreminderid")
    private String wfreminderid;

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
     * 属性 [REMINDERTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "remindertime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("remindertime")
    private Timestamp remindertime;

    /**
     * 属性 [WFREMINDERNAME]
     *
     */
    @JSONField(name = "wfremindername")
    @JsonProperty("wfremindername")
    private String wfremindername;

    /**
     * 属性 [REMINDERCOUNT]
     *
     */
    @JSONField(name = "remindercount")
    @JsonProperty("remindercount")
    private Integer remindercount;

    /**
     * 属性 [WFSTEPACTORNAME]
     *
     */
    @JSONField(name = "wfstepactorname")
    @JsonProperty("wfstepactorname")
    private String wfstepactorname;

    /**
     * 属性 [WFCREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "wfcreatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("wfcreatedate")
    private Timestamp wfcreatedate;

    /**
     * 属性 [ACTORID]
     *
     */
    @JSONField(name = "actorid")
    @JsonProperty("actorid")
    private String actorid;

    /**
     * 属性 [WFUSERNAME]
     *
     */
    @JSONField(name = "wfusername")
    @JsonProperty("wfusername")
    private String wfusername;

    /**
     * 属性 [WFSTEPACTORID]
     *
     */
    @JSONField(name = "wfstepactorid")
    @JsonProperty("wfstepactorid")
    private String wfstepactorid;

    /**
     * 属性 [WFUSERID]
     *
     */
    @JSONField(name = "wfuserid")
    @JsonProperty("wfuserid")
    private String wfuserid;


    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [REMINDERTIME]
     */
    public void setRemindertime(Timestamp  remindertime){
        this.remindertime = remindertime ;
        this.modify("remindertime",remindertime);
    }

    /**
     * 设置 [WFREMINDERNAME]
     */
    public void setWfremindername(String  wfremindername){
        this.wfremindername = wfremindername ;
        this.modify("wfremindername",wfremindername);
    }

    /**
     * 设置 [WFUSERNAME]
     */
    public void setWfusername(String  wfusername){
        this.wfusername = wfusername ;
        this.modify("wfusername",wfusername);
    }

    /**
     * 设置 [WFSTEPACTORID]
     */
    public void setWfstepactorid(String  wfstepactorid){
        this.wfstepactorid = wfstepactorid ;
        this.modify("wfstepactorid",wfstepactorid);
    }

    /**
     * 设置 [WFUSERID]
     */
    public void setWfuserid(String  wfuserid){
        this.wfuserid = wfuserid ;
        this.modify("wfuserid",wfuserid);
    }


}

