package cn.ibizlab.ehr.util.domain;

public class EntityClient extends EntityBase {

    @Override
    public void modify(String field,Object val) {
        if(val==null){
            this.getFocusNull().add(field.toLowerCase());
            getExtensionparams().put("dirtyflagenable",true);
            getExtensionparams().put(field.toLowerCase()+"dirtyflag",true);
        }
        else{
            this.getFocusNull().remove(field.toLowerCase());
            getExtensionparams().remove(field.toLowerCase()+"dirtyflag");
        }
    }

}

