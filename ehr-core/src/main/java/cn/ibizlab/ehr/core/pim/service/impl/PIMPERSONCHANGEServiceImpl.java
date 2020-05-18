package cn.ibizlab.ehr.core.pim.service.impl;

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
import cn.ibizlab.ehr.core.pim.domain.PIMPERSONCHANGE;
import cn.ibizlab.ehr.core.pim.filter.PIMPERSONCHANGESearchContext;
import cn.ibizlab.ehr.core.pim.service.IPIMPERSONCHANGEService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.pim.mapper.PIMPERSONCHANGEMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[人员信息变更审核] 服务对象接口实现
 */
@Slf4j
@Service("PIMPERSONCHANGEServiceImpl")
public class PIMPERSONCHANGEServiceImpl extends ServiceImpl<PIMPERSONCHANGEMapper, PIMPERSONCHANGE> implements IPIMPERSONCHANGEService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.pim.service.IPIMPERSONService pimpersonService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean save(PIMPERSONCHANGE et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(PIMPERSONCHANGE et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<PIMPERSONCHANGE> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public PIMPERSONCHANGE bH(PIMPERSONCHANGE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public PIMPERSONCHANGE ensure(PIMPERSONCHANGE et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean update(PIMPERSONCHANGE et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("pimpersonchangeid",et.getPimpersonchangeid())))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonchangeid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<PIMPERSONCHANGE> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public PIMPERSONCHANGE get(String key) {
        PIMPERSONCHANGE et = getById(key);
        if(et==null){
            et=new PIMPERSONCHANGE();
            et.setPimpersonchangeid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean create(PIMPERSONCHANGE et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getPimpersonchangeid()),et);
        return true;
    }

    @Override
    public void createBatch(List<PIMPERSONCHANGE> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
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
    @Transactional
    public PIMPERSONCHANGE qR(PIMPERSONCHANGE et) {
        //自定义代码
        return et;
    }

    @Override
    public boolean checkKey(PIMPERSONCHANGE et) {
        return (!ObjectUtils.isEmpty(et.getPimpersonchangeid()))&&(!Objects.isNull(this.getById(et.getPimpersonchangeid())));
    }

    @Override
    public PIMPERSONCHANGE getDraft(PIMPERSONCHANGE et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<PIMPERSONCHANGE> selectByPimpersonid(String pimpersonid) {
        return baseMapper.selectByPimpersonid(pimpersonid);
    }

    @Override
    public void removeByPimpersonid(String pimpersonid) {
        this.remove(new QueryWrapper<PIMPERSONCHANGE>().eq("pimpersonid",pimpersonid));
    }


    /**
     * 查询集合 历史审批记录
     */
    @Override
    public Page<PIMPERSONCHANGE> searchHistoryRec(PIMPERSONCHANGESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSONCHANGE> pages=baseMapper.searchHistoryRec(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSONCHANGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 PIMCL_NOTAPPROVAL
     */
    @Override
    public Page<PIMPERSONCHANGE> searchPIMCL_NOTAPPROVAL(PIMPERSONCHANGESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSONCHANGE> pages=baseMapper.searchPIMCL_NOTAPPROVAL(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSONCHANGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 总部记录
     */
    @Override
    public Page<PIMPERSONCHANGE> searchHeadRed(PIMPERSONCHANGESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSONCHANGE> pages=baseMapper.searchHeadRed(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSONCHANGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<PIMPERSONCHANGE> searchDefault(PIMPERSONCHANGESearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<PIMPERSONCHANGE> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<PIMPERSONCHANGE>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PIMPERSONCHANGE et){
        //实体关系[DER1N_PIMPERSONCHANGE_PIMPERSON_PIMPERSONID]
        if(!ObjectUtils.isEmpty(et.getPimpersonid())){
            cn.ibizlab.ehr.core.pim.domain.PIMPERSON pimperson=et.getPimperson();
            if(ObjectUtils.isEmpty(pimperson)){
                cn.ibizlab.ehr.core.pim.domain.PIMPERSON majorEntity=pimpersonService.get(et.getPimpersonid());
                et.setPimperson(majorEntity);
                pimperson=majorEntity;
            }
            et.setPimpersonname(pimperson.getPimpersonname());
            et.setOrmorgid(pimperson.getOrmorgid());
            et.setOrmorgsectorid(pimperson.getOrmorgsectorid());
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


