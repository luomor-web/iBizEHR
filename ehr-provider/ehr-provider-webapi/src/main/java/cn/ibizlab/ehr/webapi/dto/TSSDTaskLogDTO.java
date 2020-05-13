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
 * 服务DTO对象[TSSDTaskLogDTO]
 */
@Data
public class TSSDTaskLogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [RETINFO]
     *
     */
    @JSONField(name = "retinfo")
    @JsonProperty("retinfo")
    private String retinfo;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [STARTTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "starttime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("starttime")
    private Timestamp starttime;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [TSSDTASKLOGNAME]
     *
     */
    @JSONField(name = "tssdtasklogname")
    @JsonProperty("tssdtasklogname")
    private String tssdtasklogname;

    /**
     * 属性 [RETCODE]
     *
     */
    @JSONField(name = "retcode")
    @JsonProperty("retcode")
    private Integer retcode;

    /**
     * 属性 [ENDTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "endtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("endtime")
    private Timestamp endtime;

    /**
     * 属性 [DURATION]
     *
     */
    @JSONField(name = "duration")
    @JsonProperty("duration")
    private Integer duration;

    /**
     * 属性 [TSSDTASKLOGID]
     *
     */
    @JSONField(name = "tssdtasklogid")
    @JsonProperty("tssdtasklogid")
    private String tssdtasklogid;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [TSSDTASKNAME]
     *
     */
    @JSONField(name = "tssdtaskname")
    @JsonProperty("tssdtaskname")
    private String tssdtaskname;

    /**
     * 属性 [TSSDTASKID]
     *
     */
    @JSONField(name = "tssdtaskid")
    @JsonProperty("tssdtaskid")
    private String tssdtaskid;


    /**
     * 设置 [RETINFO]
     */
    public void setRetinfo(String  retinfo){
        this.retinfo = retinfo ;
        this.modify("retinfo",retinfo);
    }

    /**
     * 设置 [STARTTIME]
     */
    public void setStarttime(Timestamp  starttime){
        this.starttime = starttime ;
        this.modify("starttime",starttime);
    }

    /**
     * 设置 [TSSDTASKLOGNAME]
     */
    public void setTssdtasklogname(String  tssdtasklogname){
        this.tssdtasklogname = tssdtasklogname ;
        this.modify("tssdtasklogname",tssdtasklogname);
    }

    /**
     * 设置 [RETCODE]
     */
    public void setRetcode(Integer  retcode){
        this.retcode = retcode ;
        this.modify("retcode",retcode);
    }

    /**
     * 设置 [ENDTIME]
     */
    public void setEndtime(Timestamp  endtime){
        this.endtime = endtime ;
        this.modify("endtime",endtime);
    }

    /**
     * 设置 [DURATION]
     */
    public void setDuration(Integer  duration){
        this.duration = duration ;
        this.modify("duration",duration);
    }

    /**
     * 设置 [TSSDTASKNAME]
     */
    public void setTssdtaskname(String  tssdtaskname){
        this.tssdtaskname = tssdtaskname ;
        this.modify("tssdtaskname",tssdtaskname);
    }

    /**
     * 设置 [TSSDTASKID]
     */
    public void setTssdtaskid(String  tssdtaskid){
        this.tssdtaskid = tssdtaskid ;
        this.modify("tssdtaskid",tssdtaskid);
    }


}

