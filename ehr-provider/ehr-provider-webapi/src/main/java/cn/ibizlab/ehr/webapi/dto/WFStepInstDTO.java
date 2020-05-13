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
 * 服务DTO对象[WFStepInstDTO]
 */
@Data
public class WFStepInstDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [RETURNDATA]
     *
     */
    @JSONField(name = "returndata")
    @JsonProperty("returndata")
    private String returndata;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [WFSTEPINSTNAME]
     *
     */
    @JSONField(name = "wfstepinstname")
    @JsonProperty("wfstepinstname")
    private String wfstepinstname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [WFSTEPINSTID]
     *
     */
    @JSONField(name = "wfstepinstid")
    @JsonProperty("wfstepinstid")
    private String wfstepinstid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [WFSTEPLANRESTAG]
     *
     */
    @JSONField(name = "wfsteplanrestag")
    @JsonProperty("wfsteplanrestag")
    private String wfsteplanrestag;

    /**
     * 属性 [CLOSEFLAG]
     *
     */
    @JSONField(name = "closeflag")
    @JsonProperty("closeflag")
    private Integer closeflag;

    /**
     * 属性 [WFSTEPNAME]
     *
     */
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;

    /**
     * 属性 [WFINSTANCENAME]
     *
     */
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;

    /**
     * 属性 [WFINSTANCEID]
     *
     */
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;

    /**
     * 属性 [WFSTEPID]
     *
     */
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;


    /**
     * 设置 [RETURNDATA]
     */
    public void setReturndata(String  returndata){
        this.returndata = returndata ;
        this.modify("returndata",returndata);
    }

    /**
     * 设置 [WFSTEPINSTNAME]
     */
    public void setWfstepinstname(String  wfstepinstname){
        this.wfstepinstname = wfstepinstname ;
        this.modify("wfstepinstname",wfstepinstname);
    }

    /**
     * 设置 [WFSTEPLANRESTAG]
     */
    public void setWfsteplanrestag(String  wfsteplanrestag){
        this.wfsteplanrestag = wfsteplanrestag ;
        this.modify("wfsteplanrestag",wfsteplanrestag);
    }

    /**
     * 设置 [CLOSEFLAG]
     */
    public void setCloseflag(Integer  closeflag){
        this.closeflag = closeflag ;
        this.modify("closeflag",closeflag);
    }

    /**
     * 设置 [WFSTEPNAME]
     */
    public void setWfstepname(String  wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }

    /**
     * 设置 [WFINSTANCENAME]
     */
    public void setWfinstancename(String  wfinstancename){
        this.wfinstancename = wfinstancename ;
        this.modify("wfinstancename",wfinstancename);
    }

    /**
     * 设置 [WFINSTANCEID]
     */
    public void setWfinstanceid(String  wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }

    /**
     * 设置 [WFSTEPID]
     */
    public void setWfstepid(String  wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }


}

