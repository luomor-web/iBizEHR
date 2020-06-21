package cn.ibizlab.ehr.core.att.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[考勤记录明细]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ATTENDRECORDDETAIL",resultMap = "AttendRecordDetailResultMap")
public class AttendRecordDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 经度
     */
    @TableField(value = "lng")
    @JSONField(name = "lng")
    @JsonProperty("lng")
    private Double lng;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 考勤记录明细名称
     */
    @TableField(value = "attendrecorddetailname")
    @JSONField(name = "attendrecorddetailname")
    @JsonProperty("attendrecorddetailname")
    private String attendrecorddetailname;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 打卡时间
     */
    @TableField(value = "signtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "signtime" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("signtime")
    private Timestamp signtime;
    /**
     * 打卡地点
     */
    @TableField(value = "signlocation")
    @JSONField(name = "signlocation")
    @JsonProperty("signlocation")
    private String signlocation;
    /**
     * 考勤记录明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "attendrecorddetailid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "attendrecorddetailid")
    @JsonProperty("attendrecorddetailid")
    private String attendrecorddetailid;
    /**
     * 纬度
     */
    @TableField(value = "lat")
    @JSONField(name = "lat")
    @JsonProperty("lat")
    private Double lat;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 考勤记录名称
     */
    @TableField(exist = false)
    @JSONField(name = "attendancerecordname")
    @JsonProperty("attendancerecordname")
    private String attendancerecordname;
    /**
     * 考勤记录标识
     */
    @TableField(value = "attendancerecordid")
    @JSONField(name = "attendancerecordid")
    @JsonProperty("attendancerecordid")
    private String attendancerecordid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.att.domain.AttEndanceRecord attendancerecord;



    /**
     * 设置 [经度]
     */
    public void setLng(Double lng){
        this.lng = lng ;
        this.modify("lng",lng);
    }

    /**
     * 设置 [考勤记录明细名称]
     */
    public void setAttendrecorddetailname(String attendrecorddetailname){
        this.attendrecorddetailname = attendrecorddetailname ;
        this.modify("attendrecorddetailname",attendrecorddetailname);
    }

    /**
     * 设置 [打卡时间]
     */
    public void setSigntime(Timestamp signtime){
        this.signtime = signtime ;
        this.modify("signtime",signtime);
    }

    /**
     * 格式化日期 [打卡时间]
     */
    public String formatSigntime(){
        if (this.signtime == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(signtime);
    }
    /**
     * 设置 [打卡地点]
     */
    public void setSignlocation(String signlocation){
        this.signlocation = signlocation ;
        this.modify("signlocation",signlocation);
    }

    /**
     * 设置 [纬度]
     */
    public void setLat(Double lat){
        this.lat = lat ;
        this.modify("lat",lat);
    }

    /**
     * 设置 [考勤记录标识]
     */
    public void setAttendancerecordid(String attendancerecordid){
        this.attendancerecordid = attendancerecordid ;
        this.modify("attendancerecordid",attendancerecordid);
    }


}


