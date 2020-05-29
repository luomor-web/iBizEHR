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
 * 服务DTO对象[OrmBmkqdzDTO]
 */
@Data
public class OrmBmkqdzDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [ORMORGDZID]
     *
     */
    @JSONField(name = "ormorgdzid")
    @JsonProperty("ormorgdzid")
    private String ormorgdzid;

    /**
     * 属性 [ORMBMKQDZNAME]
     *
     */
    @JSONField(name = "ormbmkqdzname")
    @JsonProperty("ormbmkqdzname")
    private String ormbmkqdzname;

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
     * 属性 [ORMBMKQDZID]
     *
     */
    @JSONField(name = "ormbmkqdzid")
    @JsonProperty("ormbmkqdzid")
    private String ormbmkqdzid;

    /**
     * 属性 [LNG]
     *
     */
    @JSONField(name = "lng")
    @JsonProperty("lng")
    private Double lng;

    /**
     * 属性 [SFMRKQDZ]
     *
     */
    @JSONField(name = "sfmrkqdz")
    @JsonProperty("sfmrkqdz")
    private String sfmrkqdz;

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
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [LAT]
     *
     */
    @JSONField(name = "lat")
    @JsonProperty("lat")
    private Double lat;

    /**
     * 属性 [XH]
     *
     */
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;

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
     * 属性 [ATTENDANCERANGE]
     *
     */
    @JSONField(name = "attendancerange")
    @JsonProperty("attendancerange")
    private Integer attendancerange;


    /**
     * 设置 [ORMORGDZID]
     */
    public void setOrmorgdzid(String  ormorgdzid){
        this.ormorgdzid = ormorgdzid ;
        this.modify("ormorgdzid",ormorgdzid);
    }

    /**
     * 设置 [ORMBMKQDZNAME]
     */
    public void setOrmbmkqdzname(String  ormbmkqdzname){
        this.ormbmkqdzname = ormbmkqdzname ;
        this.modify("ormbmkqdzname",ormbmkqdzname);
    }

    /**
     * 设置 [LNG]
     */
    public void setLng(Double  lng){
        this.lng = lng ;
        this.modify("lng",lng);
    }

    /**
     * 设置 [SFMRKQDZ]
     */
    public void setSfmrkqdz(String  sfmrkqdz){
        this.sfmrkqdz = sfmrkqdz ;
        this.modify("sfmrkqdz",sfmrkqdz);
    }

    /**
     * 设置 [LAT]
     */
    public void setLat(Double  lat){
        this.lat = lat ;
        this.modify("lat",lat);
    }

    /**
     * 设置 [XH]
     */
    public void setXh(Integer  xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [ORMORGSECTORID]
     */
    public void setOrmorgsectorid(String  ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [ATTENDANCERANGE]
     */
    public void setAttendancerange(Integer  attendancerange){
        this.attendancerange = attendancerange ;
        this.modify("attendancerange",attendancerange);
    }


}

