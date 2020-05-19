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
 * 服务DTO对象[WFIAActionDTO]
 */
@Data
public class WFIAActionDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ACTIONCOUNT]
     *
     */
    @JSONField(name = "actioncount")
    @JsonProperty("actioncount")
    private Integer actioncount;

    /**
     * 属性 [ORDERFLAG]
     *
     */
    @JSONField(name = "orderflag")
    @JsonProperty("orderflag")
    private Integer orderflag;

    /**
     * 属性 [FAHELPER]
     *
     */
    @JSONField(name = "fahelper")
    @JsonProperty("fahelper")
    private String fahelper;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [NEXTTO]
     *
     */
    @JSONField(name = "nextto")
    @JsonProperty("nextto")
    private String nextto;

    /**
     * 属性 [PAGEPATH]
     *
     */
    @JSONField(name = "pagepath")
    @JsonProperty("pagepath")
    private String pagepath;

    /**
     * 属性 [ACTIONNAME]
     *
     */
    @JSONField(name = "actionname")
    @JsonProperty("actionname")
    private String actionname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [WFIAACTIONID]
     *
     */
    @JSONField(name = "wfiaactionid")
    @JsonProperty("wfiaactionid")
    private String wfiaactionid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ACTIONLOGICNAME]
     *
     */
    @JSONField(name = "actionlogicname")
    @JsonProperty("actionlogicname")
    private String actionlogicname;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [NEXTCONDITION]
     *
     */
    @JSONField(name = "nextcondition")
    @JsonProperty("nextcondition")
    private String nextcondition;

    /**
     * 属性 [WFIAACTIONNAME]
     *
     */
    @JSONField(name = "wfiaactionname")
    @JsonProperty("wfiaactionname")
    private String wfiaactionname;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [PANELID]
     *
     */
    @JSONField(name = "panelid")
    @JsonProperty("panelid")
    private String panelid;

    /**
     * 属性 [WFSTEPNAME]
     *
     */
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;

    /**
     * 属性 [WFSTEPID]
     *
     */
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;


    /**
     * 设置 [ACTIONCOUNT]
     */
    public void setActioncount(Integer  actioncount){
        this.actioncount = actioncount ;
        this.modify("actioncount",actioncount);
    }

    /**
     * 设置 [ORDERFLAG]
     */
    public void setOrderflag(Integer  orderflag){
        this.orderflag = orderflag ;
        this.modify("orderflag",orderflag);
    }

    /**
     * 设置 [FAHELPER]
     */
    public void setFahelper(String  fahelper){
        this.fahelper = fahelper ;
        this.modify("fahelper",fahelper);
    }

    /**
     * 设置 [NEXTTO]
     */
    public void setNextto(String  nextto){
        this.nextto = nextto ;
        this.modify("nextto",nextto);
    }

    /**
     * 设置 [PAGEPATH]
     */
    public void setPagepath(String  pagepath){
        this.pagepath = pagepath ;
        this.modify("pagepath",pagepath);
    }

    /**
     * 设置 [ACTIONNAME]
     */
    public void setActionname(String  actionname){
        this.actionname = actionname ;
        this.modify("actionname",actionname);
    }

    /**
     * 设置 [ACTIONLOGICNAME]
     */
    public void setActionlogicname(String  actionlogicname){
        this.actionlogicname = actionlogicname ;
        this.modify("actionlogicname",actionlogicname);
    }

    /**
     * 设置 [NEXTCONDITION]
     */
    public void setNextcondition(String  nextcondition){
        this.nextcondition = nextcondition ;
        this.modify("nextcondition",nextcondition);
    }

    /**
     * 设置 [WFIAACTIONNAME]
     */
    public void setWfiaactionname(String  wfiaactionname){
        this.wfiaactionname = wfiaactionname ;
        this.modify("wfiaactionname",wfiaactionname);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [PANELID]
     */
    public void setPanelid(String  panelid){
        this.panelid = panelid ;
        this.modify("panelid",panelid);
    }

    /**
     * 设置 [WFSTEPNAME]
     */
    public void setWfstepname(String  wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }

    /**
     * 设置 [WFSTEPID]
     */
    public void setWfstepid(String  wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }


}

