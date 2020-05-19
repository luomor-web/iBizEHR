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
import cn.ibizlab.ehr.core.common.domain.LoginLog;
import cn.ibizlab.ehr.core.common.filter.LoginLogSearchContext;
import cn.ibizlab.ehr.core.common.service.ILoginLogService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.LoginLogMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[帐户使用记录] 服务对象接口实现
 */
@Slf4j
@Service("LoginLogServiceImpl")
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ILoginAccountService loginaccountService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean create(LoginLog et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getLoginlogid()),et);
        return true;
    }

    @Override
    public void createBatch(List<LoginLog> list) {
        list.forEach(item->fillParentData(item));
        this.saveBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean save(LoginLog et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(LoginLog et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<LoginLog> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    public boolean checkKey(LoginLog et) {
        return (!ObjectUtils.isEmpty(et.getLoginlogid()))&&(!Objects.isNull(this.getById(et.getLoginlogid())));
    }

    @Override
    public LoginLog getDraft(LoginLog et) {
        fillParentData(et);
        return et;
    }

    @Override
    @Transactional
    public LoginLog get(String key) {
        LoginLog et = getById(key);
        if(et==null){
            et=new LoginLog();
            et.setLoginlogid(key);
        }
        else{
        }
        return et;
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
    public boolean update(LoginLog et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("loginlogid",et.getLoginlogid())))
            return false;
        CachedBeanCopier.copy(get(et.getLoginlogid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<LoginLog> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }


	@Override
    public List<LoginLog> selectByLoginaccountid(String loginaccountid) {
        return baseMapper.selectByLoginaccountid(loginaccountid);
    }

    @Override
    public void removeByLoginaccountid(String loginaccountid) {
        this.remove(new QueryWrapper<LoginLog>().eq("loginaccountid",loginaccountid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<LoginLog> searchDefault(LoginLogSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<LoginLog> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<LoginLog>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(LoginLog et){
        //实体关系[DER1N_LOGINLOG_LOGINACCOUNT_LOGINACCOUNTID]
        if(!ObjectUtils.isEmpty(et.getLoginaccountid())){
            cn.ibizlab.ehr.core.common.domain.LoginAccount loginaccount=et.getLoginaccount();
            if(ObjectUtils.isEmpty(loginaccount)){
                cn.ibizlab.ehr.core.common.domain.LoginAccount majorEntity=loginaccountService.get(et.getLoginaccountid());
                et.setLoginaccount(majorEntity);
                loginaccount=majorEntity;
            }
            et.setLoginaccountname(loginaccount.getLoginaccountname());
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


