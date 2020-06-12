package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.pim.service.impl.PimSearchFieldSetServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.pim.domain.PimSearchFieldSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[组合查询条件设置] 自定义服务对象
 */
@Slf4j
@Primary
@Service("PimSearchFieldSetServiceEx")
public class PimSearchFieldSetServiceEx extends PimSearchFieldSetServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[InitDictionary]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public PimSearchFieldSet initDictionary(PimSearchFieldSet et) {
        return super.initDictionary(et);
    }
}


