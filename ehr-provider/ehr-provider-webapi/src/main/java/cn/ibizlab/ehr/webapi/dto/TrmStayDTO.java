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
 * 服务DTO对象[TrmStayDTO]
 */
@Data
public class TrmStayDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [LXR]
     *
     */
    @JSONField(name = "lxr")
    @JsonProperty("lxr")
    private String lxr;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [TRMSTAYID]
     *
     */
    @JSONField(name = "trmstayid")
    @JsonProperty("trmstayid")
    private String trmstayid;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [TRMSTAYNAME]
     *
     */
    @JSONField(name = "trmstayname")
    @JsonProperty("trmstayname")
    private String trmstayname;

    /**
     * 属性 [FJLX]
     *
     */
    @JSONField(name = "fjlx")
    @JsonProperty("fjlx")
    private String fjlx;

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
     * 属性 [FJSL]
     *
     */
    @JSONField(name = "fjsl")
    @JsonProperty("fjsl")
    private Integer fjsl;

    /**
     * 属性 [LXDH]
     *
     */
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [TRMTRAINADDRESSNAME]
     *
     */
    @JSONField(name = "trmtrainaddressname")
    @JsonProperty("trmtrainaddressname")
    private String trmtrainaddressname;

    /**
     * 属性 [TRMTRAINADDRESSID]
     *
     */
    @JSONField(name = "trmtrainaddressid")
    @JsonProperty("trmtrainaddressid")
    private String trmtrainaddressid;


    /**
     * 设置 [LXR]
     */
    public void setLxr(String  lxr){
        this.lxr = lxr ;
        this.modify("lxr",lxr);
    }

    /**
     * 设置 [TRMSTAYNAME]
     */
    public void setTrmstayname(String  trmstayname){
        this.trmstayname = trmstayname ;
        this.modify("trmstayname",trmstayname);
    }

    /**
     * 设置 [FJLX]
     */
    public void setFjlx(String  fjlx){
        this.fjlx = fjlx ;
        this.modify("fjlx",fjlx);
    }

    /**
     * 设置 [FJSL]
     */
    public void setFjsl(Integer  fjsl){
        this.fjsl = fjsl ;
        this.modify("fjsl",fjsl);
    }

    /**
     * 设置 [LXDH]
     */
    public void setLxdh(String  lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [TRMTRAINADDRESSID]
     */
    public void setTrmtrainaddressid(String  trmtrainaddressid){
        this.trmtrainaddressid = trmtrainaddressid ;
        this.modify("trmtrainaddressid",trmtrainaddressid);
    }


}

