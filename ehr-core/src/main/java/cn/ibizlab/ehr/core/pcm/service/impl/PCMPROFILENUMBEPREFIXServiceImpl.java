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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILENUMBEPREFIX;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILENUMBEPREFIXSearchContext;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILENUMBEPREFIXService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pcm.mapper.PCMPROFILENUMBEPREFIXMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[应聘者编号前缀] 服务对象接口实现
 */
@Slf4j
@Service("PCMPROFILENUMBEPREFIXServiceImpl")
public class PCMPROFILENUMBEPREFIXServiceImpl extends ServiceImpl<PCMPROFILENUMBEPREFIXMapper, PCMPROFILENUMBEPREFIX> implements IPCMPROFILENUMBEPREFIXService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.orm.service.IORMORGService ormorgService;

    private int batchSize = 500;

    @Override
    @Transactional
    public PCMPROFILENUMBEPREFIX get(String key) {
        PCMPROFILENUMBEPREFIX et = getById(key);
        if(et==null){
            et=new PCMPROFILENUMBEPREFIX();
            et.setPcmprofilenumbeprefixid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(PCMPROFILENUMBEPREFIX et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PCMPROFILENUMBEPREFIX et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public boolean saveBatch(Collection<PCMPROFILENUMBEPREFIX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
        return true;
    }

    @Override
    public void saveBatch(List<PCMPROFILENUMBEPREFIX> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PCMPROFILENUMBEPREFIX et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pcmprofilenumbeprefixid",et.getPcmprofilenumbeprefixid())))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofilenumbeprefixid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PCMPROFILENUMBEPREFIX> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(PCMPROFILENUMBEPREFIX et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPcmprofilenumbeprefixid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PCMPROFILENUMBEPREFIX> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(PCMPROFILENUMBEPREFIX et) {
        return (!ObjectUtils.isEmpty(et.getPcmprofilenumbeprefixid()))&&(!Objects.isNull(this.getById(et.getPcmprofilenumbeprefixid())));
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
    public PCMPROFILENUMBEPREFIX getDraft(PCMPROFILENUMBEPREFIX et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PCMPROFILENUMBEPREFIX> selectByOrmorgid(String orgid) {
        return baseMapper.selectByOrmorgid(orgid);
    }

    @Override
    public void removeByOrmorgid(String orgid) {
        this.remove(new QueryWrapper<PCMPROFILENUMBEPREFIX>().eq("ormorgid",orgid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PCMPROFILENUMBEPREFIX> searchDefault(PCMPROFILENUMBEPREFIXSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PCMPROFILENUMBEPREFIX> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PCMPROFILENUMBEPREFIX>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PCMPROFILENUMBEPREFIX et){
        //实体关系[DER1N_PCMPROFILENUMBEPREFIX_ORMORG_ORMORGID]
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


