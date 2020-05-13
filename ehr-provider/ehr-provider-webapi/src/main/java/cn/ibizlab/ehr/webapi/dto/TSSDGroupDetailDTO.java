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
 * 服务DTO对象[TSSDGroupDetailDTO]
 */
@Data
public class TSSDGroupDetailDTO extends DTOBase implements Serializable {

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
     * 属性 [TSSDGROUPDETAILID]
     *
     */
    @JSONField(name = "tssdgroupdetailid")
    @JsonProperty("tssdgroupdetailid")
    private String tssdgroupdetailid;

    /**
     * 属性 [TSSDGROUPDETAILNAME]
     *
     */
    @JSONField(name = "tssdgroupdetailname")
    @JsonProperty("tssdgroupdetailname")
    private String tssdgroupdetailname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [TSSDGROUPNAME]
     *
     */
    @JSONField(name = "tssdgroupname")
    @JsonProperty("tssdgroupname")
    private String tssdgroupname;

    /**
     * 属性 [TSSDITEMNAME]
     *
     */
    @JSONField(name = "tssditemname")
    @JsonProperty("tssditemname")
    private String tssditemname;

    /**
     * 属性 [TSSDGROUPID]
     *
     */
    @JSONField(name = "tssdgroupid")
    @JsonProperty("tssdgroupid")
    private String tssdgroupid;

    /**
     * 属性 [TSSDITEMID]
     *
     */
    @JSONField(name = "tssditemid")
    @JsonProperty("tssditemid")
    private String tssditemid;


    /**
     * 设置 [TSSDGROUPDETAILNAME]
     */
    public void setTssdgroupdetailname(String  tssdgroupdetailname){
        this.tssdgroupdetailname = tssdgroupdetailname ;
        this.modify("tssdgroupdetailname",tssdgroupdetailname);
    }

    /**
     * 设置 [TSSDGROUPID]
     */
    public void setTssdgroupid(String  tssdgroupid){
        this.tssdgroupid = tssdgroupid ;
        this.modify("tssdgroupid",tssdgroupid);
    }

    /**
     * 设置 [TSSDITEMID]
     */
    public void setTssditemid(String  tssditemid){
        this.tssditemid = tssditemid ;
        this.modify("tssditemid",tssditemid);
    }


}

