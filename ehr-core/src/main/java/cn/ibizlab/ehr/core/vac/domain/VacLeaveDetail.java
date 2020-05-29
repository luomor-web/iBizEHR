package cn.ibizlab.ehr.core.vac.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
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


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;


/**
 * 实体[请假明细]
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "T_VACLEAVEDETAIL",resultMap = "VacLeaveDetailResultMap")
public class VacLeaveDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请销假明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "vacleavedetailid",type=IdType.UUID)
    @JSONField(name = "vacleavedetailid")
    @JsonProperty("vacleavedetailid")
    private String vacleavedetailid;
    /**
     * 婚姻状况
     */
    @TableField(value = "hyzk")
    @JSONField(name = "hyzk")
    @JsonProperty("hyzk")
    private String hyzk;
    /**
     * 请销假明细名称
     */
    @TableField(value = "vacleavedetailname")
    @JSONField(name = "vacleavedetailname")
    @JsonProperty("vacleavedetailname")
    private String vacleavedetailname;
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
     * 请假种类
     */
    @TableField(value = "qjzl")
    @JSONField(name = "qjzl")
    @JsonProperty("qjzl")
    private String qjzl;
    /**
     * 实际请假结束
     */
    @TableField(exist = false)
    @JSONField(name = "sjqjjs")
    @JsonProperty("sjqjjs")
    private String sjqjjs;
    /**
     * 计划结束上下午
     */
    @TableField(value = "jhjssxw")
    @JSONField(name = "jhjssxw")
    @JsonProperty("jhjssxw")
    private String jhjssxw;
    /**
     * 计划开始上下午
     */
    @TableField(value = "jhkssxw")
    @JSONField(name = "jhkssxw")
    @JsonProperty("jhkssxw")
    private String jhkssxw;
    /**
     * 假期使用情况
     */
    @TableField(value = "njsy")
    @JSONField(name = "njsy")
    @JsonProperty("njsy")
    private String njsy;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 实际结束时间
     */
    @TableField(value = "sjjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sjjssj" , format="yyyy-MM-dd")
    @JsonProperty("sjjssj")
    private Timestamp sjjssj;
    /**
     * 实际天数
     */
    @TableField(value = "sjts")
    @JSONField(name = "sjts")
    @JsonProperty("sjts")
    private Double sjts;
    /**
     * 探亲类型
     */
    @TableField(value = "tqlx")
    @JSONField(name = "tqlx")
    @JsonProperty("tqlx")
    private String tqlx;
    /**
     * 实际开始时间
     */
    @TableField(value = "sjkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "sjkssj" , format="yyyy-MM-dd")
    @JsonProperty("sjkssj")
    private Timestamp sjkssj;
    /**
     * 附件
     */
    @TableField(value = "fj")
    @JSONField(name = "fj")
    @JsonProperty("fj")
    private String fj;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 实际结束上下午
     */
    @TableField(value = "sjjssxw")
    @JSONField(name = "sjjssxw")
    @JsonProperty("sjjssxw")
    private String sjjssxw;
    /**
     * 计划开始时间
     */
    @TableField(value = "jhkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhkssj" , format="yyyy-MM-dd")
    @JsonProperty("jhkssj")
    private Timestamp jhkssj;
    /**
     * 实际开始上下午
     */
    @TableField(value = "sjkssxw")
    @JSONField(name = "sjkssxw")
    @JsonProperty("sjkssxw")
    private String sjkssxw;
    /**
     * 计划请假开始
     */
    @TableField(exist = false)
    @JSONField(name = "jhqjks")
    @JsonProperty("jhqjks")
    private String jhqjks;
    /**
     * 计划天数
     */
    @TableField(value = "jhts")
    @JSONField(name = "jhts")
    @JsonProperty("jhts")
    private Double jhts;
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
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 实际请假开始
     */
    @TableField(exist = false)
    @JSONField(name = "sjqjks")
    @JsonProperty("sjqjks")
    private String sjqjks;
    /**
     * 计划请假结束
     */
    @TableField(exist = false)
    @JSONField(name = "jhqjjs")
    @JsonProperty("jhqjjs")
    private String jhqjjs;
    /**
     * 温馨提示
     */
    @TableField(value = "tips")
    @JSONField(name = "tips")
    @JsonProperty("tips")
    private String tips;
    /**
     * 计划结束时间
     */
    @TableField(value = "jhjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jhjssj" , format="yyyy-MM-dd")
    @JsonProperty("jhjssj")
    private Timestamp jhjssj;
    /**
     * 部门标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 组织标识
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 请假人员
     */
    @TableField(value = "pimpersonname")
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 请销假管理名称
     */
    @TableField(exist = false)
    @JSONField(name = "vacleavemanagename")
    @JsonProperty("vacleavemanagename")
    private String vacleavemanagename;
    /**
     * 请销假管理标识
     */
    @TableField(value = "vacleavemanageid")
    @JSONField(name = "vacleavemanageid")
    @JsonProperty("vacleavemanageid")
    private String vacleavemanageid;

    /**
     * 请假管理-请假明细
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.vac.domain.VACLEAVEMANAGE vacleavemanage;



    /**
     * 设置 [婚姻状况]
     */
    public void setHyzk(String hyzk){
        this.hyzk = hyzk ;
        this.modify("hyzk",hyzk);
    }
    /**
     * 设置 [请销假明细名称]
     */
    public void setVacleavedetailname(String vacleavedetailname){
        this.vacleavedetailname = vacleavedetailname ;
        this.modify("vacleavedetailname",vacleavedetailname);
    }
    /**
     * 设置 [请假种类]
     */
    public void setQjzl(String qjzl){
        this.qjzl = qjzl ;
        this.modify("qjzl",qjzl);
    }
    /**
     * 设置 [计划结束上下午]
     */
    public void setJhjssxw(String jhjssxw){
        this.jhjssxw = jhjssxw ;
        this.modify("jhjssxw",jhjssxw);
    }
    /**
     * 设置 [计划开始上下午]
     */
    public void setJhkssxw(String jhkssxw){
        this.jhkssxw = jhkssxw ;
        this.modify("jhkssxw",jhkssxw);
    }
    /**
     * 设置 [假期使用情况]
     */
    public void setNjsy(String njsy){
        this.njsy = njsy ;
        this.modify("njsy",njsy);
    }
    /**
     * 设置 [实际结束时间]
     */
    public void setSjjssj(Timestamp sjjssj){
        this.sjjssj = sjjssj ;
        this.modify("sjjssj",sjjssj);
    }
    /**
     * 设置 [实际天数]
     */
    public void setSjts(Double sjts){
        this.sjts = sjts ;
        this.modify("sjts",sjts);
    }
    /**
     * 设置 [探亲类型]
     */
    public void setTqlx(String tqlx){
        this.tqlx = tqlx ;
        this.modify("tqlx",tqlx);
    }
    /**
     * 设置 [实际开始时间]
     */
    public void setSjkssj(Timestamp sjkssj){
        this.sjkssj = sjkssj ;
        this.modify("sjkssj",sjkssj);
    }
    /**
     * 设置 [附件]
     */
    public void setFj(String fj){
        this.fj = fj ;
        this.modify("fj",fj);
    }
    /**
     * 设置 [实际结束上下午]
     */
    public void setSjjssxw(String sjjssxw){
        this.sjjssxw = sjjssxw ;
        this.modify("sjjssxw",sjjssxw);
    }
    /**
     * 设置 [计划开始时间]
     */
    public void setJhkssj(Timestamp jhkssj){
        this.jhkssj = jhkssj ;
        this.modify("jhkssj",jhkssj);
    }
    /**
     * 设置 [实际开始上下午]
     */
    public void setSjkssxw(String sjkssxw){
        this.sjkssxw = sjkssxw ;
        this.modify("sjkssxw",sjkssxw);
    }
    /**
     * 设置 [计划天数]
     */
    public void setJhts(Double jhts){
        this.jhts = jhts ;
        this.modify("jhts",jhts);
    }
    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }
    /**
     * 设置 [温馨提示]
     */
    public void setTips(String tips){
        this.tips = tips ;
        this.modify("tips",tips);
    }
    /**
     * 设置 [计划结束时间]
     */
    public void setJhjssj(Timestamp jhjssj){
        this.jhjssj = jhjssj ;
        this.modify("jhjssj",jhjssj);
    }
    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }
    /**
     * 设置 [请假人员]
     */
    public void setPimpersonname(String pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }
    /**
     * 设置 [请销假管理标识]
     */
    public void setVacleavemanageid(String vacleavemanageid){
        this.vacleavemanageid = vacleavemanageid ;
        this.modify("vacleavemanageid",vacleavemanageid);
    }

}


