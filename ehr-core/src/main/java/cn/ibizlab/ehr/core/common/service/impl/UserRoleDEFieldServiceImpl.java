package cn.ibizlab.ehr.core.common.service.impl;

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
import cn.ibizlab.ehr.core.common.domain.UserRoleDEField;
import cn.ibizlab.ehr.core.common.filter.UserRoleDEFieldSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserRoleDEFieldService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserRoleDEFieldMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户角色实体属性访问] 服务对象接口实现
 */
@Slf4j
@Service("UserRoleDEFieldServiceImpl")
public class UserRoleDEFieldServiceImpl extends ServiceImpl<UserRoleDEFieldMapper, UserRoleDEField> implements IUserRoleDEFieldService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserRoleDEFieldesService userroledefieldesService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.demodel.service.IDataEntityService dataentityService;

    private int batchSize = 500;

    @Override
    public boolean checkKey(UserRoleDEField et) {
        return (!ObjectUtils.isEmpty(et.getUserroledefieldid()))&&(!Objects.isNull(this.getById(et.getUserroledefieldid())));
    }

    @Override
    @Transactional
    public boolean update(UserRoleDEField et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userroledefieldid",et.getUserroledefieldid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledefieldid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserRoleDEField> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(UserRoleDEField et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserroledefieldid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserRoleDEField> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(UserRoleDEField et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserRoleDEField et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserRoleDEField> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
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
    public UserRoleDEField get(String key) {
        UserRoleDEField et = getById(key);
        if(et==null){
            et=new UserRoleDEField();
            et.setUserroledefieldid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public UserRoleDEField getDraft(UserRoleDEField et) {
        fillParentData(et);
        return et;
    }


	@Override
    public List<UserRoleDEField> selectByDeid(String deid) {
        return baseMapper.selectByDeid(deid);
    }

    @Override
    public void removeByDeid(String deid) {
        this.remove(new QueryWrapper<UserRoleDEField>().eq("deid",deid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserRoleDEField> searchDefault(UserRoleDEFieldSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserRoleDEField> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserRoleDEField>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(UserRoleDEField et){
        //实体关系[DER1N_USERROLEDEFIELD_DATAENTITY_DEID]
        if(!ObjectUtils.isEmpty(et.getDeid())){
            cn.ibizlab.ehr.core.demodel.domain.DataEntity de=et.getDe();
            if(ObjectUtils.isEmpty(de)){
                cn.ibizlab.ehr.core.demodel.domain.DataEntity majorEntity=dataentityService.get(et.getDeid());
                et.setDe(majorEntity);
                de=majorEntity;
            }
            et.setDename(de.getDename());
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


