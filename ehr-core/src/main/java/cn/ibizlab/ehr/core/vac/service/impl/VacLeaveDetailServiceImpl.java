package cn.ibizlab.ehr.core.vac.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.math.BigInteger;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.ehr.core.vac.domain.VacLeaveDetail;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveDetailSearchContext;
import cn.ibizlab.ehr.core.vac.service.IVacLeaveDetailService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.vac.mapper.VacLeaveDetailMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[请假明细] 服务对象接口实现
 */
@Slf4j
@Service("VacLeaveDetailServiceImpl")
public class VacLeaveDetailServiceImpl extends ServiceImpl<VacLeaveDetailMapper, VacLeaveDetail> implements IVacLeaveDetailService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.IVacUseNxjmxService vacusenxjmxService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPimPersonService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result=removeById(key);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public boolean create(VacLeaveDetail et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavedetailid()),et);
        return true;
    }

    @Override
    public void createBatch(List<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(VacLeaveDetail et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("vacleavedetailid",et.getVacleavedetailid())))
            return false;
        CachedBeanCopier.copy(get(et.getVacleavedetailid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.impl.AttEndenceSetupServiceImpl attEndenceSetupService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.att.service.impl.AttEndanceSettingsServiceImpl attEndenceSettingService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.impl.VacLeaveTipsServiceImpl vacLeaveTipsService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.vac.service.impl.VacLeaceTypeServiceImpl vacLeaceTypeService;
    
    @Override
    @Transactional
    public VacLeaveDetail getNianJia(VacLeaveDetail et) {
        //获取请假人员id  
        String pimpersonid = et.getPimpersonid();
//    	if(StringUtils.isEmpty(pimpersonid)) {
//    		throw new Exception("请添加请假人员!");
//    	}
        cn.ibizlab.ehr.core.pim.domain.PimPerson pimPerson = pimpersonService.get(pimpersonid);
//    	if(pimPerson == null) {
//    		throw new Exception("EHR系统中不存在该请假人员!");
//    	}
        //温馨提示
        String tips = null;
        //获取上年度和本年度和明年
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int lastyear = calendar.get(java.util.Calendar.YEAR) - 1;
        int curyear = calendar.get(java.util.Calendar.YEAR);
        int nextyear = calendar.get(java.util.Calendar.YEAR) + 1;
        //获取上年度和本年度总天数,假期使用情况
        Double lastsumSyts = 0d;
        Double cursumSyts = 0d;
        String njsy = "";
        //探亲回显信息
        if("TQ".equals(et.getQjzl())) {
            et.setHyzk(pimPerson.getHyzk());
            if("20".equals(pimPerson.getHyzk())) {
                et.setTqlx("20");
            }else {
                et.setTqlx("10");
            }
        }
        //获取温馨提示(用人员信息标识查考勤人员和考勤设置，将考勤设置标识相同的考勤规则标识提取，去查请假提示)
        String sql = "SELECT s.* FROM T_VACLEAVETIPS s WHERE s.vacholidayrulesid in("
                + " SELECT b.vacholidayrulesid FROM T_ATTENDANCESETTINGS a INNER JOIN T_ATTENDENCESETUP b ON a.attendencesetupid=b.attendencesetupid"
                + " WHERE a.pimpersonid=#{et.pimpersonid})";
            Map<String, String> param = new HashMap<>();
            param.put("pimpersonid", pimpersonid);
            List<JSONObject> jsonVacLeaveTipsList = this.select(sql, param);
            if(jsonVacLeaveTipsList.size() > 0) {
                for (JSONObject jsonVacLeaveTips : jsonVacLeaveTipsList) {
                    cn.ibizlab.ehr.core.vac.domain.VacLeaveTips vacLeaveTips =  com.alibaba.fastjson.JSON.toJavaObject(jsonVacLeaveTips, cn.ibizlab.ehr.core.vac.domain.VacLeaveTips.class);
                    if(et.getQjzl().equals(vacLeaveTips.getQjzl())) {
                        tips = vacLeaveTips.getTips();
                    }
                }
            }
            //查询请假种类所表示的请假名称
            String leaveName = vacLeaceTypeService.get(et.getQjzl()).getVacleacetypename();
            //查询该请假人员当前请假种类上年度和本年度情况(用员工信息标识查询上个年度和本年度的计划天数和)
            List<VacLeaveDetail> vacLeaveDetailList = this.selectByPimpersonid(pimpersonid);
            if(vacLeaveDetailList.size() > 0) {
                for (VacLeaveDetail vacLeaveDetail : vacLeaveDetailList) {
                    if(et.getQjzl().equals(vacLeaveDetail.getQjzl()) && !"NX".equals(et.getQjzl())) {
                        int jhkssj = vacLeaveDetail.getJhkssj().getYear() + 1900;
                        if(lastyear == jhkssj && vacLeaveDetail.getJhts() != null) {
                            lastsumSyts += vacLeaveDetail.getJhts();
                        }else if(curyear == jhkssj && vacLeaveDetail.getJhts() != null) {
                            cursumSyts += vacLeaveDetail.getJhts();
                        }
                    }
                }
            }
            njsy +=  lastyear + "年已请" + leaveName + lastsumSyts + " 天;\n "
                    + curyear  + "年已请" + leaveName + cursumSyts  + " 天; ";
            //如果是年休假，拼接年休假使用情况
            if("NX".equals(et.getQjzl())) {
                sql = "select * from T_VACSYNJCX where pimpersonId=#{et.pimpersonId}  and nd in (#{et.curyear},#{et.nextyear}) order by nd ASC";
                param.put("curyear", String.valueOf(curyear));
                param.put("nextyear", String.valueOf(nextyear));
                List<JSONObject> jsonVacSynjcxList = this.select(sql, param);
                if(jsonVacSynjcxList.size() > 0) {
                    for (JSONObject jsonVacSynjcx : jsonVacSynjcxList) {
                        cn.ibizlab.ehr.core.vac.domain.VacSynjcx vacSynjcx =  com.alibaba.fastjson.JSON.toJavaObject(jsonVacSynjcx,cn.ibizlab.ehr.core.vac.domain.VacSynjcx.class);
                        //年度，实休天数，剩余天数，开始有效时间，结束有效时间
                        String nd = vacSynjcx.getNd();
                        String sjbnts = vacSynjcx.getSjbnts().toString();
                        String synjts = vacSynjcx.getSynjts().toString();
                        String ksyxsj = vacSynjcx.getKsyxsj().toString();
                        String jsyxsj = vacSynjcx.getJsyxsj().toString();
                        njsy += nd + "年假:共 " + sjbnts + "天;剩余: " + synjts + "天;有效期: " + ksyxsj + " 至 " + jsyxsj + ";\n";
                    }
                } else {
                    njsy = "暂未查询到您的年假使用情况！！！";
                }
            }
            et.setNjsy(njsy);
            et.setTips(tips);
            //计算计划请假天数
            this.calcPlanDays(et);
            return et;
        }
    @Override
    @Transactional
    public boolean save(VacLeaveDetail et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(VacLeaveDetail et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<VacLeaveDetail> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public VacLeaveDetail get(String key) {
        VacLeaveDetail et = getById(key);
        if(et==null){
            et=new VacLeaveDetail();
            et.setVacleavedetailid(key);
        }
        else{
        }
        return et;
    }

    /**
     * 计算计划请假天数
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacLeaveDetail calcPlanDays(VacLeaveDetail et) {
        //calcplandaysLogic.execute(et);
        if (et.getQjzl().isEmpty() || et.getQjzl() != null) {
            // throw new Exception("请选择请假类型");
        }
        //当计划请假开始时间、计划请假结束时间、请假类型都不为空时，进行计算
        if (et.getJhkssj() != null && et.getJhjssj() != null) {
            //检查假期适用人群
            this.checkAvailablePeople(et);
            //检查请假时间
            this.checkQJSJ(et);
            String qjzl = et.getQjzl();
            //当请假种类为类型中的年休假、事假、其他带薪假时，请假天数不包括法定节假日、公休日（双休日）
            if ("NX".equals(qjzl) || "SJ".equals(qjzl) || "QTDXJ".equals(qjzl)) {
                double qjts = this.calcQJTS(et.getJhkssj(), et.getJhkssxw(), et.getJhjssj(), et.getJhjssxw(), et);
                if (qjts < 0) {
                    qjts = 0;
                }
                //封装进实体，返回给页面回显
                et.setJhts(qjts);
            } else if ("BJ".equals(qjzl) || "GS".equals(qjzl)
                    || "BR".equals(qjzl) || "JS".equals(qjzl)
                    || "CJ".equals(qjzl) || "TQ".equals(qjzl)
                    || "YQ".equals(qjzl)) {//病假、工伤假、哺乳假、计划生育手术假、产假、探亲假、孕期假；请假天数包括法定节假日、公休日（双休日）
                double qjts = (et.getJhjssj().getTime() - et.getJhkssj().getTime()) / (1000 * 60 * 60 * 24);
                //上下午差值计算
                double sxw = 0;
                if (et.getJhkssxw() == null && et.getJhjssxw() == null) {
                    sxw = 1;
                }
                if (et.getJhkssxw() == null && et.getJhjssxw() != null) {
                    if ("10".equals(et.getJhjssxw())) {
                        sxw = 0.5;
                    } else if ("20".equals(et.getJhjssxw())) {
                        sxw = 1;
                    }
                }
                if (et.getJhkssxw() != null && et.getJhjssxw() == null) {
                    if ("10".equals(et.getJhkssxw())) {
                        sxw = 1;
                    } else if ("20".equals(et.getJhkssxw())) {
                        sxw = 0.5;
                    }
                }
                if (et.getJhkssxw() != null && et.getJhjssxw() != null) {
                    if (Integer.parseInt(et.getJhjssxw()) > Integer.parseInt(et.getJhkssxw())) {
                        sxw = 1;
                    } else if (et.getJhkssxw().equals(et.getJhjssxw())) {
                        sxw = 0.5;
                    }
                }
                //计划请假天数为
                qjts += sxw;
                if (qjts < 0) {
                    qjts = 0;
                }
                et.setJhts(qjts);
            } else if ("JH".equals(qjzl) || "PC".equals(qjzl)
                    || "SZ".equals(qjzl) || "TX".equals(qjzl)) {//结婚假、陪产假、丧葬假、调休假；请假天数不包括法定节假日，包括公休日（双休日）
                double qjts = this.calcQJTS2(et.getJhkssj(), et.getJhkssxw(), et.getJhjssj(), et.getJhjssxw(), et);
                if (qjts < 0) {
                    qjts = 0;
                }
                et.setJhts(qjts);
            }
        }
        return et;
    }

    /**
     * 功能名称：计算请假天数，扣掉法定节假日、公休日，增加工作日
     * 功能描述：请假种类为请假类型中的年休假、事假、其他带薪假时
     * 请假天数不包括法定节假日、公休日（双休日）
     */
    private double calcQJTS(java.sql.Timestamp jhkssj, String jhkssxw, java.sql.Timestamp jhjssj, String jhjssxw, VacLeaveDetail et) {
        double qjts = 0;
        //  当前请假人所在考勤规则所属组织
        String ormorgId = null;
        //  根据请假人ID找到他所属组织的考勤日历，根据考勤日历增加或减少天数
        String pimPersonId = et.getPimpersonid();
        StringBuffer sql1 = new StringBuffer();
        sql1.append("SELECT r.ormorgid FROM T_ATTENDANCESETTINGS t LEFT JOIN T_ATTENDENCESETUP p");
        sql1.append(" ON t.ATTENDENCESETUPID=p.ATTENDENCESETUPID");
        sql1.append(" LEFT JOIN T_VACHOLIDAYRULES r");
        sql1.append(" ON p.VACHOLIDAYRULESID=r.VACHOLIDAYRULESID");
	  		sql1.append(" WHERE t.pimpersonid=#{et.pimpersonid}");
        Map<String, String> paramMap = new java.util.concurrent.ConcurrentHashMap<>();
        paramMap.put("pimpersonid", pimPersonId);
        List<JSONObject> jsonList = this.select(sql1.toString(), paramMap);
        //  如果查询到值,则给组织ID赋值
        if (jsonList.size() > 0) {
            String id = com.alibaba.fastjson.JSON.toJavaObject(jsonList.get(0), String.class);
            ormorgId = id;
        } else {
		       ormorgId = "";
            //  throw new Exception("您所属的组织未设置假期规则或未将你加入考勤人员，请联系管理员！");
        }
        //  查询该组织的考勤日历
        StringBuffer sql2 = new StringBuffer();
        sql2.append("SELECT * FROM T_ATTENDENCECALENDAR WHERE enable=1 and rq=#{et.rq} and ormorgid=#{et.ormorgid}");
        //  请假开始时间
        java.util.Calendar begin = new java.util.GregorianCalendar();
        begin.setTime(jhkssj);
        //  请假结束时间
        java.util.Calendar end = new java.util.GregorianCalendar();
        end.setTime(jhjssj);

        //  当请假开始时间不大于请假结束时间时进行计算
        while (begin.getTimeInMillis() <= end.getTimeInMillis()) {
            qjts += 1;
            Map<String, Object> param = new java.util.concurrent.ConcurrentHashMap<>();
            java.sql.Timestamp beginTimetamp = new java.sql.Timestamp(begin.getTimeInMillis());
            //  设置参数
            param.put("rq", beginTimetamp);
            param.put("ormorgid", ormorgId);
            List<JSONObject> jsonObjectList = this.select(sql2.toString(), param);
            if (jsonObjectList.size() > 0) {//   当日在考勤日历内，按照考勤日历的上班/休假进行天数计算
                for (JSONObject jsonObject : jsonObjectList) {
                    cn.ibizlab.ehr.core.att.domain.AttEndenceCalendar attendencecalendar = com.alibaba.fastjson.JSON.toJavaObject(jsonObject, cn.ibizlab.ehr.core.att.domain.AttEndenceCalendar.class);
                    //  考勤日历日期开始
                    java.util.Calendar attendencecalendarBegin = new java.util.GregorianCalendar();
                    attendencecalendarBegin.setTime(attendencecalendar.getRq());
                    //  考勤日历考勤结束
                    java.util.Calendar attendencecalendarEnd = new java.util.GregorianCalendar();
                    attendencecalendarEnd.setTime(attendencecalendar.getRq());

                    if (attendencecalendarBegin.getTimeInMillis() <= begin.getTimeInMillis()
                            && attendencecalendarEnd.getTimeInMillis() >= end.getTimeInMillis()) {
                        if ("20".equals(attendencecalendar.getLx1())) {
                            qjts -= 1;
                        }
                    }
                }// for循环结束
            } else {
                //  周末双休不上班
                if (begin.get(java.util.Calendar .DAY_OF_WEEK) == java.util.Calendar .SATURDAY
                        || begin.get(java.util.Calendar .DAY_OF_WEEK) == java.util.Calendar .SUNDAY) {
                    //  扣除双休日，请假时间-1
                    qjts -= 1;
                } else {//  周一到周五
                    //  请假开始时间在下午并且循环开始时间等于请假开始时间
                    if ("20".equals(jhkssxw) && begin.getTimeInMillis() == jhkssj.getTime()) {
                        qjts -= 0.5;
                    }
                    //  请假结束时间在上午并且循环开始时间等于请假结束时间
                    if ("10".equals(jhjssxw) && begin.getTimeInMillis() == jhjssj.getTime()) {
                        qjts -= 0.5;
                    }
                }
            }
            //  请假开始时间向后推一天，进行下一次循环
            begin.add(java.util.Calendar .DATE, 1);
        }
        return qjts;
    }

    /**
     * 功能名称： 计算请假天数， 扣掉法定节假日，增加公休日、工作日
     * 功能描述： 请假种类为结婚假、陪产假、丧葬假、调休假时
     * 请假天数不包括法定节假日，包括公休日（双休日）
     */
    private double calcQJTS2(java.sql.Timestamp jhkssj, String jhkssxw, java.sql.Timestamp jhjssj, String jhjssxw, VacLeaveDetail et) {
        double qjts = 0;
        //  当前请假人所在考勤规则所属组织
        String ormorgId = null;
        //  根据请假人id找到他所属组织的考勤日历，根据考勤日历增加或减少天数
        String pimPersonId = et.getPimpersonid();
        StringBuffer sql1 = new StringBuffer();
        sql1.append("SELECT r.ormorgid FROM T_ATTENDANCESETTINGS t LEFT JOIN T_ATTENDENCESETUP p");
        sql1.append(" ON t.ATTENDENCESETUPID=p.ATTENDENCESETUPID");
        sql1.append(" LEFT JOIN T_VACHOLIDAYRULES r");
        sql1.append(" ON p.VACHOLIDAYRULESID=r.VACHOLIDAYRULESID");
        sql1.append(" WHERE t.pimpersonid=#{et.pimpersonid}");
        Map<String, String> paramMap = new java.util.concurrent.ConcurrentHashMap<>();
        paramMap.put("pimpersonid", pimPersonId);
        List<JSONObject> jsonList = this.select(sql1.toString(), paramMap);
        //  如果查询到值,则给组织ID赋值
        if (jsonList.size() > 0) {
            String id = com.alibaba.fastjson.JSON.toJavaObject(jsonList.get(0), String.class);
            ormorgId = id;
        } else {
		       ormorgId = "";
            //   throw new Exception("您所属的组织未设置假期规则或未将你加入考勤人员，请联系管理员！");
        }

        //  查询该组织的考勤日历
        StringBuffer sql2 = new StringBuffer();
        sql2.append("SELECT * FROM T_ATTENDENCECALENDAR WHERE enable=1 and rq=#{et.rq} and ormorgid=#{et.ormorgid}");
        //  请假开始时间
        java.util.Calendar begin = new java.util.GregorianCalendar();
        begin.setTime(jhkssj);
        //  请假结束时间
        java.util.Calendar end = new java.util.GregorianCalendar();
        end.setTime(jhjssj);

        //  当请假开始时间不大于请假结束时间时进行计算
        while (begin.getTimeInMillis() <= end.getTimeInMillis()) {
            qjts += 1;
            Map<String, Object> param = new java.util.concurrent.ConcurrentHashMap<>();
            java.sql.Timestamp beginTimetamp = new java.sql.Timestamp(begin.getTimeInMillis());
            //  设置参数
            param.put("rq", beginTimetamp);
            param.put("ormorgid", ormorgId);
            List<JSONObject> jsonObjectList = this.select(sql2.toString(), param);
            if (jsonObjectList.size() > 0) {//   当日在考勤日历内，按照考勤日历的上班/休假进行天数计算
                for (JSONObject jsonObject : jsonObjectList) {
                    cn.ibizlab.ehr.core.att.domain.AttEndenceCalendar attendencecalendar = com.alibaba.fastjson.JSON.toJavaObject(jsonObject, cn.ibizlab.ehr.core.att.domain.AttEndenceCalendar.class);
                    //  考勤日历日期开始
                    java.util.Calendar attendencecalendarBegin = new java.util.GregorianCalendar();
                    attendencecalendarBegin.setTime(attendencecalendar.getRq());
                    //  考勤日历考勤结束
                    java.util.Calendar attendencecalendarEnd = new java.util.GregorianCalendar();
                    attendencecalendarEnd.setTime(attendencecalendar.getRq());

                    if (attendencecalendarBegin.getTimeInMillis() <= begin.getTimeInMillis()
                            && attendencecalendarEnd.getTimeInMillis() >= end.getTimeInMillis()) {
                        //请假时间是休假，20为休假，10位工作
                        if ("20".equals(attendencecalendar.getLx1())) {
                            qjts -= 1;
                        }
                    }
                }//for循环结束
            } else {//  没有结果集，请假时间不在节假日、调休加班日期间
                if ("20".equals(jhkssxw) && begin.getTimeInMillis() == jhkssj.getTime()) {
                    qjts -= 0.5;
                }
                if ("10".equals(jhkssxw) && begin.getTimeInMillis() == jhjssj.getTime()) {
                    qjts -= 0.5;
                }
            }
            //  请假开始时间向后推一天，进行下一次循环
            begin.add(java.util.Calendar .DATE, 1);
        }
        return qjts;
    }

    /**
     * 功能名称：检查请假时间
     * 功能描述：请假开始和结束时间的规范检查
     * @param et
     */
    private void checkQJSJ(VacLeaveDetail et) {
        java.sql.Timestamp kssj = et.getJhkssj();
        java.sql.Timestamp jssj = et.getJhjssj();
        String am = null;
        if (!StringUtils.isEmpty(et.getJhkssxw())) {
            am = et.getJhkssxw();
        }
        String pm = null;
        if (!StringUtils.isEmpty(et.getJhjssxw())) {
            pm = et.getJhjssxw();
        }
        if (et.getSjkssj() != null) {
            kssj = et.getSjkssj();
        }

        if (!StringUtils.isEmpty(et.getSjkssxw())) {
            am = et.getSjkssxw();
        }
        if (et.getSjjssj() != null) {
            kssj = et.getSjjssj();
        }
        if (!StringUtils.isEmpty(et.getSjjssxw())) {
            pm = et.getSjjssxw();
        }

        //  当请假开始时间和请假结束时间为同一天时
        if (kssj.getTime() == jssj.getTime()) {
            if (am != null && pm != null) {
                if (Integer.parseInt(am) > Integer.parseInt(pm)) {
                    // throw new Exception("请假结束时间不能早于请假开始时间！");
                }
            }
        }
        //  请假开始时间和请假结束时间不在同一天
        if (kssj.getTime() > jssj.getTime()) {
            // throw new Exception("请假结束时间不能早于请假开始时间！");
        }

    }

    /**
     * 功能名称：检查假期适用人群
     * 功能描述：判断当前请假人是否满足休假前提条件，
     * 目前有前提条件的有哺乳假、产假、孕期假、陪产假、婚假
     */
    private void checkAvailablePeople(VacLeaveDetail et) {
        //  获取当前请假类型
        String qjzl = et.getQjzl();
        //  获取请假人信息
        String pimPersonId = et.getPimpersonid();

        //  移动端待添加

        cn.ibizlab.ehr.core.pim.domain.PimPerson pimPerson = new cn.ibizlab.ehr.core.pim.domain.PimPerson();
        pimPerson.setPimpersonid(pimPersonId);
        //  判断是否存在此人员
        boolean flag = pimpersonService.checkKey(pimPerson);
        if (!flag) {
            //  throw new Exception("EHR系统中不存在改请假人员！");
        }

        //  哺乳期：女性员工
        if ("BR".equals(qjzl)) {
            if (StringUtils.isEmpty(pimPerson.getXb())) {
                // throw new Exception("该员工性别为空，请尽快与管理员联系！");
            }
            //  1为男性，2为女性
            if ("1".equals(pimPerson.getXb())) {
                //   throw new Exception("哺乳假为女性员工专有！");
            }
        }

        //  产假：女性员工
        if ("CJ".equals(qjzl)) {
            if (StringUtils.isEmpty(pimPerson.getXb())) {
                //  throw new Exception("该员工性别为空，请尽快与管理员联系！");
            }
            if ("1".equals(pimPerson.getXb())) {
                //   throw new Exception("产假为女性员工专有！");
            }
        }
        //  孕期假：女性员工
        if ("YQ".equals(qjzl)) {
            if (StringUtils.isEmpty(pimPerson.getXb())) {
                // throw new Exception("该员工性别为空，请尽快与管理员联系！");
            }
            if ("1".equals(pimPerson.getXb())) {
                //  throw new Exception("孕期假为女性员工专有！");
            }
        }
        //  陪产假：已婚男性员工
        if ("PC".equals(qjzl)) {
            if (StringUtils.isEmpty(pimPerson.getXb())) {
                // throw new Exception("该员工性别为空，请尽快与管理员联系！");
            }
            if (StringUtils.isEmpty(pimPerson.getHyzk())) {
                //  throw new Exception("改员工婚姻状况为空，请尽快与管理员联系！");
            }
            // 20为已婚，10为未婚
            if ("2".equals(pimPerson.getXb()) || "10".equals(pimPerson.getHyzk())) {
                //  throw new Exception("陪产假为已婚男性员工专有！");
            }
        }
        //  婚假：已婚
        if ("JH".equals(qjzl)) {
            if ("10".equals(pimPerson.getHyzk())) {
                //  throw new Exception("婚假为已婚员工专有！");
            }
        }
    }
    @Override
    public boolean checkKey(VacLeaveDetail et) {
        return (!ObjectUtils.isEmpty(et.getVacleavedetailid()))&&(!Objects.isNull(this.getById(et.getVacleavedetailid())));
    }
    @Override
    public VacLeaveDetail getDraft(VacLeaveDetail et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<VacLeaveDetail> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<VacLeaveDetail>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<VacLeaveDetail> searchDefault(VacLeaveDetailSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<VacLeaveDetail> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<VacLeaveDetail>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(VacLeaveDetail et){
        //实体关系[DER1N_VACLEAVEDETAIL_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PimPerson pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PimPerson majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
            et.setOrmorgname(pimperson.getZzdzs());
            et.setOrmorgsectorname(pimperson.getOrmorgsectorname());
        }
    }




    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
    }

    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith("insert")) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("update")) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("delete")) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }

    @Override
    public List<VacLeaveDetail> getVacleavedetailByIds(List<String> ids) {
         return this.listByIds(ids);
    }

    @Override
    public List<VacLeaveDetail> getVacleavedetailByEntities(List<VacLeaveDetail> entities) {
        List ids =new ArrayList();
        for(VacLeaveDetail entity : entities){
            Serializable id=entity.getVacleavedetailid();
            if(!ObjectUtils.isEmpty(id)){
                ids.add(id);
            }
        }
        if(ids.size()>0)
           return this.listByIds(ids);
        else
           return entities;
    }

}



