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
 * 实体[员工需求填报]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMSTAFF",resultMap = "TrmStaffResultMap")
public class TrmStaff extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 员工需求调查表名称
     */
    @TableField(value = "trmstaffname")
    @JSONField(name = "trmstaffname")
    @JsonProperty("trmstaffname")
    private String trmstaffname;
    /**
     * 需求来源类型
     */
    @TableField(value = "xqlylx")
    @JSONField(name = "xqlylx")
    @JsonProperty("xqlylx")
    private String xqlylx;
    /**
     * 审批方式
     */
    @TableField(value = "spfs")
    @JSONField(name = "spfs")
    @JsonProperty("spfs")
    private String spfs;
    /**
     * 填单日期
     */
    @TableField(value = "tdrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tdrq" , format="yyyy-MM-dd")
    @JsonProperty("tdrq")
    private Timestamp tdrq;
    /**
     * 流程类型
     */
    @TableField(value = "lclx")
    @JSONField(name = "lclx")
    @JsonProperty("lclx")
    private String lclx;
    /**
     * 需求单编码
     */
    @TableField(value = "xqdbma")
    @JSONField(name = "xqdbma")
    @JsonProperty("xqdbma")
    private String xqdbma;
    /**
     * 职务
     */
    @TableField(value = "zw")
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 工作职责
     */
    @TableField(value = "gzzz")
    @JSONField(name = "gzzz")
    @JsonProperty("gzzz")
    private String gzzz;
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
     * 岗位
     */
    @TableField(value = "gw")
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 员工需求调查表标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmstaffid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmstaffid")
    @JsonProperty("trmstaffid")
    private String trmstaffid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 学历
     */
    @TableField(value = "xl")
    @JSONField(name = "xl")
    @JsonProperty("xl")
    private String xl;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname2")
    @JsonProperty("pimpersonname2")
    private String pimpersonname2;
    /**
     * 员工姓名
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 组织名称
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 部门
     */
    @TableField(exist = false)
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 公司
     */
    @TableField(exist = false)
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid2")
    @JSONField(name = "pimpersonid2")
    @JsonProperty("pimpersonid2")
    private String pimpersonid2;

    /**
     * 填单公司
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 姓名
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 填单人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson2;



    /**
     * 设置 [员工需求调查表名称]
     */
    public void setTrmstaffname(String trmstaffname){
        this.trmstaffname = trmstaffname ;
        this.modify("trmstaffname",trmstaffname);
    }

    /**
     * 设置 [需求来源类型]
     */
    public void setXqlylx(String xqlylx){
        this.xqlylx = xqlylx ;
        this.modify("xqlylx",xqlylx);
    }

    /**
     * 设置 [审批方式]
     */
    public void setSpfs(String spfs){
        this.spfs = spfs ;
        this.modify("spfs",spfs);
    }

    /**
     * 设置 [填单日期]
     */
    public void setTdrq(Timestamp tdrq){
        this.tdrq = tdrq ;
        this.modify("tdrq",tdrq);
    }

    /**
     * 格式化日期 [填单日期]
     */
    public String formatTdrq(){
        if (this.tdrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(tdrq);
    }
    /**
     * 设置 [流程类型]
     */
    public void setLclx(String lclx){
        this.lclx = lclx ;
        this.modify("lclx",lclx);
    }

    /**
     * 设置 [需求单编码]
     */
    public void setXqdbma(String xqdbma){
        this.xqdbma = xqdbma ;
        this.modify("xqdbma",xqdbma);
    }

    /**
     * 设置 [职务]
     */
    public void setZw(String zw){
        this.zw = zw ;
        this.modify("zw",zw);
    }

    /**
     * 设置 [工作职责]
     */
    public void setGzzz(String gzzz){
        this.gzzz = gzzz ;
        this.modify("gzzz",gzzz);
    }

    /**
     * 设置 [岗位]
     */
    public void setGw(String gw){
        this.gw = gw ;
        this.modify("gw",gw);
    }

    /**
     * 设置 [学历]
     */
    public void setXl(String xl){
        this.xl = xl ;
        this.modify("xl",xl);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid2(String pimpersonid2){
        this.pimpersonid2 = pimpersonid2 ;
        this.modify("pimpersonid2",pimpersonid2);
    }


}


