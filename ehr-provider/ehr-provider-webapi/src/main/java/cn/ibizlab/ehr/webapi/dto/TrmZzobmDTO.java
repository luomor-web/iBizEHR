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
 * 服务DTO对象[TrmZzobmDTO]
 */
@Data
public class TrmZzobmDTO extends DTOBase implements Serializable {

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
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [LX]
     *
     */
    @JSONField(name = "lx")
    @JsonProperty("lx")
    private String lx;

    /**
     * 属性 [TRMZZOBMNAME]
     *
     */
    @JSONField(name = "trmzzobmname")
    @JsonProperty("trmzzobmname")
    private String trmzzobmname;

    /**
     * 属性 [TRMZZOBMID]
     *
     */
    @JSONField(name = "trmzzobmid")
    @JsonProperty("trmzzobmid")
    private String trmzzobmid;

    /**
     * 属性 [BM]
     *
     */
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;

    /**
     * 属性 [SJDWID]
     *
     */
    @JSONField(name = "sjdwid")
    @JsonProperty("sjdwid")
    private String sjdwid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DW]
     *
     */
    @JSONField(name = "dw")
    @JsonProperty("dw")
    private String dw;


    /**
     * 设置 [LX]
     */
    public void setLx(String  lx){
        this.lx = lx ;
        this.modify("lx",lx);
    }

    /**
     * 设置 [TRMZZOBMNAME]
     */
    public void setTrmzzobmname(String  trmzzobmname){
        this.trmzzobmname = trmzzobmname ;
        this.modify("trmzzobmname",trmzzobmname);
    }

    /**
     * 设置 [BM]
     */
    public void setBm(String  bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [SJDWID]
     */
    public void setSjdwid(String  sjdwid){
        this.sjdwid = sjdwid ;
        this.modify("sjdwid",sjdwid);
    }

    /**
     * 设置 [DW]
     */
    public void setDw(String  dw){
        this.dw = dw ;
        this.modify("dw",dw);
    }


}

