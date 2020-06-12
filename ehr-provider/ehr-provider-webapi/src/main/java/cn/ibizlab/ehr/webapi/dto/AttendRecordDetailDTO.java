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
 * 服务DTO对象[AttendRecordDetailDTO]
 */
@Data
public class AttendRecordDetailDTO extends DTOBase implements Serializable {

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
     * 属性 [LNG]
     *
     */
    @JSONField(name = "lng")
    @JsonProperty("lng")
    private Double lng;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [ATTENDRECORDDETAILNAME]
     *
     */
    @JSONField(name = "attendrecorddetailname")
    @JsonProperty("attendrecorddetailname")
    private String attendrecorddetailname;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [SIGNTIME]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "signtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("signtime")
    private Timestamp signtime;

    /**
     * 属性 [SIGNLOCATION]
     *
     */
    @JSONField(name = "signlocation")
    @JsonProperty("signlocation")
    private String signlocation;

    /**
     * 属性 [ATTENDRECORDDETAILID]
     *
     */
    @JSONField(name = "attendrecorddetailid")
    @JsonProperty("attendrecorddetailid")
    private String attendrecorddetailid;

    /**
     * 属性 [LAT]
     *
     */
    @JSONField(name = "lat")
    @JsonProperty("lat")
    private Double lat;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [ATTENDANCERECORDNAME]
     *
     */
    @JSONField(name = "attendancerecordname")
    @JsonProperty("attendancerecordname")
    private String attendancerecordname;

    /**
     * 属性 [ATTENDANCERECORDID]
     *
     */
    @JSONField(name = "attendancerecordid")
    @JsonProperty("attendancerecordid")
    private String attendancerecordid;


    /**
     * 设置 [LNG]
     */
    public void setLng(Double  lng){
        this.lng = lng ;
        this.modify("lng",lng);
    }

    /**
     * 设置 [ATTENDRECORDDETAILNAME]
     */
    public void setAttendrecorddetailname(String  attendrecorddetailname){
        this.attendrecorddetailname = attendrecorddetailname ;
        this.modify("attendrecorddetailname",attendrecorddetailname);
    }

    /**
     * 设置 [SIGNTIME]
     */
    public void setSigntime(Timestamp  signtime){
        this.signtime = signtime ;
        this.modify("signtime",signtime);
    }

    /**
     * 设置 [SIGNLOCATION]
     */
    public void setSignlocation(String  signlocation){
        this.signlocation = signlocation ;
        this.modify("signlocation",signlocation);
    }

    /**
     * 设置 [LAT]
     */
    public void setLat(Double  lat){
        this.lat = lat ;
        this.modify("lat",lat);
    }

    /**
     * 设置 [ATTENDANCERECORDID]
     */
    public void setAttendancerecordid(String  attendancerecordid){
        this.attendancerecordid = attendancerecordid ;
        this.modify("attendancerecordid",attendancerecordid);
    }


}

