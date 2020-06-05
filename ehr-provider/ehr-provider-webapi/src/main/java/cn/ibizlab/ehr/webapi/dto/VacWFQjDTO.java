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
 * 服务DTO对象[VacWFQjDTO]
 */
@Data
public class VacWFQjDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DEPTLEADER]
     *
     */
    @JSONField(name = "deptleader")
    @JsonProperty("deptleader")
    private String deptleader;

    /**
     * 属性 [WFQJID]
     *
     */
    @JSONField(name = "wfqjid")
    @JsonProperty("wfqjid")
    private String wfqjid;

    /**
     * 属性 [QJSTATE]
     *
     */
    @JSONField(name = "qjstate")
    @JsonProperty("qjstate")
    private String qjstate;

    /**
     * 属性 [WFQJNAME]
     *
     */
    @JSONField(name = "wfqjname")
    @JsonProperty("wfqjname")
    private String wfqjname;

    /**
     * 属性 [WFRESULT]
     *
     */
    @JSONField(name = "wfresult")
    @JsonProperty("wfresult")
    private String wfresult;

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;


    /**
     * 设置 [DEPTLEADER]
     */
    public void setDeptleader(String  deptleader){
        this.deptleader = deptleader ;
        this.modify("deptleader",deptleader);
    }

    /**
     * 设置 [QJSTATE]
     */
    public void setQjstate(String  qjstate){
        this.qjstate = qjstate ;
        this.modify("qjstate",qjstate);
    }

    /**
     * 设置 [WFQJNAME]
     */
    public void setWfqjname(String  wfqjname){
        this.wfqjname = wfqjname ;
        this.modify("wfqjname",wfqjname);
    }

    /**
     * 设置 [WFRESULT]
     */
    public void setWfresult(String  wfresult){
        this.wfresult = wfresult ;
        this.modify("wfresult",wfresult);
    }


}

