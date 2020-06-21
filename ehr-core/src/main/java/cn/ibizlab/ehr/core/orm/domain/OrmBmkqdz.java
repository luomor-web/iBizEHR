package cn.ibizlab.ehr.core.orm.domain;

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
 * 实体[部门地址维护]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_ORMBMKQDZ",resultMap = "OrmBmkqdzResultMap")
public class OrmBmkqdz extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织地址ID
     */
    @TableField(value = "ormorgdzid")
    @JSONField(name = "ormorgdzid")
    @JsonProperty("ormorgdzid")
    private String ormorgdzid;
    /**
     * 部门地址
     */
    @TableField(value = "ormbmkqdzname")
    @JSONField(name = "ormbmkqdzname")
    @JsonProperty("ormbmkqdzname")
    private String ormbmkqdzname;
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
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 部门地址维护标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormbmkqdzid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "ormbmkqdzid")
    @JsonProperty("ormbmkqdzid")
    private String ormbmkqdzid;
    /**
     * 经度
     */
    @TableField(value = "lng")
    @JSONField(name = "lng")
    @JsonProperty("lng")
    private Double lng;
    /**
     * 默认考勤地址
     */
    @TableField(value = "sfmrkqdz")
    @JSONField(name = "sfmrkqdz")
    @JsonProperty("sfmrkqdz")
    private String sfmrkqdz;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 纬度
     */
    @TableField(value = "lat")
    @JSONField(name = "lat")
    @JsonProperty("lat")
    private Double lat;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 部门ID
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 考勤范围
     */
    @TableField(value = "attendancerange")
    @JSONField(name = "attendancerange")
    @JsonProperty("attendancerange")
    private Integer attendancerange;

    /**
     * 部门考勤地址
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;



    /**
     * 设置 [组织地址ID]
     */
    public void setOrmorgdzid(String ormorgdzid){
        this.ormorgdzid = ormorgdzid ;
        this.modify("ormorgdzid",ormorgdzid);
    }

    /**
     * 设置 [部门地址]
     */
    public void setOrmbmkqdzname(String ormbmkqdzname){
        this.ormbmkqdzname = ormbmkqdzname ;
        this.modify("ormbmkqdzname",ormbmkqdzname);
    }

    /**
     * 设置 [经度]
     */
    public void setLng(Double lng){
        this.lng = lng ;
        this.modify("lng",lng);
    }

    /**
     * 设置 [默认考勤地址]
     */
    public void setSfmrkqdz(String sfmrkqdz){
        this.sfmrkqdz = sfmrkqdz ;
        this.modify("sfmrkqdz",sfmrkqdz);
    }

    /**
     * 设置 [纬度]
     */
    public void setLat(Double lat){
        this.lat = lat ;
        this.modify("lat",lat);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [部门ID]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [考勤范围]
     */
    public void setAttendancerange(Integer attendancerange){
        this.attendancerange = attendancerange ;
        this.modify("attendancerange",attendancerange);
    }


}


