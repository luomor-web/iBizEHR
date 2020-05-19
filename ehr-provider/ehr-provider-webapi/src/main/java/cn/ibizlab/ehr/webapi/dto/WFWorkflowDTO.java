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
 * 服务DTO对象[WFWorkflowDTO]
 */
@Data
public class WFWorkflowDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [WFLANRESTAG]
     *
     */
    @JSONField(name = "wflanrestag")
    @JsonProperty("wflanrestag")
    private String wflanrestag;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [WFTYPE]
     *
     */
    @JSONField(name = "wftype")
    @JsonProperty("wftype")
    private String wftype;

    /**
     * 属性 [WFMODEL]
     *
     */
    @JSONField(name = "wfmodel")
    @JsonProperty("wfmodel")
    private String wfmodel;

    /**
     * 属性 [WFLOGICNAME]
     *
     */
    @JSONField(name = "wflogicname")
    @JsonProperty("wflogicname")
    private String wflogicname;

    /**
     * 属性 [WFWORKFLOWNAME]
     *
     */
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;

    /**
     * 属性 [USERDATACMD4]
     *
     */
    @JSONField(name = "userdatacmd4")
    @JsonProperty("userdatacmd4")
    private String userdatacmd4;

    /**
     * 属性 [USERDATACMD8]
     *
     */
    @JSONField(name = "userdatacmd8")
    @JsonProperty("userdatacmd8")
    private String userdatacmd8;

    /**
     * 属性 [WFHELPER]
     *
     */
    @JSONField(name = "wfhelper")
    @JsonProperty("wfhelper")
    private String wfhelper;

    /**
     * 属性 [WFSTATE]
     *
     */
    @JSONField(name = "wfstate")
    @JsonProperty("wfstate")
    private Integer wfstate;

    /**
     * 属性 [WFVERSION]
     *
     */
    @JSONField(name = "wfversion")
    @JsonProperty("wfversion")
    private Integer wfversion;

    /**
     * 属性 [USERDATACMD]
     *
     */
    @JSONField(name = "userdatacmd")
    @JsonProperty("userdatacmd")
    private String userdatacmd;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [USERDATACMD2]
     *
     */
    @JSONField(name = "userdatacmd2")
    @JsonProperty("userdatacmd2")
    private String userdatacmd2;

    /**
     * 属性 [USERDATANAME]
     *
     */
    @JSONField(name = "userdataname")
    @JsonProperty("userdataname")
    private String userdataname;

    /**
     * 属性 [USERDATACMD3]
     *
     */
    @JSONField(name = "userdatacmd3")
    @JsonProperty("userdatacmd3")
    private String userdatacmd3;

    /**
     * 属性 [USERDATACMD9]
     *
     */
    @JSONField(name = "userdatacmd9")
    @JsonProperty("userdatacmd9")
    private String userdatacmd9;

    /**
     * 属性 [USERDATACMD10]
     *
     */
    @JSONField(name = "userdatacmd10")
    @JsonProperty("userdatacmd10")
    private String userdatacmd10;

    /**
     * 属性 [USERDATACMD7]
     *
     */
    @JSONField(name = "userdatacmd7")
    @JsonProperty("userdatacmd7")
    private String userdatacmd7;

    /**
     * 属性 [WFWORKFLOWID]
     *
     */
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;

    /**
     * 属性 [WFHELPERPARAM]
     *
     */
    @JSONField(name = "wfhelperparam")
    @JsonProperty("wfhelperparam")
    private String wfhelperparam;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [USERDATACMD6]
     *
     */
    @JSONField(name = "userdatacmd6")
    @JsonProperty("userdatacmd6")
    private String userdatacmd6;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [USERDATACMD5]
     *
     */
    @JSONField(name = "userdatacmd5")
    @JsonProperty("userdatacmd5")
    private String userdatacmd5;

    /**
     * 属性 [REMINDMSGTEMPLNAME]
     *
     */
    @JSONField(name = "remindmsgtemplname")
    @JsonProperty("remindmsgtemplname")
    private String remindmsgtemplname;

    /**
     * 属性 [REMINDMSGTEMPLID]
     *
     */
    @JSONField(name = "remindmsgtemplid")
    @JsonProperty("remindmsgtemplid")
    private String remindmsgtemplid;


    /**
     * 设置 [WFLANRESTAG]
     */
    public void setWflanrestag(String  wflanrestag){
        this.wflanrestag = wflanrestag ;
        this.modify("wflanrestag",wflanrestag);
    }

    /**
     * 设置 [WFTYPE]
     */
    public void setWftype(String  wftype){
        this.wftype = wftype ;
        this.modify("wftype",wftype);
    }

    /**
     * 设置 [WFMODEL]
     */
    public void setWfmodel(String  wfmodel){
        this.wfmodel = wfmodel ;
        this.modify("wfmodel",wfmodel);
    }

    /**
     * 设置 [WFLOGICNAME]
     */
    public void setWflogicname(String  wflogicname){
        this.wflogicname = wflogicname ;
        this.modify("wflogicname",wflogicname);
    }

    /**
     * 设置 [WFWORKFLOWNAME]
     */
    public void setWfworkflowname(String  wfworkflowname){
        this.wfworkflowname = wfworkflowname ;
        this.modify("wfworkflowname",wfworkflowname);
    }

    /**
     * 设置 [USERDATACMD4]
     */
    public void setUserdatacmd4(String  userdatacmd4){
        this.userdatacmd4 = userdatacmd4 ;
        this.modify("userdatacmd4",userdatacmd4);
    }

    /**
     * 设置 [USERDATACMD8]
     */
    public void setUserdatacmd8(String  userdatacmd8){
        this.userdatacmd8 = userdatacmd8 ;
        this.modify("userdatacmd8",userdatacmd8);
    }

    /**
     * 设置 [WFHELPER]
     */
    public void setWfhelper(String  wfhelper){
        this.wfhelper = wfhelper ;
        this.modify("wfhelper",wfhelper);
    }

    /**
     * 设置 [WFSTATE]
     */
    public void setWfstate(Integer  wfstate){
        this.wfstate = wfstate ;
        this.modify("wfstate",wfstate);
    }

    /**
     * 设置 [WFVERSION]
     */
    public void setWfversion(Integer  wfversion){
        this.wfversion = wfversion ;
        this.modify("wfversion",wfversion);
    }

    /**
     * 设置 [USERDATACMD]
     */
    public void setUserdatacmd(String  userdatacmd){
        this.userdatacmd = userdatacmd ;
        this.modify("userdatacmd",userdatacmd);
    }

    /**
     * 设置 [USERDATACMD2]
     */
    public void setUserdatacmd2(String  userdatacmd2){
        this.userdatacmd2 = userdatacmd2 ;
        this.modify("userdatacmd2",userdatacmd2);
    }

    /**
     * 设置 [USERDATANAME]
     */
    public void setUserdataname(String  userdataname){
        this.userdataname = userdataname ;
        this.modify("userdataname",userdataname);
    }

    /**
     * 设置 [USERDATACMD3]
     */
    public void setUserdatacmd3(String  userdatacmd3){
        this.userdatacmd3 = userdatacmd3 ;
        this.modify("userdatacmd3",userdatacmd3);
    }

    /**
     * 设置 [USERDATACMD9]
     */
    public void setUserdatacmd9(String  userdatacmd9){
        this.userdatacmd9 = userdatacmd9 ;
        this.modify("userdatacmd9",userdatacmd9);
    }

    /**
     * 设置 [USERDATACMD10]
     */
    public void setUserdatacmd10(String  userdatacmd10){
        this.userdatacmd10 = userdatacmd10 ;
        this.modify("userdatacmd10",userdatacmd10);
    }

    /**
     * 设置 [USERDATACMD7]
     */
    public void setUserdatacmd7(String  userdatacmd7){
        this.userdatacmd7 = userdatacmd7 ;
        this.modify("userdatacmd7",userdatacmd7);
    }

    /**
     * 设置 [WFHELPERPARAM]
     */
    public void setWfhelperparam(String  wfhelperparam){
        this.wfhelperparam = wfhelperparam ;
        this.modify("wfhelperparam",wfhelperparam);
    }

    /**
     * 设置 [USERDATACMD6]
     */
    public void setUserdatacmd6(String  userdatacmd6){
        this.userdatacmd6 = userdatacmd6 ;
        this.modify("userdatacmd6",userdatacmd6);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [USERDATACMD5]
     */
    public void setUserdatacmd5(String  userdatacmd5){
        this.userdatacmd5 = userdatacmd5 ;
        this.modify("userdatacmd5",userdatacmd5);
    }

    /**
     * 设置 [REMINDMSGTEMPLID]
     */
    public void setRemindmsgtemplid(String  remindmsgtemplid){
        this.remindmsgtemplid = remindmsgtemplid ;
        this.modify("remindmsgtemplid",remindmsgtemplid);
    }


}

