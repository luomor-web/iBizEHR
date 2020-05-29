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
 * 服务DTO对象[PimArchivesRecordDTO]
 */
@Data
public class PimArchivesRecordDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [PIMARCHIVESRECORDNAME]
     *
     */
    @JSONField(name = "pimarchivesrecordname")
    @JsonProperty("pimarchivesrecordname")
    private String pimarchivesrecordname;

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
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [PIMARCHIVESRECORDID]
     *
     */
    @JSONField(name = "pimarchivesrecordid")
    @JsonProperty("pimarchivesrecordid")
    private String pimarchivesrecordid;

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
     * 属性 [PIMARCHIVESNAME]
     *
     */
    @JSONField(name = "pimarchivesname")
    @JsonProperty("pimarchivesname")
    private String pimarchivesname;

    /**
     * 属性 [SERIALNUMBER]
     *
     */
    @JSONField(name = "serialnumber")
    @JsonProperty("serialnumber")
    private Integer serialnumber;

    /**
     * 属性 [ARCHIVALCATALOGUENAME]
     *
     */
    @JSONField(name = "archivalcataloguename")
    @JsonProperty("archivalcataloguename")
    private String archivalcataloguename;

    /**
     * 属性 [ARCHIVALCATALOGUEID]
     *
     */
    @JSONField(name = "archivalcatalogueid")
    @JsonProperty("archivalcatalogueid")
    private String archivalcatalogueid;

    /**
     * 属性 [PIMARCHIVESID]
     *
     */
    @JSONField(name = "pimarchivesid")
    @JsonProperty("pimarchivesid")
    private String pimarchivesid;


    /**
     * 设置 [PIMARCHIVESRECORDNAME]
     */
    public void setPimarchivesrecordname(String  pimarchivesrecordname){
        this.pimarchivesrecordname = pimarchivesrecordname ;
        this.modify("pimarchivesrecordname",pimarchivesrecordname);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [ARCHIVALCATALOGUEID]
     */
    public void setArchivalcatalogueid(String  archivalcatalogueid){
        this.archivalcatalogueid = archivalcatalogueid ;
        this.modify("archivalcatalogueid",archivalcatalogueid);
    }

    /**
     * 设置 [PIMARCHIVESID]
     */
    public void setPimarchivesid(String  pimarchivesid){
        this.pimarchivesid = pimarchivesid ;
        this.modify("pimarchivesid",pimarchivesid);
    }


}

