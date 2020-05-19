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
 * 服务DTO对象[PVPartDTO]
 */
@Data
public class PVPartDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PVPARTID]
     *
     */
    @JSONField(name = "pvpartid")
    @JsonProperty("pvpartid")
    private String pvpartid;

    /**
     * 属性 [PVPARTTYPE]
     *
     */
    @JSONField(name = "pvparttype")
    @JsonProperty("pvparttype")
    private String pvparttype;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

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
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [CTRLID]
     *
     */
    @JSONField(name = "ctrlid")
    @JsonProperty("ctrlid")
    private String ctrlid;

    /**
     * 属性 [PVPARTNAME]
     *
     */
    @JSONField(name = "pvpartname")
    @JsonProperty("pvpartname")
    private String pvpartname;

    /**
     * 属性 [PORTALPAGENAME]
     *
     */
    @JSONField(name = "portalpagename")
    @JsonProperty("portalpagename")
    private String portalpagename;

    /**
     * 属性 [PORTALPAGEID]
     *
     */
    @JSONField(name = "portalpageid")
    @JsonProperty("portalpageid")
    private String portalpageid;


    /**
     * 设置 [PVPARTTYPE]
     */
    public void setPvparttype(String  pvparttype){
        this.pvparttype = pvparttype ;
        this.modify("pvparttype",pvparttype);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [CTRLID]
     */
    public void setCtrlid(String  ctrlid){
        this.ctrlid = ctrlid ;
        this.modify("ctrlid",ctrlid);
    }

    /**
     * 设置 [PVPARTNAME]
     */
    public void setPvpartname(String  pvpartname){
        this.pvpartname = pvpartname ;
        this.modify("pvpartname",pvpartname);
    }

    /**
     * 设置 [PORTALPAGEID]
     */
    public void setPortalpageid(String  portalpageid){
        this.portalpageid = portalpageid ;
        this.modify("portalpageid",portalpageid);
    }


}

