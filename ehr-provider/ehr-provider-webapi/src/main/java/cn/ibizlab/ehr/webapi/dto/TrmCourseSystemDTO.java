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
 * 服务DTO对象[TrmCourseSystemDTO]
 */
@Data
public class TrmCourseSystemDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [DYGX]
     *
     */
    @JSONField(name = "dygx")
    @JsonProperty("dygx")
    private String dygx;

    /**
     * 属性 [TRMCOURSESYSTEMNAME]
     *
     */
    @JSONField(name = "trmcoursesystemname")
    @JsonProperty("trmcoursesystemname")
    private String trmcoursesystemname;

    /**
     * 属性 [TRMCOURSESYSTEMID]
     *
     */
    @JSONField(name = "trmcoursesystemid")
    @JsonProperty("trmcoursesystemid")
    private String trmcoursesystemid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [JB]
     *
     */
    @JSONField(name = "jb")
    @JsonProperty("jb")
    private String jb;

    /**
     * 属性 [NR]
     *
     */
    @JSONField(name = "nr")
    @JsonProperty("nr")
    private String nr;

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
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [DM]
     *
     */
    @JSONField(name = "dm")
    @JsonProperty("dm")
    private String dm;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [TRMTRAINAGENCYNAME]
     *
     */
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;

    /**
     * 属性 [TRMTRAINAGENCYID]
     *
     */
    @JSONField(name = "trmtrainagencyid")
    @JsonProperty("trmtrainagencyid")
    private String trmtrainagencyid;


    /**
     * 设置 [DYGX]
     */
    public void setDygx(String  dygx){
        this.dygx = dygx ;
        this.modify("dygx",dygx);
    }

    /**
     * 设置 [TRMCOURSESYSTEMNAME]
     */
    public void setTrmcoursesystemname(String  trmcoursesystemname){
        this.trmcoursesystemname = trmcoursesystemname ;
        this.modify("trmcoursesystemname",trmcoursesystemname);
    }

    /**
     * 设置 [JB]
     */
    public void setJb(String  jb){
        this.jb = jb ;
        this.modify("jb",jb);
    }

    /**
     * 设置 [NR]
     */
    public void setNr(String  nr){
        this.nr = nr ;
        this.modify("nr",nr);
    }

    /**
     * 设置 [DM]
     */
    public void setDm(String  dm){
        this.dm = dm ;
        this.modify("dm",dm);
    }

    /**
     * 设置 [TRMTRAINAGENCYID]
     */
    public void setTrmtrainagencyid(String  trmtrainagencyid){
        this.trmtrainagencyid = trmtrainagencyid ;
        this.modify("trmtrainagencyid",trmtrainagencyid);
    }


}

