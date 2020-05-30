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
 * 服务DTO对象[AttEndenceOrmorgscetorDTO]
 */
@Data
public class AttEndenceOrmorgscetorDTO extends DTOBase implements Serializable {

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
     * 属性 [DZ]
     *
     */
    @JSONField(name = "dz")
    @JsonProperty("dz")
    private String dz;

    /**
     * 属性 [ATTENDENCEORMORGSECTORNAME]
     *
     */
    @JSONField(name = "attendenceormorgsectorname")
    @JsonProperty("attendenceormorgsectorname")
    private String attendenceormorgsectorname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [KQDZ]
     *
     */
    @JSONField(name = "kqdz")
    @JsonProperty("kqdz")
    private String kqdz;

    /**
     * 属性 [ATTENDENCEORMORGSECTORID]
     *
     */
    @JSONField(name = "attendenceormorgsectorid")
    @JsonProperty("attendenceormorgsectorid")
    private String attendenceormorgsectorid;

    /**
     * 属性 [ATTENDENCESETUPNAME]
     *
     */
    @JSONField(name = "attendencesetupname")
    @JsonProperty("attendencesetupname")
    private String attendencesetupname;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ORMORGSECTORNAME]
     *
     */
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;

    /**
     * 属性 [ORMORGSECTORID]
     *
     */
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;

    /**
     * 属性 [ATTENDENCESETUPID]
     *
     */
    @JSONField(name = "attendencesetupid")
    @JsonProperty("attendencesetupid")
    private String attendencesetupid;


    /**
     * 设置 [ATTENDENCEORMORGSECTORNAME]
     */
    public void setAttendenceormorgsectorname(String  attendenceormorgsectorname){
        this.attendenceormorgsectorname = attendenceormorgsectorname ;
        this.modify("attendenceormorgsectorname",attendenceormorgsectorname);
    }

    /**
     * 设置 [KQDZ]
     */
    public void setKqdz(String  kqdz){
        this.kqdz = kqdz ;
        this.modify("kqdz",kqdz);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [ATTENDENCESETUPID]
     */
    public void setAttendencesetupid(String  attendencesetupid){
        this.attendencesetupid = attendencesetupid ;
        this.modify("attendencesetupid",attendencesetupid);
    }


}

