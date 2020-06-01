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
 * 服务DTO对象[PimWorkflowRefDTO]
 */
@Data
public class PimWorkflowRefDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PIMWORKFLOWREFID]
     *
     */
    @JSONField(name = "pimworkflowrefid")
    @JsonProperty("pimworkflowrefid")
    private String pimworkflowrefid;

    /**
     * 属性 [PIMWORKFLOWREFNAME]
     *
     */
    @JSONField(name = "pimworkflowrefname")
    @JsonProperty("pimworkflowrefname")
    private String pimworkflowrefname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

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
     * 属性 [PIMWORKFLOWNAME]
     *
     */
    @JSONField(name = "pimworkflowname")
    @JsonProperty("pimworkflowname")
    private String pimworkflowname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 属性 [PIMWORKFLOWID]
     *
     */
    @JSONField(name = "pimworkflowid")
    @JsonProperty("pimworkflowid")
    private String pimworkflowid;


    /**
     * 设置 [PIMWORKFLOWREFNAME]
     */
    public void setPimworkflowrefname(String  pimworkflowrefname){
        this.pimworkflowrefname = pimworkflowrefname ;
        this.modify("pimworkflowrefname",pimworkflowrefname);
    }

    /**
     * 设置 [PIMWORKFLOWID]
     */
    public void setPimworkflowid(String  pimworkflowid){
        this.pimworkflowid = pimworkflowid ;
        this.modify("pimworkflowid",pimworkflowid);
    }


}

