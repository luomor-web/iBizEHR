<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TabExpViewtabexppanelBase from './tab-exp-viewtabexppanel-tabexppanel-base.vue';
import view_tabviewpanel from '@widgets/trm-train-agency/tab-exp-viewtabviewpanel-tabviewpanel/tab-exp-viewtabviewpanel-tabviewpanel.vue';
import view_tabviewpanel2 from '@widgets/trm-train-agency/tab-exp-viewtabviewpanel2-tabviewpanel/tab-exp-viewtabviewpanel2-tabviewpanel.vue';
import view_tabviewpanel3 from '@widgets/trm-train-agency/tab-exp-viewtabviewpanel3-tabviewpanel/tab-exp-viewtabviewpanel3-tabviewpanel.vue';
import view_tabviewpanel4 from '@widgets/trm-train-agency/tab-exp-viewtabviewpanel4-tabviewpanel/tab-exp-viewtabviewpanel4-tabviewpanel.vue';

 
@Component({
    components: {
        view_tabviewpanel, 
        view_tabviewpanel2, 
        view_tabviewpanel3, 
        view_tabviewpanel4, 
         
    }
})
export default class TabExpViewtabexppanel extends TabExpViewtabexppanelBase {

}
</script>