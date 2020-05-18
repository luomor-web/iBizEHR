package cn.ibizlab.ehr.core.pcm.service.impl;

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
import cn.ibizlab.ehr.core.pcm.domain.PCMNotice;
import cn.ibizlab.ehr.core.pcm.filter.PCMNoticeSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMNoticeService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMNoticeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[提醒消息] 服务对象接口实现
 */
@Slf4j
@Service("PCMNoticeServiceImpl")
public class PCMNoticeServiceImpl extends ServiceImpl<PCMNoticeMapper, PCMNotice> implements IPCMNoticeService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGSECTORService ormorgsectorService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMDISTIRBUTIONService pimdistirbutionService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PCMNotice et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmnoticeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMNotice> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PCMNotice et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmnoticeid",et.getPcmnoticeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmnoticeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMNotice> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(PCMNotice et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMNotice et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PCMNotice> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PCMNotice get(String key) {
        PCMNotice et = getById(key);
        if(et==null){
            et=new PCMNotice();
            et.setPcmnoticeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public PCMNotice getDraft(PCMNotice et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PCMNotice et) {
        return (!ObjectUtils.isEmpty(et.getPcmnoticeid()))&&(!Objects.isNull(this.getById(et.getPcmnoticeid())));
    }

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
    public List<PCMNotice> selectByOrmorgsectorid(String orgsectorid) {
        return baseMapper.selectByOrmorgsectorid(orgsectorid);
    }

    @Override
    public void removeByOrmorgsectorid(String orgsectorid) {
        this.remove(new QueryWrapper<PCMNotice>().eq("ormorgsectorid",orgsectorid));
    }

	@Override
    public List<PCMNotice> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PCMNotice>().eq("ormorgid",orgid));
    }

	@Override
    public List<PCMNotice> selectByPimdistirbutionid(String pimdistirbutionid) {
        return baseMapper.selectByPimdistirbutionid(pimdistirbutionid);
    }

    @Override
    public void removeByPimdistirbutionid(String pimdistirbutionid) {
        this.remove(new QueryWrapper<PCMNotice>().eq("pimdistirbutionid",pimdistirbutionid));
    }

	@Override
    public List<PCMNotice> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PCMNotice>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 档案管理员的提醒
     */
    @Override
    public Page<PCMNotice> searchNOTICE_DAGLYDQ(PCMNoticeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMNotice> pages=baseMapper.searchNOTICE_DAGLYDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMNotice>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 薪酬专员的提醒
     */
    @Override
    public Page<PCMNotice> searchNOTICE_XCZYDQ(PCMNoticeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMNotice> pages=baseMapper.searchNOTICE_XCZYDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMNotice>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 考勤专员的提醒
     */
    @Override
    public Page<PCMNotice> searchNOTICE_KQZYDQ(PCMNoticeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMNotice> pages=baseMapper.searchNOTICE_KQZYDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMNotice>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 人事专员的提醒
     */
    @Override
    public Page<PCMNotice> searchNOTICE_RSZYDQ(PCMNoticeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMNotice> pages=baseMapper.searchNOTICE_RSZYDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMNotice>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMNotice> searchDefault(PCMNoticeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMNotice> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMNotice>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 社保福利专员的提醒
     */
    @Override
    public Page<PCMNotice> searchNOTICE_SBFLZYDQ(PCMNoticeSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMNotice> pages=baseMapper.searchNOTICE_SBFLZYDQ(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMNotice>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMNotice et){
        //实体关系[DER1N_PCMNOTICE_ORMORGSECTOR_ORMORGSECTORID]
        if(!ObjectUtils.isEmpty(et.getOrmorgsectorid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormorgsector=et.getOrmorgsector();
            if(ObjectUtils.isEmpty(ormorgsector)){
                cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR majorEntity=ormorgsectorService.get(et.getOrmorgsectorid());
                et.setOrmorgsector(majorEntity);
                ormorgsector=majorEntity;
            }
            et.setShortname(ormorgsector.getShortname());
            et.setOrmorgsectorname(ormorgsector.getOrgsectorname());
        }
        //实体关系[DER1N_PCMNOTICE_ORMORG_ORMORGID]
        if(!ObjectUtils.isEmpty(et.getOrmorgid())){
            cn.ibizlab.ehr.core.orm.domain.ORMORG ormorg=et.getOrmorg();
            if(ObjectUtils.isEmpty(ormorg)){
                cn.ibizlab.ehr.core.orm.domain.ORMORG majorEntity=ormorgService.get(et.getOrmorgid());
                et.setOrmorg(majorEntity);
                ormorg=majorEntity;
            }
            et.setOrmorgname(ormorg.getOrgname());
            et.setZzdzs(ormorg.getZzdzs());
        }
        //实体关系[DER1N_PCMNOTICE_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setYgbh(pimperson.getYgbh());
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

}


