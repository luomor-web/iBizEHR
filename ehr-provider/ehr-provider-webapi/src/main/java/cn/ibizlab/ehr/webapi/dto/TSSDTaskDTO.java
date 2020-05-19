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
 * 服务DTO对象[TSSDTaskDTO]
 */
@Data
public class TSSDTaskDTO extends DTOBase implements Serializable {

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
     * 属性 [USERDATA3]
     *
     */
    @JSONField(name = "userdata3")
    @JsonProperty("userdata3")
    private String userdata3;

    /**
     * 属性 [TASKPARAM]
     *
     */
    @JSONField(name = "taskparam")
    @JsonProperty("taskparam")
    private String taskparam;

    /**
     * 属性 [USERDATA2]
     *
     */
    @JSONField(name = "userdata2")
    @JsonProperty("userdata2")
    private String userdata2;

    /**
     * 属性 [USERDATA4]
     *
     */
    @JSONField(name = "userdata4")
    @JsonProperty("userdata4")
    private String userdata4;

    /**
     * 属性 [ENABLEFLAG]
     *
     */
    @JSONField(name = "enableflag")
    @JsonProperty("enableflag")
    private Integer enableflag;

    /**
     * 属性 [TSSDTASKID]
     *
     */
    @JSONField(name = "tssdtaskid")
    @JsonProperty("tssdtaskid")
    private String tssdtaskid;

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
     * 属性 [VERSION]
     *
     */
    @JSONField(name = "version")
    @JsonProperty("version")
    private Integer version;

    /**
     * 属性 [TSSDTASKNAME]
     *
     */
    @JSONField(name = "tssdtaskname")
    @JsonProperty("tssdtaskname")
    private String tssdtaskname;

    /**
     * 属性 [USERDATA]
     *
     */
    @JSONField(name = "userdata")
    @JsonProperty("userdata")
    private String userdata;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [TSSDENGINENAME]
     *
     */
    @JSONField(name = "tssdenginename")
    @JsonProperty("tssdenginename")
    private String tssdenginename;

    /**
     * 属性 [TSSDENGINEID]
     *
     */
    @JSONField(name = "tssdengineid")
    @JsonProperty("tssdengineid")
    private String tssdengineid;


    /**
     * 设置 [USERDATA3]
     */
    public void setUserdata3(String  userdata3){
        this.userdata3 = userdata3 ;
        this.modify("userdata3",userdata3);
    }

    /**
     * 设置 [TASKPARAM]
     */
    public void setTaskparam(String  taskparam){
        this.taskparam = taskparam ;
        this.modify("taskparam",taskparam);
    }

    /**
     * 设置 [USERDATA2]
     */
    public void setUserdata2(String  userdata2){
        this.userdata2 = userdata2 ;
        this.modify("userdata2",userdata2);
    }

    /**
     * 设置 [USERDATA4]
     */
    public void setUserdata4(String  userdata4){
        this.userdata4 = userdata4 ;
        this.modify("userdata4",userdata4);
    }

    /**
     * 设置 [ENABLEFLAG]
     */
    public void setEnableflag(Integer  enableflag){
        this.enableflag = enableflag ;
        this.modify("enableflag",enableflag);
    }

    /**
     * 设置 [VERSION]
     */
    public void setVersion(Integer  version){
        this.version = version ;
        this.modify("version",version);
    }

    /**
     * 设置 [TSSDTASKNAME]
     */
    public void setTssdtaskname(String  tssdtaskname){
        this.tssdtaskname = tssdtaskname ;
        this.modify("tssdtaskname",tssdtaskname);
    }

    /**
     * 设置 [USERDATA]
     */
    public void setUserdata(String  userdata){
        this.userdata = userdata ;
        this.modify("userdata",userdata);
    }

    /**
     * 设置 [TSSDENGINEID]
     */
    public void setTssdengineid(String  tssdengineid){
        this.tssdengineid = tssdengineid ;
        this.modify("tssdengineid",tssdengineid);
    }


}

