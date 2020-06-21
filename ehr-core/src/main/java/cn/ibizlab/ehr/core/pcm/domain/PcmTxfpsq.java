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
 * 实体[退休返聘申请]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_PCMTXFPSQ",resultMap = "PcmTxfpsqResultMap")
public class PcmTxfpsq extends EntityMP implements Serializable {

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
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 是否审核完成
     */
    @TableField(value = "finished")
    @JSONField(name = "finished")
    @JsonProperty("finished")
    private Integer finished;
    /**
     * 操作人ID
     */
    @TableField(value = "czrid")
    @JSONField(name = "czrid")
    @JsonProperty("czrid")
    private String czrid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 权限部门标志
     */
    @TableField(exist = false)
    @JSONField(name = "orgsectorid")
    @JsonProperty("orgsectorid")
    private String orgsectorid;
    /**
     * 审核状态
     */
    @TableField(value = "checkstatus")
    @JSONField(name = "checkstatus")
    @JsonProperty("checkstatus")
    private String checkstatus;
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
     * 操作人
     */
    @TableField(value = "czr")
    @JSONField(name = "czr")
    @JsonProperty("czr")
    private String czr;
    /**
     * 权限控制组织id
     */
    @TableField(exist = false)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 退休返聘申请标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "pcmtxfpsqid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "pcmtxfpsqid")
    @JsonProperty("pcmtxfpsqid")
    private String pcmtxfpsqid;
    /**
     * 返聘生效时间
     */
    @TableField(value = "fpsxsj")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "fpsxsj" , format="yyyy-MM-dd")
    @JsonProperty("fpsxsj")
    private Timestamp fpsxsj;
    /**
     * 标题
     */
    @TableField(value = "pcmtxfpsqname")
    @JSONField(name = "pcmtxfpsqname")
    @JsonProperty("pcmtxfpsqname")
    private String pcmtxfpsqname;
    /**
     * 备注
     */
    @TableField(value = "bz")
    @JSONField(name = "bz")
    @JsonProperty("bz")
    private String bz;
    /**
     * 退休前组织
     */
    @TableField(value = "zz")
    @JSONField(name = "zz")
    @JsonProperty("zz")
    private String zz;
    /**
     * 退休员工
     */
    @TableField(exist = false)
    @JSONField(name = "pimpersonname")
    @JsonProperty("pimpersonname")
    private String pimpersonname;
    /**
     * 退休前职务
     */
    @TableField(value = "yzw")
    @JSONField(name = "yzw")
    @JsonProperty("yzw")
    private String yzw;
    /**
     * 新员工编号
     */
    @TableField(value = "xygbh")
    @JSONField(name = "xygbh")
    @JsonProperty("xygbh")
    private String xygbh;
    /**
     * 年龄
     */
    @TableField(value = "nl")
    @JSONField(name = "nl")
    @JsonProperty("nl")
    private Integer nl;
    /**
     * 部门标志
     */
    @TableField(value = "bmid")
    @JSONField(name = "bmid")
    @JsonProperty("bmid")
    private String bmid;
    /**
     * 原员工编号
     */
    @TableField(value = "ygbh")
    @JSONField(name = "ygbh")
    @JsonProperty("ygbh")
    private String ygbh;
    /**
     * 通讯地址
     */
    @TableField(value = "postaladdress")
    @JSONField(name = "postaladdress")
    @JsonProperty("postaladdress")
    private String postaladdress;
    /**
     * 退休前岗位
     */
    @TableField(value = "ygw")
    @JSONField(name = "ygw")
    @JsonProperty("ygw")
    private String ygw;
    /**
     * 退休前职级
     */
    @TableField(value = "rank")
    @JSONField(name = "rank")
    @JsonProperty("rank")
    private String rank;
    /**
     * 组织id
     */
    @TableField(value = "zzid")
    @JSONField(name = "zzid")
    @JsonProperty("zzid")
    private String zzid;
    /**
     * 退休时间
     */
    @TableField(value = "txdq")
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "txdq" , format="yyyy-MM-dd")
    @JsonProperty("txdq")
    private Timestamp txdq;
    /**
     * 联系电话
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 退休前部门
     */
    @TableField(value = "bm")
    @JSONField(name = "bm")
    @JsonProperty("bm")
    private String bm;
    /**
     * 退休员工ID
     */
    @TableField(value = "pimpersonid")
    @JSONField(name = "pimpersonid")
    @JsonProperty("pimpersonid")
    private String pimpersonid;
    /**
     * 应聘者ID
     */
    @TableField(value = "pcmprofileid")
    @JSONField(name = "pcmprofileid")
    @JsonProperty("pcmprofileid")
    private String pcmprofileid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pcm.domain.PcmProfile pcmprofile;

    /**
     * 退休员工
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson;



    /**
     * 设置 [是否审核完成]
     */
    public void setFinished(Integer finished){
        this.finished = finished ;
        this.modify("finished",finished);
    }

    /**
     * 设置 [操作人ID]
     */
    public void setCzrid(String czrid){
        this.czrid = czrid ;
        this.modify("czrid",czrid);
    }

    /**
     * 设置 [审核状态]
     */
    public void setCheckstatus(String checkstatus){
        this.checkstatus = checkstatus ;
        this.modify("checkstatus",checkstatus);
    }

    /**
     * 设置 [操作人]
     */
    public void setCzr(String czr){
        this.czr = czr ;
        this.modify("czr",czr);
    }

    /**
     * 设置 [返聘生效时间]
     */
    public void setFpsxsj(Timestamp fpsxsj){
        this.fpsxsj = fpsxsj ;
        this.modify("fpsxsj",fpsxsj);
    }

    /**
     * 格式化日期 [返聘生效时间]
     */
    public String formatFpsxsj(){
        if (this.fpsxsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fpsxsj);
    }
    /**
     * 设置 [标题]
     */
    public void setPcmtxfpsqname(String pcmtxfpsqname){
        this.pcmtxfpsqname = pcmtxfpsqname ;
        this.modify("pcmtxfpsqname",pcmtxfpsqname);
    }

    /**
     * 设置 [备注]
     */
    public void setBz(String bz){
        this.bz = bz ;
        this.modify("bz",bz);
    }

    /**
     * 设置 [退休前组织]
     */
    public void setZz(String zz){
        this.zz = zz ;
        this.modify("zz",zz);
    }

    /**
     * 设置 [退休前职务]
     */
    public void setYzw(String yzw){
        this.yzw = yzw ;
        this.modify("yzw",yzw);
    }

    /**
     * 设置 [新员工编号]
     */
    public void setXygbh(String xygbh){
        this.xygbh = xygbh ;
        this.modify("xygbh",xygbh);
    }

    /**
     * 设置 [年龄]
     */
    public void setNl(Integer nl){
        this.nl = nl ;
        this.modify("nl",nl);
    }

    /**
     * 设置 [部门标志]
     */
    public void setBmid(String bmid){
        this.bmid = bmid ;
        this.modify("bmid",bmid);
    }

    /**
     * 设置 [原员工编号]
     */
    public void setYgbh(String ygbh){
        this.ygbh = ygbh ;
        this.modify("ygbh",ygbh);
    }

    /**
     * 设置 [通讯地址]
     */
    public void setPostaladdress(String postaladdress){
        this.postaladdress = postaladdress ;
        this.modify("postaladdress",postaladdress);
    }

    /**
     * 设置 [退休前岗位]
     */
    public void setYgw(String ygw){
        this.ygw = ygw ;
        this.modify("ygw",ygw);
    }

    /**
     * 设置 [退休前职级]
     */
    public void setRank(String rank){
        this.rank = rank ;
        this.modify("rank",rank);
    }

    /**
     * 设置 [组织id]
     */
    public void setZzid(String zzid){
        this.zzid = zzid ;
        this.modify("zzid",zzid);
    }

    /**
     * 设置 [退休时间]
     */
    public void setTxdq(Timestamp txdq){
        this.txdq = txdq ;
        this.modify("txdq",txdq);
    }

    /**
     * 格式化日期 [退休时间]
     */
    public String formatTxdq(){
        if (this.txdq == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(txdq);
    }
    /**
     * 设置 [联系电话]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [退休前部门]
     */
    public void setBm(String bm){
        this.bm = bm ;
        this.modify("bm",bm);
    }

    /**
     * 设置 [退休员工ID]
     */
    public void setPimpersonid(String pimpersonid){
        this.pimpersonid = pimpersonid ;
        this.modify("pimpersonid",pimpersonid);
    }

    /**
     * 设置 [应聘者ID]
     */
    public void setPcmprofileid(String pcmprofileid){
        this.pcmprofileid = pcmprofileid ;
        this.modify("pcmprofileid",pcmprofileid);
    }


}


