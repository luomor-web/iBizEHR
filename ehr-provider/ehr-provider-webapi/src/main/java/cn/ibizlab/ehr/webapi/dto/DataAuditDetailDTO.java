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
 * 服务DTO对象[DataAuditDetailDTO]
 */
@Data
public class DataAuditDetailDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DATAAUDITDETAILID]
     *
     */
    @JSONField(name = "dataauditdetailid")
    @JsonProperty("dataauditdetailid")
    private String dataauditdetailid;

    /**
     * 属性 [DATAAUDITDETAILNAME]
     *
     */
    @JSONField(name = "dataauditdetailname")
    @JsonProperty("dataauditdetailname")
    private String dataauditdetailname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [OLDTEXT]
     *
     */
    @JSONField(name = "oldtext")
    @JsonProperty("oldtext")
    private String oldtext;

    /**
     * 属性 [OLDVALUE]
     *
     */
    @JSONField(name = "oldvalue")
    @JsonProperty("oldvalue")
    private String oldvalue;

    /**
     * 属性 [NEWVALUE]
     *
     */
    @JSONField(name = "newvalue")
    @JsonProperty("newvalue")
    private String newvalue;

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
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [NEWTEXT]
     *
     */
    @JSONField(name = "newtext")
    @JsonProperty("newtext")
    private String newtext;

    /**
     * 属性 [DATAAUDITNAME]
     *
     */
    @JSONField(name = "dataauditname")
    @JsonProperty("dataauditname")
    private String dataauditname;

    /**
     * 属性 [DATAAUDITID]
     *
     */
    @JSONField(name = "dataauditid")
    @JsonProperty("dataauditid")
    private String dataauditid;


    /**
     * 设置 [DATAAUDITDETAILNAME]
     */
    public void setDataauditdetailname(String  dataauditdetailname){
        this.dataauditdetailname = dataauditdetailname ;
        this.modify("dataauditdetailname",dataauditdetailname);
    }

    /**
     * 设置 [OLDTEXT]
     */
    public void setOldtext(String  oldtext){
        this.oldtext = oldtext ;
        this.modify("oldtext",oldtext);
    }

    /**
     * 设置 [OLDVALUE]
     */
    public void setOldvalue(String  oldvalue){
        this.oldvalue = oldvalue ;
        this.modify("oldvalue",oldvalue);
    }

    /**
     * 设置 [NEWVALUE]
     */
    public void setNewvalue(String  newvalue){
        this.newvalue = newvalue ;
        this.modify("newvalue",newvalue);
    }

    /**
     * 设置 [NEWTEXT]
     */
    public void setNewtext(String  newtext){
        this.newtext = newtext ;
        this.modify("newtext",newtext);
    }

    /**
     * 设置 [DATAAUDITNAME]
     */
    public void setDataauditname(String  dataauditname){
        this.dataauditname = dataauditname ;
        this.modify("dataauditname",dataauditname);
    }

    /**
     * 设置 [DATAAUDITID]
     */
    public void setDataauditid(String  dataauditid){
        this.dataauditid = dataauditid ;
        this.modify("dataauditid",dataauditid);
    }


}

