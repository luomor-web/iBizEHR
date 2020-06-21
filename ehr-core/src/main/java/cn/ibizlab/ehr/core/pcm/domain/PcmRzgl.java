package cn.ibizlab.ehr.core.pcm.domain;

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
 * 实体[任职管理]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMRZGL",resultMap = "PcmRzglResultMap")
public class PcmRzgl extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任职年限的颜色
     */
    @DEField(name = "rznx_color")
    @TableField(value = "rznx_color")
    @JSONField(name = "rznx_color")
    @JsonProperty("rznx_color")
    private String rznxColor;
    /**
     * 部门
     */
    @TableField(value = "ormorgsectorname")
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 任职年龄到期（年）
     */
    @TableField(value = "nldq")
    @JSONField(name = "nldq")
    @JsonProperty("nldq")
    private Integer nldq;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 职级年限的颜色
     */
    @DEField(name = "zjnx_color")
    @TableField(value = "zjnx_color")
    @JSONField(name = "zjnx_color")
    @JsonProperty("zjnx_color")
    private String zjnxColor;
    /**
     * 当前职级
     */
    @TableField(value = "zj")
    @JSONField(name = "zj")
    @JsonProperty("zj")
    private String zj;
    /**
     * 当前职务
     */
    @TableField(value = "dqzjxzw")
    @JSONField(name = "dqzjxzw")
    @JsonProperty("dqzjxzw")
    private String dqzjxzw;
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
     * 组织名称
     */
    @TableField(value = "ormorgname")
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 职务年限
     */
    @TableField(value = "rznx")
    @JSONField(name = "rznx")
    @JsonProperty("rznx")
    private Integer rznx;
    /**
     * 职级年限
     */
    @TableField(value = "zjnx")
    @JSONField(name = "zjnx")
    @JsonProperty("zjnx")
    private Integer zjnx;
    /**
     * 任职管理名称
     */
    @TableField(value = "pcmrzglname")
    @JSONField(name = "pcmrzglname")
    @JsonProperty("pcmrzglname")
    private String pcmrzglname;
    /**
     * 职务日期
     */
    @TableField(value = "zwrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zwrq" , format="yyyy-MM-dd")
    @JsonProperty("zwrq")
    private Timestamp zwrq;
    /**
     * 部门id
     */
    @DEField(preType = DEPredefinedFieldType.ORGSECTORID)
    @TableField(value = "orgsectorid")
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 员工ID
     */
    @TableField(value = "ygid")
    @JSONField(name = "ygid")
    @JsonProperty("ygid")
    private String ygid;
    /**
     * 任职管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmrzglid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmrzglid")
    @JsonProperty("pcmrzglid")
    private String pcmrzglid;
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
     * 员工
     */
    @TableField(value = "ygname")
    @JSONField(name = "ygname")
    @JsonProperty("ygname")
    private String ygname;
    /**
     * 性别
     */
    @TableField(value = "sex")
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;
    /**
     * 职级日期
     */
    @TableField(value = "zjrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zjrq" , format="yyyy-MM-dd")
    @JsonProperty("zjrq")
    private Timestamp zjrq;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 年龄
     */
    @TableField(value = "nl")
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 组织id
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 当前岗位
     */
    @TableField(value = "gw")
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;



    /**
     * 设置 [任职年限的颜色]
     */
    public void setRznxColor(String rznxColor){
        this.rznxColor = rznxColor ;
        this.modify("rznx_color",rznxColor);
    }

    /**
     * 设置 [部门]
     */
    public void setOrmorgsectorname(String ormorgsectorname){
        this.ormorgsectorname = ormorgsectorname ;
        this.modify("ormorgsectorname",ormorgsectorname);
    }

    /**
     * 设置 [任职年龄到期（年）]
     */
    public void setNldq(Integer nldq){
        this.nldq = nldq ;
        this.modify("nldq",nldq);
    }

    /**
     * 设置 [职级年限的颜色]
     */
    public void setZjnxColor(String zjnxColor){
        this.zjnxColor = zjnxColor ;
        this.modify("zjnx_color",zjnxColor);
    }

    /**
     * 设置 [当前职级]
     */
    public void setZj(String zj){
        this.zj = zj ;
        this.modify("zj",zj);
    }

    /**
     * 设置 [当前职务]
     */
    public void setDqzjxzw(String dqzjxzw){
        this.dqzjxzw = dqzjxzw ;
        this.modify("dqzjxzw",dqzjxzw);
    }

    /**
     * 设置 [组织名称]
     */
    public void setOrmorgname(String ormorgname){
        this.ormorgname = ormorgname ;
        this.modify("ormorgname",ormorgname);
    }

    /**
     * 设置 [职务年限]
     */
    public void setRznx(Integer rznx){
        this.rznx = rznx ;
        this.modify("rznx",rznx);
    }

    /**
     * 设置 [职级年限]
     */
    public void setZjnx(Integer zjnx){
        this.zjnx = zjnx ;
        this.modify("zjnx",zjnx);
    }

    /**
     * 设置 [任职管理名称]
     */
    public void setPcmrzglname(String pcmrzglname){
        this.pcmrzglname = pcmrzglname ;
        this.modify("pcmrzglname",pcmrzglname);
    }

    /**
     * 设置 [职务日期]
     */
    public void setZwrq(Timestamp zwrq){
        this.zwrq = zwrq ;
        this.modify("zwrq",zwrq);
    }

    /**
     * 格式化日期 [职务日期]
     */
    public String formatZwrq(){
        if (this.zwrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zwrq);
    }
    /**
     * 设置 [员工ID]
     */
    public void setYgid(String ygid){
        this.ygid = ygid ;
        this.modify("ygid",ygid);
    }

    /**
     * 设置 [员工]
     */
    public void setYgname(String ygname){
        this.ygname = ygname ;
        this.modify("ygname",ygname);
    }

    /**
     * 设置 [性别]
     */
    public void setSex(String sex){
        this.sex = sex ;
        this.modify("sex",sex);
    }

    /**
     * 设置 [职级日期]
     */
    public void setZjrq(Timestamp zjrq){
        this.zjrq = zjrq ;
        this.modify("zjrq",zjrq);
    }

    /**
     * 格式化日期 [职级日期]
     */
    public String formatZjrq(){
        if (this.zjrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(zjrq);
    }
    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [年龄]
     */
    public void setNl(Integer nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [当前岗位]
     */
    public void setGw(String gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }


}


