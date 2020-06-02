package cn.ibizlab.ehr.util.helper;
import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

public class CachedBeanCopier {
    //创建过的BeanCopier实例放到缓存中，下次可以直接获取，提升性能
    static final Map<String, BeanCopier> BEAN_COPIERS = new HashMap<String, BeanCopier>();

    public static void copy(Object srcObj, Object destObj) {
        copy(srcObj,destObj,false);
    }

    public static void copy(Object srcObj, Object destObj,boolean useConverter) {
        if(srcObj==null||destObj==null)
            return;
        getCopier(srcObj,destObj,useConverter).copy(srcObj, destObj, null);
    }

    public synchronized static BeanCopier getCopier(Object srcObj, Object destObj,boolean useConverter) {
        String key = srcObj.getClass().getName()+destObj.getClass().getName()+useConverter;
        BeanCopier copier;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), useConverter);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        return copier;
    }


}
