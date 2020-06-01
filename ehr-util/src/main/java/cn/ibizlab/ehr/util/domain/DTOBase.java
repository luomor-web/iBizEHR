package cn.ibizlab.ehr.util.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.Data;

@Data
public class DTOBase implements Serializable {


    @JsonIgnore
    @JSONField(serialize = false)
    private Set<String> focusNull;


    public void modify(String field,Object val) {
        if(val==null)
            this.getFocusNull(true).add(field.toLowerCase());
        else
            this.getFocusNull(true).remove(field.toLowerCase());
    }


    public Set<String> getFocusNull() {
        if(focusNull==null)
            focusNull=new HashSet<>();
        if(focusNull.size()>0 && extensionparams.containsKey("dirtyflagenable"))
        {
            Set<String> nocheck=new HashSet<>();
            for(String key:focusNull)
            {
                if(!extensionparams.containsKey(key+"dirtyflag"))
                    nocheck.add(key);
            }
            for(String key:nocheck)
                focusNull.remove(key);
        }
        return focusNull;
    }

    private Set<String> getFocusNull(boolean newflag) {
        if(focusNull==null)
            focusNull=new HashSet<>();
        return focusNull;
    }

    @JsonIgnore
    private Map<String,Object> extensionparams=new HashMap<String,Object>();

    public Map<String, Object> getExtensionparams() {
        return extensionparams;
    }

    public void setExtensionparams(Map<String, Object> extensionparams) {
        this.extensionparams = extensionparams;
    }

    @JsonAnyGetter
    public Map<String , Object> any() {
        return extensionparams;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        extensionparams.put(name.toLowerCase(), value);
    }
}

