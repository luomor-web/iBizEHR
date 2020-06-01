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
 * 服务DTO对象[PimSearchModalDTO]
 */
@Data
public class PimSearchModalDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PIMSEARCHMODALNAME]
     *
     */
    @JSONField(name = "pimsearchmodalname")
    @JsonProperty("pimsearchmodalname")
    private String pimsearchmodalname;

    /**
     * 属性 [SEARCHFIELDS]
     *
     */
    @JSONField(name = "searchfields")
    @JsonProperty("searchfields")
    private String searchfields;

    /**
     * 属性 [CONDITIONS]
     *
     */
    @JSONField(name = "conditions")
    @JsonProperty("conditions")
    private String conditions;

    /**
     * 属性 [CONTAIN]
     *
     */
    @JSONField(name = "contain")
    @JsonProperty("contain")
    private Integer contain;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ISQUICK]
     *
     */
    @JSONField(name = "isquick")
    @JsonProperty("isquick")
    private Integer isquick;

    /**
     * 属性 [PIMSEARCHMODALID]
     *
     */
    @JSONField(name = "pimsearchmodalid")
    @JsonProperty("pimsearchmodalid")
    private String pimsearchmodalid;

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
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [PIMSEARCHMODALNAME]
     */
    public void setPimsearchmodalname(String  pimsearchmodalname){
        this.pimsearchmodalname = pimsearchmodalname ;
        this.modify("pimsearchmodalname",pimsearchmodalname);
    }

    /**
     * 设置 [SEARCHFIELDS]
     */
    public void setSearchfields(String  searchfields){
        this.searchfields = searchfields ;
        this.modify("searchfields",searchfields);
    }

    /**
     * 设置 [CONDITIONS]
     */
    public void setConditions(String  conditions){
        this.conditions = conditions ;
        this.modify("conditions",conditions);
    }

    /**
     * 设置 [CONTAIN]
     */
    public void setContain(Integer  contain){
        this.contain = contain ;
        this.modify("contain",contain);
    }

    /**
     * 设置 [ISQUICK]
     */
    public void setIsquick(Integer  isquick){
        this.isquick = isquick ;
        this.modify("isquick",isquick);
    }


}

