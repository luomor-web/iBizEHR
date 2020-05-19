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
 * 服务DTO对象[WFWorkListDTO]
 */
@Data
public class WFWorkListDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [WFSTEPID]
     *
     */
    @JSONField(name = "wfstepid")
    @JsonProperty("wfstepid")
    private String wfstepid;

    /**
     * 属性 [WFWORKLISTID]
     *
     */
    @JSONField(name = "wfworklistid")
    @JsonProperty("wfworklistid")
    private String wfworklistid;

    /**
     * 属性 [USERDATAINFO]
     *
     */
    @JSONField(name = "userdatainfo")
    @JsonProperty("userdatainfo")
    private String userdatainfo;

    /**
     * 属性 [USERDATA3]
     *
     */
    @JSONField(name = "userdata3")
    @JsonProperty("userdata3")
    private String userdata3;

    /**
     * 属性 [WFWORKFLOWNAME]
     *
     */
    @JSONField(name = "wfworkflowname")
    @JsonProperty("wfworkflowname")
    private String wfworkflowname;

    /**
     * 属性 [WFSTEPLANRESTAG]
     *
     */
    @JSONField(name = "wfsteplanrestag")
    @JsonProperty("wfsteplanrestag")
    private String wfsteplanrestag;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [WORKINFORM]
     *
     */
    @JSONField(name = "workinform")
    @JsonProperty("workinform")
    private Integer workinform;

    /**
     * 属性 [WFWORKLISTNAME]
     *
     */
    @JSONField(name = "wfworklistname")
    @JsonProperty("wfworklistname")
    private String wfworklistname;

    /**
     * 属性 [WFSTEPNAME]
     *
     */
    @JSONField(name = "wfstepname")
    @JsonProperty("wfstepname")
    private String wfstepname;

    /**
     * 属性 [CANCELINFORM]
     *
     */
    @JSONField(name = "cancelinform")
    @JsonProperty("cancelinform")
    private Integer cancelinform;

    /**
     * 属性 [WFACTORID]
     *
     */
    @JSONField(name = "wfactorid")
    @JsonProperty("wfactorid")
    private String wfactorid;

    /**
     * 属性 [CANCELFLAG]
     *
     */
    @JSONField(name = "cancelflag")
    @JsonProperty("cancelflag")
    private Integer cancelflag;

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
     * 属性 [USERDATA4]
     *
     */
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [WFWORKFLOWID]
     *
     */
    @JSONField(name = "wfworkflowid")
    @JsonProperty("wfworkflowid")
    private String wfworkflowid;

    /**
     * 属性 [WFLANRESTAG]
     *
     */
    @JSONField(name = "wflanrestag")
    @JsonProperty("wflanrestag")
    private String wflanrestag;

    /**
     * 属性 [ORIGINALWFUSERNAME]
     *
     */
    @JSONField(name = "originalwfusername")
    @JsonProperty("originalwfusername")
    private String originalwfusername;

    /**
     * 属性 [WFINSTANCENAME]
     *
     */
    @JSONField(name = "wfinstancename")
    @JsonProperty("wfinstancename")
    private String wfinstancename;

    /**
     * 属性 [ORIGINALWFUSERID]
     *
     */
    @JSONField(name = "originalwfuserid")
    @JsonProperty("originalwfuserid")
    private String originalwfuserid;

    /**
     * 属性 [WFINSTANCEID]
     *
     */
    @JSONField(name = "wfinstanceid")
    @JsonProperty("wfinstanceid")
    private String wfinstanceid;


    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [WFSTEPID]
     */
    public void setWfstepid(String  wfstepid){
        this.wfstepid = wfstepid ;
        this.modify("wfstepid",wfstepid);
    }

    /**
     * 设置 [USERDATAINFO]
     */
    public void setUserdatainfo(String  userdatainfo){
        this.userdatainfo = userdatainfo ;
        this.modify("userdatainfo",userdatainfo);
    }

    /**
     * 设置 [USERDATA3]
     */
    public void setUserdata3(String  userdata3){
        this.userdata3 = userdata3 ;
        this.modify("userdata3",userdata3);
    }

    /**
     * 设置 [WFWORKFLOWNAME]
     */
    public void setWfworkflowname(String  wfworkflowname){
        this.wfworkflowname = wfworkflowname ;
        this.modify("wfworkflowname",wfworkflowname);
    }

    /**
     * 设置 [WFSTEPLANRESTAG]
     */
    public void setWfsteplanrestag(String  wfsteplanrestag){
        this.wfsteplanrestag = wfsteplanrestag ;
        this.modify("wfsteplanrestag",wfsteplanrestag);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

    /**
     * 设置 [WORKINFORM]
     */
    public void setWorkinform(Integer  workinform){
        this.workinform = workinform ;
        this.modify("workinform",workinform);
    }

    /**
     * 设置 [WFWORKLISTNAME]
     */
    public void setWfworklistname(String  wfworklistname){
        this.wfworklistname = wfworklistname ;
        this.modify("wfworklistname",wfworklistname);
    }

    /**
     * 设置 [WFSTEPNAME]
     */
    public void setWfstepname(String  wfstepname){
        this.wfstepname = wfstepname ;
        this.modify("wfstepname",wfstepname);
    }

    /**
     * 设置 [CANCELINFORM]
     */
    public void setCancelinform(Integer  cancelinform){
        this.cancelinform = cancelinform ;
        this.modify("cancelinform",cancelinform);
    }

    /**
     * 设置 [WFACTORID]
     */
    public void setWfactorid(String  wfactorid){
        this.wfactorid = wfactorid ;
        this.modify("wfactorid",wfactorid);
    }

    /**
     * 设置 [CANCELFLAG]
     */
    public void setCancelflag(Integer  cancelflag){
        this.cancelflag = cancelflag ;
        this.modify("cancelflag",cancelflag);
    }

    /**
     * 设置 [USERDATA4]
     */
    public void setUserdata4(String  userdata4){
        this.userdata4 = userdata4 ;
        this.modify("userdata4",userdata4);
    }

    /**
     * 设置 [WFWORKFLOWID]
     */
    public void setWfworkflowid(String  wfworkflowid){
        this.wfworkflowid = wfworkflowid ;
        this.modify("wfworkflowid",wfworkflowid);
    }

    /**
     * 设置 [WFLANRESTAG]
     */
    public void setWflanrestag(String  wflanrestag){
        this.wflanrestag = wflanrestag ;
        this.modify("wflanrestag",wflanrestag);
    }

    /**
     * 设置 [ORIGINALWFUSERNAME]
     */
    public void setOriginalwfusername(String  originalwfusername){
        this.originalwfusername = originalwfusername ;
        this.modify("originalwfusername",originalwfusername);
    }

    /**
     * 设置 [WFINSTANCENAME]
     */
    public void setWfinstancename(String  wfinstancename){
        this.wfinstancename = wfinstancename ;
        this.modify("wfinstancename",wfinstancename);
    }

    /**
     * 设置 [ORIGINALWFUSERID]
     */
    public void setOriginalwfuserid(String  originalwfuserid){
        this.originalwfuserid = originalwfuserid ;
        this.modify("originalwfuserid",originalwfuserid);
    }

    /**
     * 设置 [WFINSTANCEID]
     */
    public void setWfinstanceid(String  wfinstanceid){
        this.wfinstanceid = wfinstanceid ;
        this.modify("wfinstanceid",wfinstanceid);
    }


}

