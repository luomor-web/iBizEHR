package cn.ibizlab.ehr.core.pim.domain;

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
 * 实体[问题收集]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "T_QUESTIONS",resultMap = "PimQuestionsResultMap")
public class PimQuestions extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 提出人
     */
    @TableField(value = "questionman")
    @JSONField(name = "questionman")
    @JsonProperty("questionman")
    private String questionman;
    /**
     * 提出时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 问题页面Url
     */
    @TableField(value = "twurl")
    @JSONField(name = "twurl")
    @JsonProperty("twurl")
    private String twurl;
    /**
     * 紧急程度
     */
    @TableField(value = "jjcd")
    @JSONField(name = "jjcd")
    @JsonProperty("jjcd")
    private String jjcd;
    /**
     * 问题页面代码
     */
    @TableField(value = "ymmc")
    @JSONField(name = "ymmc")
    @JsonProperty("ymmc")
    private String ymmc;
    /**
     * 页面
     */
    @TableField(value = "ym")
    @JSONField(name = "ym")
    @JsonProperty("ym")
    private String ym;
    /**
     * 功能
     */
    @TableField(value = "gn")
    @JSONField(name = "gn")
    @JsonProperty("gn")
    private String gn;
    /**
     * 界面截图
     */
    @TableField(value = "jt")
    @JSONField(name = "jt")
    @JsonProperty("jt")
    private String jt;
    /**
     * 问题反馈
     */
    @TableField(value = "wtfk")
    @JSONField(name = "wtfk")
    @JsonProperty("wtfk")
    private String wtfk;
    /**
     * 联系电话
     */
    @TableField(value = "lxdh")
    @JSONField(name = "lxdh")
    @JsonProperty("lxdh")
    private String lxdh;
    /**
     * 问题描述
     */
    @TableField(value = "wtms")
    @JSONField(name = "wtms")
    @JsonProperty("wtms")
    private String wtms;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 模块
     */
    @TableField(value = "mk")
    @JSONField(name = "mk")
    @JsonProperty("mk")
    private String mk;
    /**
     * 问题
     */
    @TableField(value = "questionsname")
    @JSONField(name = "questionsname")
    @JsonProperty("questionsname")
    private String questionsname;
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
     * 开发者
     */
    @TableField(value = "kfz")
    @JSONField(name = "kfz")
    @JsonProperty("kfz")
    private String kfz;
    /**
     * 提出时间
     */
    @TableField(value = "tcsj")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "tcsj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("tcsj")
    private Timestamp tcsj;
    /**
     * 完成时间
     */
    @TableField(value = "wcsj")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "wcsj" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("wcsj")
    private Timestamp wcsj;
    /**
     * 问题收集标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "questionsid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "questionsid")
    @JsonProperty("questionsid")
    private String questionsid;
    /**
     * 问题状态
     */
    @TableField(value = "wtzt")
    @JSONField(name = "wtzt")
    @JsonProperty("wtzt")
    private String wtzt;
    /**
     * 问题编号
     */
    @TableField(value = "wtbh")
    @JSONField(name = "wtbh")
    @JsonProperty("wtbh")
    private String wtbh;



    /**
     * 设置 [提出人]
     */
    public void setQuestionman(String questionman){
        this.questionman = questionman ;
        this.modify("questionman",questionman);
    }

    /**
     * 设置 [问题页面Url]
     */
    public void setTwurl(String twurl){
        this.twurl = twurl ;
        this.modify("twurl",twurl);
    }

    /**
     * 设置 [紧急程度]
     */
    public void setJjcd(String jjcd){
        this.jjcd = jjcd ;
        this.modify("jjcd",jjcd);
    }

    /**
     * 设置 [问题页面代码]
     */
    public void setYmmc(String ymmc){
        this.ymmc = ymmc ;
        this.modify("ymmc",ymmc);
    }

    /**
     * 设置 [页面]
     */
    public void setYm(String ym){
        this.ym = ym ;
        this.modify("ym",ym);
    }

    /**
     * 设置 [功能]
     */
    public void setGn(String gn){
        this.gn = gn ;
        this.modify("gn",gn);
    }

    /**
     * 设置 [界面截图]
     */
    public void setJt(String jt){
        this.jt = jt ;
        this.modify("jt",jt);
    }

    /**
     * 设置 [问题反馈]
     */
    public void setWtfk(String wtfk){
        this.wtfk = wtfk ;
        this.modify("wtfk",wtfk);
    }

    /**
     * 设置 [联系电话]
     */
    public void setLxdh(String lxdh){
        this.lxdh = lxdh ;
        this.modify("lxdh",lxdh);
    }

    /**
     * 设置 [问题描述]
     */
    public void setWtms(String wtms){
        this.wtms = wtms ;
        this.modify("wtms",wtms);
    }

    /**
     * 设置 [模块]
     */
    public void setMk(String mk){
        this.mk = mk ;
        this.modify("mk",mk);
    }

    /**
     * 设置 [问题]
     */
    public void setQuestionsname(String questionsname){
        this.questionsname = questionsname ;
        this.modify("questionsname",questionsname);
    }

    /**
     * 设置 [开发者]
     */
    public void setKfz(String kfz){
        this.kfz = kfz ;
        this.modify("kfz",kfz);
    }

    /**
     * 设置 [提出时间]
     */
    public void setTcsj(Timestamp tcsj){
        this.tcsj = tcsj ;
        this.modify("tcsj",tcsj);
    }

    /**
     * 格式化日期 [提出时间]
     */
    public String formatTcsj(){
        if (this.tcsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(tcsj);
    }
    /**
     * 设置 [完成时间]
     */
    public void setWcsj(Timestamp wcsj){
        this.wcsj = wcsj ;
        this.modify("wcsj",wcsj);
    }

    /**
     * 格式化日期 [完成时间]
     */
    public String formatWcsj(){
        if (this.wcsj == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(wcsj);
    }
    /**
     * 设置 [问题状态]
     */
    public void setWtzt(String wtzt){
        this.wtzt = wtzt ;
        this.modify("wtzt",wtzt);
    }

    /**
     * 设置 [问题编号]
     */
    public void setWtbh(String wtbh){
        this.wtbh = wtbh ;
        this.modify("wtbh",wtbh);
    }


}


