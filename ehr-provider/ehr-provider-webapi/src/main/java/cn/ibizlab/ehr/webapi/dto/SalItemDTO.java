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
 * 服务DTO对象[SalItemDTO]
 */
@Data
public class SalItemDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

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
     * 属性 [SALITEMNAME]
     *
     */
    @JSONField(name = "salitemname")
    @JsonProperty("salitemname")
    private String salitemname;

    /**
     * 属性 [SALITEMID]
     *
     */
    @JSONField(name = "salitemid")
    @JsonProperty("salitemid")
    private String salitemid;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

    /**
     * 属性 [SALSUBJECTNAME]
     *
     */
    @JSONField(name = "salsubjectname")
    @JsonProperty("salsubjectname")
    private String salsubjectname;

    /**
     * 属性 [SALSUBJECTID]
     *
     */
    @JSONField(name = "salsubjectid")
    @JsonProperty("salsubjectid")
    private String salsubjectid;


    /**
     * 设置 [SALITEMNAME]
     */
    public void setSalitemname(String  salitemname){
        this.salitemname = salitemname ;
        this.modify("salitemname",salitemname);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [SALSUBJECTID]
     */
    public void setSalsubjectid(String  salsubjectid){
        this.salsubjectid = salsubjectid ;
        this.modify("salsubjectid",salsubjectid);
    }


}

