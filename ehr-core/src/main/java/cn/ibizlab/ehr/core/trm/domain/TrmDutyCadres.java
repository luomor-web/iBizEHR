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
 * 实体[优秀年轻干部梯队]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_TRMDUTYCADRES",resultMap = "TrmDutyCadresResultMap")
public class TrmDutyCadres extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 最近一次绩效考核成绩
     */
    @TableField(value = "khcj")
    @JSONField(name = "khcj")
    @JsonProperty("khcj")
    private String khcj;
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
     * 产生方式
     */
    @TableField(value = "cstype")
    @JSONField(name = "cstype")
    @JsonProperty("cstype")
    private String cstype;
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
     * 具体原因
     */
    @TableField(value = "jtyy")
    @JSONField(name = "jtyy")
    @JsonProperty("jtyy")
    private String jtyy;
    /**
     * 截止日期
     */
    @TableField(value = "jsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "jsrq" , format="yyyy-MM-dd")
    @JsonProperty("jsrq")
    private Timestamp jsrq;
    /**
     * 第二轮投票数
     */
    @TableField(value = "sjtpnum")
    @JSONField(name = "sjtpnum")
    @JsonProperty("sjtpnum")
    private Integer sjtpnum;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 人数
     */
    @TableField(value = "rs")
    @JSONField(name = "rs")
    @JsonProperty("rs")
    private Integer rs;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
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
     * 职务优秀青年干部管理名称
     */
    @TableField(value = "trmdutycadresname")
    @JSONField(name = "trmdutycadresname")
    @JsonProperty("trmdutycadresname")
    private String trmdutycadresname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 剩余天数
     */
    @TableField(exist = false)
    @JSONField(name = "syts")
    @JsonProperty("syts")
    private Integer syts;
    /**
     * 退出原因
     */
    @TableField(value = "tcyy")
    @JSONField(name = "tcyy")
    @JsonProperty("tcyy")
    private String tcyy;
    /**
     * 人员列表
     */
    @TableField(value = "rylb")
    @JSONField(name = "rylb")
    @JsonProperty("rylb")
    private String rylb;
    /**
     * 拟任岗位
     */
    @TableField(value = "xgw")
    @JSONField(name = "xgw")
    @JsonProperty("xgw")
    private String xgw;
    /**
     * 年度
     */
    @TableField(value = "year")
    @JSONField(name = "year")
    @JsonProperty("year")
    private String year;
    /**
     * 职务优秀青年干部管理标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "trmdutycadresid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trmdutycadresid")
    @JsonProperty("trmdutycadresid")
    private String trmdutycadresid;
    /**
     * 起始日期
     */
    @TableField(value = "qsrq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "qsrq" , format="yyyy-MM-dd")
    @JsonProperty("qsrq")
    private Timestamp qsrq;
    /**
     * 状态
     */
    @DEField(defaultValue = "10")
    @TableField(value = "status")
    @JSONField(name = "status")
    @JsonProperty("status")
    private String status;
    /**
     * 现任职务年限
     */
    @TableField(exist = false)
    @JSONField(name = "zwnx")
    @JsonProperty("zwnx")
    private Double zwnx;
    /**
     * 最近一次绩效考核成绩（作废）
     */
    @TableField(value = "zjycjxkhcj")
    @JSONField(name = "zjycjxkhcj")
    @JsonProperty("zjycjxkhcj")
    private Double zjycjxkhcj;
    /**
     * 组织ID
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 第一轮投票数
     */
    @TableField(value = "tpnum")
    @JSONField(name = "tpnum")
    @JsonProperty("tpnum")
    private Integer tpnum;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname")
    @JsonProperty("ormorgname")
    private String ormorgname;
    /**
     * 领导人
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 当前部门/项目
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname2")
    @JsonProperty("ormorgsectorname2")
    private String ormorgsectorname2;
    /**
     * 现任职级
     */
    @TableField(exist = false)
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;
    /**
     * 职务日期
     */
    @TableField(exist = false)
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "zwrq" , format="yyyy-MM-dd")
    @JsonProperty("zwrq")
    private Timestamp zwrq;
    /**
     * 拟任职级
     */
    @TableField(exist = false)
    @JSONField(name = "ormrankname")
    @JsonProperty("ormrankname")
    private String ormrankname;
    /**
     * 当前组织
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgname2")
    @JsonProperty("ormorgname2")
    private String ormorgname2;
    /**
     * 岗位(停用)
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 组织
     */
    @TableField(exist = false)
    @JSONField(name = "zzdzs")
    @JsonProperty("zzdzs")
    private String zzdzs;
    /**
     * 优秀年轻干部
     */
    @TableField(value = "pimpersonname2")
    @JSONField(name = "pimpersonname2")
    @JsonProperty("pimpersonname2")
    private String pimpersonname2;
    /**
     * 现任岗位
     */
    @TableField(exist = false)
    @JSONField(name = "gw")
    @JsonProperty("gw")
    private String gw;
    /**
     * 现任职务
     */
    @TableField(exist = false)
    @JSONField(name = "zw")
    @JsonProperty("zw")
    private String zw;
    /**
     * 拟任部门
     */
    @TableField(exist = false)
    @JSONField(name = "ormorgsectorname")
    @JsonProperty("ormorgsectorname")
    private String ormorgsectorname;
    /**
     * 员工编号
     */
    @TableField(exist = false)
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 拟任职务
     */
    @TableField(exist = false)
    @JSONField(name = "ormdutyname")
    @JsonProperty("ormdutyname")
    private String ormdutyname;
    /**
     * 岗位集标识
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid2")
    @JSONField(name = "pimpersonid2")
    @JsonProperty("pimpersonid2")
    private String pimpersonid2;
    /**
     * 职级标识
     */
    @TableField(value = "ormrankid")
    @JSONField(name = "ormrankid")
    @JsonProperty("ormrankid")
    private String ormrankid;
    /**
     * 职务管理标识
     */
    @TableField(value = "ormdutyid")
    @JSONField(name = "ormdutyid")
    @JsonProperty("ormdutyid")
    private String ormdutyid;
    /**
     * 人员信息标识
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 部门标识
     */
    @TableField(value = "ormorgsectorid")
    @JSONField(name = "ormorgsectorid")
    @JsonProperty("ormorgsectorid")
    private String ormorgsectorid;
    /**
     * 组织标识
     */
    @TableField(value = "ormorgid")
    @JSONField(name = "ormorgid")
    @JsonProperty("ormorgid")
    private String ormorgid;

    /**
     * 职务
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmDuty ormduty;

    /**
     * 部门
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrgsector ormorgsector;

    /**
     * 组织
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmOrg ormorg;

    /**
     * 岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmPost ormpost;

    /**
     * 职级
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.OrmRank ormrank;

    /**
     * 领导人
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;

    /**
     * 年轻干部姓名
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson2;



    /**
     * 设置 [最近一次绩效考核成绩]
     */
    public void setKhcj(String khcj){
        this.khcj = khcj ;
        this.modify("khcj",khcj);
    }

    /**
     * 设置 [产生方式]
     */
    public void setCstype(String cstype){
        this.cstype = cstype ;
        this.modify("cstype",cstype);
    }

    /**
     * 设置 [具体原因]
     */
    public void setJtyy(String jtyy){
        this.jtyy = jtyy ;
        this.modify("jtyy",jtyy);
    }

    /**
     * 设置 [截止日期]
     */
    public void setJsrq(Timestamp jsrq){
        this.jsrq = jsrq ;
        this.modify("jsrq",jsrq);
    }

    /**
     * 格式化日期 [截止日期]
     */
    public String formatJsrq(){
        if (this.jsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(jsrq);
    }
    /**
     * 设置 [第二轮投票数]
     */
    public void setSjtpnum(Integer sjtpnum){
        this.sjtpnum = sjtpnum ;
        this.modify("sjtpnum",sjtpnum);
    }

    /**
     * 设置 [人数]
     */
    public void setRs(Integer rs){
        this.rs = rs ;
        this.modify("rs",rs);
    }

    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }

    /**
     * 设置 [职务优秀青年干部管理名称]
     */
    public void setTrmdutycadresname(String trmdutycadresname){
        this.trmdutycadresname = trmdutycadresname ;
        this.modify("trmdutycadresname",trmdutycadresname);
    }

    /**
     * 设置 [退出原因]
     */
    public void setTcyy(String tcyy){
        this.tcyy = tcyy ;
        this.modify("tcyy",tcyy);
    }

    /**
     * 设置 [人员列表]
     */
    public void setRylb(String rylb){
        this.rylb = rylb ;
        this.modify("rylb",rylb);
    }

    /**
     * 设置 [拟任岗位]
     */
    public void setXgw(String xgw){
        this.xgw = xgw ;
        this.modify("xgw",xgw);
    }

    /**
     * 设置 [年度]
     */
    public void setYear(String year){
        this.year = year ;
        this.modify("year",year);
    }

    /**
     * 设置 [起始日期]
     */
    public void setQsrq(Timestamp qsrq){
        this.qsrq = qsrq ;
        this.modify("qsrq",qsrq);
    }

    /**
     * 格式化日期 [起始日期]
     */
    public String formatQsrq(){
        if (this.qsrq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(qsrq);
    }
    /**
     * 设置 [状态]
     */
    public void setStatus(String status){
        this.status = status ;
        this.modify("status",status);
    }

    /**
     * 设置 [最近一次绩效考核成绩（作废）]
     */
    public void setZjycjxkhcj(Double zjycjxkhcj){
        this.zjycjxkhcj = zjycjxkhcj ;
        this.modify("zjycjxkhcj",zjycjxkhcj);
    }

    /**
     * 设置 [第一轮投票数]
     */
    public void setTpnum(Integer tpnum){
        this.tpnum = tpnum ;
        this.modify("tpnum",tpnum);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [优秀年轻干部]
     */
    public void setPimpersonname2(String pimpersonname2){
        this.pimpersonname2 = pimpersonname2 ;
        this.modify("pimpersonname2",pimpersonname2);
    }

    /**
     * 设置 [岗位集标识]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid2(String pimpersonid2){
        this.pimpersonid2 = pimpersonid2 ;
        this.modify("pimpersonid2",pimpersonid2);
    }

    /**
     * 设置 [职级标识]
     */
    public void setOrmrankid(String ormrankid){
        this.ormrankid = ormrankid ;
        this.modify("ormrankid",ormrankid);
    }

    /**
     * 设置 [职务管理标识]
     */
    public void setOrmdutyid(String ormdutyid){
        this.ormdutyid = ormdutyid ;
        this.modify("ormdutyid",ormdutyid);
    }

    /**
     * 设置 [人员信息标识]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [部门标识]
     */
    public void setOrmorgsectorid(String ormorgsectorid){
        this.ormorgsectorid = ormorgsectorid ;
        this.modify("ormorgsectorid",ormorgsectorid);
    }

    /**
     * 设置 [组织标识]
     */
    public void setOrmorgid(String ormorgid){
        this.ormorgid = ormorgid ;
        this.modify("ormorgid",ormorgid);
    }


}


