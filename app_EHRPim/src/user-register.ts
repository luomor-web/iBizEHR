import { UserDefaultComponent } from './user-default-register';
import AppOrgPNum from './components/app-org-p-num/app-org-p-num.vue'
import AppOrgVocNumList from './components/app-org-voc-num-list/app-org-voc-num-list.vue'

export const UserComponent = {
    install(v: any, opt: any) {
        UserDefaultComponent.install(v, opt);
        v.component('app-org-p-num', AppOrgPNum);
        v.component('app-org-voc-num-list', AppOrgVocNumList);
        
    }
};