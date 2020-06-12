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
 * 服务DTO对象[PimArchivesCenterDTO]
 */
@Data
public class PimArchivesCenterDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CABINETNO]
     *
     */
    @JSONField(name = "cabinetno")
    @JsonProperty("cabinetno")
    private String cabinetno;

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
     * 属性 [BNUMBER]
     *
     */
    @JSONField(name = "bnumber")
    @JsonProperty("bnumber")
    private String bnumber;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [POSITION]
     *
     */
    @JSONField(name = "position")
    @JsonProperty("position")
    private String position;

    /**
     * 属性 [ARCHIVESCENTERID]
     *
     */
    @JSONField(name = "archivescenterid")
    @JsonProperty("archivescenterid")
    private String archivescenterid;

    /**
     * 属性 [SERIALNO]
     *
     */
    @JSONField(name = "serialno")
    @JsonProperty("serialno")
    private Integer serialno;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ARCHIVESCENTERNAME]
     *
     */
    @JSONField(name = "archivescentername")
    @JsonProperty("archivescentername")
    private String archivescentername;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [LAYERNO]
     *
     */
    @JSONField(name = "layerno")
    @JsonProperty("layerno")
    private String layerno;

    /**
     * 属性 [ENABLE]
     *
     */
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;

    /**
     * 属性 [ORMORGNAME]
     *
     */
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;

    /**
     * 属性 [ORMORGID]
     *
     */
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;


    /**
     * 设置 [CABINETNO]
     */
    public void setCabinetno(String  cabinetno){
        this.cabinetno = cabinetno ;
        this.modify("cabinetno",cabinetno);
    }

    /**
     * 设置 [BNUMBER]
     */
    public void setBnumber(String  bnumber){
        this.bnumber = bnumber ;
        this.modify("bnumber",bnumber);
    }

    /**
     * 设置 [SERIALNO]
     */
    public void setSerialno(Integer  serialno){
        this.serialno = serialno ;
        this.modify("serialno",serialno);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [ARCHIVESCENTERNAME]
     */
    public void setArchivescentername(String  archivescentername){
        this.archivescentername = archivescentername ;
        this.modify("archivescentername",archivescentername);
    }

    /**
     * 设置 [LAYERNO]
     */
    public void setLayerno(String  layerno){
        this.layerno = layerno ;
        this.modify("layerno",layerno);
    }

    /**
     * 设置 [ORMORGID]
     */
    public void setOrmorgid(String  ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}

