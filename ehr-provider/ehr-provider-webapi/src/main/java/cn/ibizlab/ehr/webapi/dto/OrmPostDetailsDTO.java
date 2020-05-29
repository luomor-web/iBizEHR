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
 * 服务DTO对象[OrmPostDetailsDTO]
 */
@Data
public class OrmPostDetailsDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

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
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ORMPOSTDETAILSID]
     *
     */
    @JSONField(name = "ormpostdetailsid")
    @JsonProperty("ormpostdetailsid")
    private String ormpostdetailsid;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [ORMPOSTDETAILSNAME]
     *
     */
    @JSONField(name = "ormpostdetailsname")
    @JsonProperty("ormpostdetailsname")
    private String ormpostdetailsname;

    /**
     * 属性 [GWFLAG]
     *
     */
    @JSONField(name = "gwflag")
    @JsonProperty("gwflag")
    private String gwflag;

    /**
     * 属性 [SUGEXCYEAR]
     *
     */
    @JSONField(name = "sugexcyear")
    @JsonProperty("sugexcyear")
    private Integer sugexcyear;

    /**
     * 属性 [GWTYPE]
     *
     */
    @JSONField(name = "gwtype")
    @JsonProperty("gwtype")
    private String gwtype;

    /**
     * 属性 [POSTNATURE]
     *
     */
    @JSONField(name = "postnature")
    @JsonProperty("postnature")
    private String postnature;

    /**
     * 属性 [ORMPOSTNAME]
     *
     */
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;

    /**
     * 属性 [MUSTEXCYEAR]
     *
     */
    @JSONField(name = "mustexcyear")
    @JsonProperty("mustexcyear")
    private Integer mustexcyear;

    /**
     * 属性 [ORMPOSTLIBNAME]
     *
     */
    @JSONField(name = "ormpostlibname")
    @JsonProperty("ormpostlibname")
    private String ormpostlibname;

    /**
     * 属性 [ISCONFIDENTIAL]
     *
     */
    @JSONField(name = "isconfidential")
    @JsonProperty("isconfidential")
    private String isconfidential;

    /**
     * 属性 [ORMPOSTID]
     *
     */
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;

    /**
     * 属性 [ORMPOSTLIBID]
     *
     */
    @JSONField(name = "ormpostlibid")
    @JsonProperty("ormpostlibid")
    private String ormpostlibid;


    /**
     * 设置 [ORMPOSTDETAILSNAME]
     */
    public void setOrmpostdetailsname(String  ormpostdetailsname){
        this.ormpostdetailsname = ormpostdetailsname ;
        this.modify("ormpostdetailsname",ormpostdetailsname);
    }

    /**
     * 设置 [ORMPOSTID]
     */
    public void setOrmpostid(String  ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [ORMPOSTLIBID]
     */
    public void setOrmpostlibid(String  ormpostlibid){
        this.ormpostlibid = ormpostlibid ;
        this.modify("ormpostlibid",ormpostlibid);
    }


}

