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
 * 服务DTO对象[VacLeaveSystemDtailDTO]
 */
@Data
public class VacLeaveSystemDtailDTO extends DTOBase implements Serializable {

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
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [VACLEAVESYSTEMDETAILNAME]
     *
     */
    @JSONField(name = "vacleavesystemdetailname")
    @JsonProperty("vacleavesystemdetailname")
    private String vacleavesystemdetailname;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [XJLX]
     *
     */
    @JSONField(name = "xjlx")
    @JsonProperty("xjlx")
    private String xjlx;

    /**
     * 属性 [XJGZ]
     *
     */
    @JSONField(name = "xjgz")
    @JsonProperty("xjgz")
    private String xjgz;

    /**
     * 属性 [VACLEAVESYSTEMDETAILID]
     *
     */
    @JSONField(name = "vacleavesystemdetailid")
    @JsonProperty("vacleavesystemdetailid")
    private String vacleavesystemdetailid;

    /**
     * 属性 [XJGZGS]
     *
     */
    @JSONField(name = "xjgzgs")
    @JsonProperty("xjgzgs")
    private String xjgzgs;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [VACLEAVESYSTEMNAME]
     *
     */
    @JSONField(name = "vacleavesystemname")
    @JsonProperty("vacleavesystemname")
    private String vacleavesystemname;

    /**
     * 属性 [VACLEAVESYSTEMID]
     *
     */
    @JSONField(name = "vacleavesystemid")
    @JsonProperty("vacleavesystemid")
    private String vacleavesystemid;


    /**
     * 设置 [VACLEAVESYSTEMDETAILNAME]
     */
    public void setVacleavesystemdetailname(String  vacleavesystemdetailname){
        this.vacleavesystemdetailname = vacleavesystemdetailname ;
        this.modify("vacleavesystemdetailname",vacleavesystemdetailname);
    }

    /**
     * 设置 [XJLX]
     */
    public void setXjlx(String  xjlx){
        this.xjlx = xjlx ;
        this.modify("xjlx",xjlx);
    }

    /**
     * 设置 [XJGZ]
     */
    public void setXjgz(String  xjgz){
        this.xjgz = xjgz ;
        this.modify("xjgz",xjgz);
    }

    /**
     * 设置 [XJGZGS]
     */
    public void setXjgzgs(String  xjgzgs){
        this.xjgzgs = xjgzgs ;
        this.modify("xjgzgs",xjgzgs);
    }

    /**
     * 设置 [VACLEAVESYSTEMID]
     */
    public void setVacleavesystemid(String  vacleavesystemid){
        this.vacleavesystemid = vacleavesystemid ;
        this.modify("vacleavesystemid",vacleavesystemid);
    }


}

