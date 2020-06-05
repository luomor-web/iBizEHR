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
 * 服务DTO对象[PimNationMgrDTO]
 */
@Data
public class PimNationMgrDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORDERNO]
     *
     */
    @JSONField(name = "orderno")
    @JsonProperty("orderno")
    private Integer orderno;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [NATIONCODE]
     *
     */
    @JSONField(name = "nationcode")
    @JsonProperty("nationcode")
    private String nationcode;

    /**
     * 属性 [NATIONMGRID]
     *
     */
    @JSONField(name = "nationmgrid")
    @JsonProperty("nationmgrid")
    private String nationmgrid;

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
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [NATIONMGRNAME]
     *
     */
    @JSONField(name = "nationmgrname")
    @JsonProperty("nationmgrname")
    private String nationmgrname;


    /**
     * 设置 [ORDERNO]
     */
    public void setOrderno(Integer  orderno){
        this.orderno = orderno ;
        this.modify("orderno",orderno);
    }

    /**
     * 设置 [NATIONCODE]
     */
    public void setNationcode(String  nationcode){
        this.nationcode = nationcode ;
        this.modify("nationcode",nationcode);
    }

    /**
     * 设置 [NATIONMGRNAME]
     */
    public void setNationmgrname(String  nationmgrname){
        this.nationmgrname = nationmgrname ;
        this.modify("nationmgrname",nationmgrname);
    }


}

