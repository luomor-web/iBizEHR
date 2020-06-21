package cn.ibizlab.ehr.core.trm.domain;

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
 * 实体[培训记录]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMTRIANPERSON",resultMap = "TrmTrainPersonResultMap")
public class TrmTrainPerson extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 参培人员
     */
    @TableField(value = "trmtrianpersonname")
    @JSONField(name = "trmtrianpersonname")
    @JsonProperty("trmtrianpersonname")
    private String trmtrianpersonname;
    /**
     * 是否住宿
     */
    @TableField(value = "sfzs")
    @JSONField(name = "sfzs")
    @JsonProperty("sfzs")
    private Integer sfzs;
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
     * 岗位
     */
    @TableField(value = "gw")
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 培训班级
     */
    @TableField(value = "pxbj")
    @JSONField(name = "pxbj")
    @JsonProperty("pxbj")
    private String pxbj;
    /**
     * 培训机构
     */
    @TableField(value = "pxjg")
    @JSONField(name = "pxjg")
    @JsonProperty("pxjg")
    private String pxjg;
    /**
     * 培训课程
     */
    @TableField(value = "pxkc")
    @JSONField(name = "pxkc")
    @JsonProperty("pxkc")
    private String pxkc;
    /**
     * 培训人员标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmtrianpersonid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmtrianpersonid")
    @JsonProperty("trmtrianpersonid")
    private String trmtrianpersonid;
    /**
     * 接送方式
     */
    @TableField(value = "jsfs")
    @JSONField(name = "jsfs")
    @JsonProperty("jsfs")
    private String jsfs;
    /**
     * 分数
     */
    @TableField(value = "fs")
    @JSONField(name = "fs")
    @JsonProperty("fs")
    private Double fs;
    /**
     * 培训开始时间
     */
    @TableField(value = "trainbegin")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "trainbegin" , format="yyyy-MM-dd")
    @JsonProperty("trainbegin")
    private Timestamp trainbegin;
    /**
     * 培训结束时间
     */
    @TableField(value = "trainend")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "trainend" , format="yyyy-MM-dd")
    @JsonProperty("trainend")
    private Timestamp trainend;
    /**
     * 房间号
     */
    @TableField(value = "fjh")
    @JSONField(name = "fjh")
    @JsonProperty("fjh")
    private String fjh;
    /**
     * 培训结果
     */
    @TableField(value = "trainres")
    @JSONField(name = "trainres")
    @JsonProperty("trainres")
    private String trainres;
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
     * 逻辑有效标志
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1" , logicdelval="0")
    @TableLogic(value= "1",delval="0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 计划项编码
     */
    @TableField(exist = false)
    @JSONField(name = "jhxbm")
    @JsonProperty("jhxbm")
    private String jhxbm;
    /**
     * 培训结束时间
     */
    @TableField(value = "pxjssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxjssj" , format="yyyy-MM-dd")
    @JsonProperty("pxjssj")
    private Timestamp pxjssj;
    /**
     * 职务
     */
    @TableField(value = "zw")
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 部门
     */
    @TableField(value = "bm")
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 培训讲师
     */
    @TableField(exist = false)
    @JSONField(name = "trmtrainteachername")
    @JsonProperty("trmtrainteachername")
    private String trmtrainteachername;
    /**
     * 联系电话
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 单位
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 性别
     */
    @TableField(value = "xb")
    @JSONField(name = "xb")
    @JsonProperty("xb")
    private String xb;
    /**
     * 培训机构
     */
    @TableField(value = "trmtrainagencyname")
    @JSONField(name = "trmtrainagencyname")
    @JsonProperty("trmtrainagencyname")
    private String trmtrainagencyname;
    /**
     * 员工姓名
     */
    @TableField(value = "pimpersonname")
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 培训课程
     */
    @TableField(value = "trmtraincoursename")
    @JSONField(name = "trmtraincoursename")
    @JsonProperty("trmtraincoursename")
    private String trmtraincoursename;
    /**
     * 班主任
     */
    @TableField(exist = false)
    @JSONField(name = "bzr")
    @JsonProperty("bzr")
    private String bzr;
    /**
     * 员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 培训计划项名称
     */
    @TableField(value = "trmtrainplantermname")
    @JSONField(name = "trmtrainplantermname")
    @JsonProperty("trmtrainplantermname")
    private String trmtrainplantermname;
    /**
     * 培训开始时间
     */
    @TableField(value = "pxkssj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "pxkssj" , format="yyyy-MM-dd")
    @JsonProperty("pxkssj")
    private Timestamp pxkssj;
    /**
     * 年龄
     */
    @TableField(value = "nj")
    @JSONField(name = "nj")
    @JsonProperty("nj")
    private Integer nj;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 培训计划项标识
     */
    @TableField(value = "trmtrainplantermid")
    @JSONField(name = "trmtrainplantermid")
    @JsonProperty("trmtrainplantermid")
    private String trmtrainplantermid;

    /**
     * 员工
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 培训计划项
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm trmtrainplanterm;



    /**
     * 设置 [参培人员]
     */
    public void setTrmtrianpersonname(String trmtrianpersonname){
        this.trmtrianpersonname = trmtrianpersonname ;
        this.modify("trmtrianpersonname",trmtrianpersonname);
    }

    /**
     * 设置 [是否住宿]
     */
    public void setSfzs(Integer sfzs){
        this.sfzs = sfzs ;
        this.modify("sfzs",sfzs);
    }

    /**
     * 设置 [岗位]
     */
    public void setGw(String gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [培训班级]
     */
    public void setPxbj(String pxbj){
        this.pxbj = pxbj ;
        this.modify("pxbj",pxbj);
    }

    /**
     * 设置 [培训机构]
     */
    public void setPxjg(String pxjg){
        this.pxjg = pxjg ;
        this.modify("pxjg",pxjg);
    }

    /**
     * 设置 [培训课程]
     */
    public void setPxkc(String pxkc){
        this.pxkc = pxkc ;
        this.modify("pxkc",pxkc);
    }

    /**
     * 设置 [接送方式]
     */
    public void setJsfs(String jsfs){
        this.jsfs = jsfs ;
        this.modify("jsfs",jsfs);
    }

    /**
     * 设置 [分数]
     */
    public void setFs(Double fs){
        this.fs = fs ;
        this.modify("fs",fs);
    }

    /**
     * 设置 [培训开始时间]
     */
    public void setTrainbegin(Timestamp trainbegin){
        this.trainbegin = trainbegin ;
        this.modify("trainbegin",trainbegin);
    }

    /**
     * 格式化日期 [培训开始时间]
     */
    public String formatTrainbegin(){
        if (this.trainbegin == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(trainbegin);
    }
    /**
     * 设置 [培训结束时间]
     */
    public void setTrainend(Timestamp trainend){
        this.trainend = trainend ;
        this.modify("trainend",trainend);
    }

    /**
     * 格式化日期 [培训结束时间]
     */
    public String formatTrainend(){
        if (this.trainend == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(trainend);
    }
    /**
     * 设置 [房间号]
     */
    public void setFjh(String fjh){
        this.fjh = fjh ;
        this.modify("fjh",fjh);
    }

    /**
     * 设置 [培训结果]
     */
    public void setTrainres(String trainres){
        this.trainres = trainres ;
        this.modify("trainres",trainres);
    }

    /**
     * 设置 [培训结束时间]
     */
    public void setPxjssj(Timestamp pxjssj){
        this.pxjssj = pxjssj ;
        this.modify("pxjssj",pxjssj);
    }

    /**
     * 格式化日期 [培训结束时间]
     */
    public String formatPxjssj(){
        if (this.pxjssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(pxjssj);
    }
    /**
     * 设置 [职务]
     */
    public void setZw(String zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [部门]
     */
    public void setBm(String bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [联系电话]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [单位]
     */
    public void setZz(String zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [性别]
     */
    public void setXb(String xb){
        this.xb = xb ;
        this.modify("xb",xb);
    }

    /**
     * 设置 [培训机构]
     */
    public void setTrmtrainagencyname(String trmtrainagencyname){
        this.trmtrainagencyname = trmtrainagencyname ;
        this.modify("trmtrainagencyname",trmtrainagencyname);
    }

    /**
     * 设置 [员工姓名]
     */
    public void setPimpersonname(String pimpersonname){
        this.pimpersonname = pimpersonname ;
        this.modify("pimpersonname",pimpersonname);
    }

    /**
     * 设置 [培训课程]
     */
    public void setTrmtraincoursename(String trmtraincoursename){
        this.trmtraincoursename = trmtraincoursename ;
        this.modify("trmtraincoursename",trmtraincoursename);
    }

    /**
     * 设置 [员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [培训计划项名称]
     */
    public void setTrmtrainplantermname(String trmtrainplantermname){
        this.trmtrainplantermname = trmtrainplantermname ;
        this.modify("trmtrainplantermname",trmtrainplantermname);
    }

    /**
     * 设置 [培训开始时间]
     */
    public void setPxkssj(Timestamp pxkssj){
        this.pxkssj = pxkssj ;
        this.modify("pxkssj",pxkssj);
    }

    /**
     * 格式化日期 [培训开始时间]
     */
    public String formatPxkssj(){
        if (this.pxkssj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(pxkssj);
    }
    /**
     * 设置 [年龄]
     */
    public void setNj(Integer nj){
        this.nj = nj ;
        this.modify("nj",nj);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [培训计划项标识]
     */
    public void setTrmtrainplantermid(String trmtrainplantermid){
        this.trmtrainplantermid = trmtrainplantermid ;
        this.modify("trmtrainplantermid",trmtrainplantermid);
    }


}


