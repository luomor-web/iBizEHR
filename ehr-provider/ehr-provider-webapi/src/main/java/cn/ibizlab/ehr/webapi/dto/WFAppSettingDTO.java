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
 * 服务DTO对象[WFAppSettingDTO]
 */
@Data
public class WFAppSettingDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [WFAPPSETTINGID]
     *
     */
    @JSONField(name = "wfappsettingid")
    @JsonProperty("wfappsettingid")
    private String wfappsettingid;

    /**
     * 属性 [WFAPPSETTINGNAME]
     *
     */
    @JSONField(name = "wfappsettingname")
    @JsonProperty("wfappsettingname")
    private String wfappsettingname;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [APPLICATIONID]
     *
     */
    @JSONField(name = "applicationid")
    @JsonProperty("applicationid")
    private String applicationid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [REMINDMSGTEMPLNAME]
     *
     */
    @JSONField(name = "remindmsgtemplname")
    @JsonProperty("remindmsgtemplname")
    private String remindmsgtemplname;

    /**
     * 属性 [REMINDMSGTEMPID]
     *
     */
    @JSONField(name = "remindmsgtemplid")
    @JsonProperty("remindmsgtemplid")
    private String remindmsgtemplid;


    /**
     * 设置 [WFAPPSETTINGNAME]
     */
    public void setWfappsettingname(String  wfappsettingname){
        this.wfappsettingname = wfappsettingname ;
        this.modify("wfappsettingname",wfappsettingname);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [APPLICATIONID]
     */
    public void setApplicationid(String  applicationid){
        this.applicationid = applicationid ;
        this.modify("applicationid",applicationid);
    }

    /**
     * 设置 [REMINDMSGTEMPLNAME]
     */
    public void setRemindmsgtemplname(String  remindmsgtemplname){
        this.remindmsgtemplname = remindmsgtemplname ;
        this.modify("remindmsgtemplname",remindmsgtemplname);
    }

    /**
     * 设置 [REMINDMSGTEMPID]
     */
    public void setRemindmsgtemplid(String  remindmsgtemplid){
        this.remindmsgtemplid = remindmsgtemplid ;
        this.modify("remindmsgtempid",remindmsgtemplid);
    }


}

