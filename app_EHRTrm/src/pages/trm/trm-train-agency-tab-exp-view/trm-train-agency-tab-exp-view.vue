<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAgencyTabExpViewBase from './trm-train-agency-tab-exp-view-base.vue';

import view_tabexppanel from '@widgets/trm-train-agency/tab-exp-viewtabexppanel-tabexppanel/tab-exp-viewtabexppanel-tabexppanel.vue';

/**
 * 培训机构相关
 *
 * @export
 * @class TrmTrainAgencyTabExpView
 * @extends {TrmTrainAgencyTabExpViewBase}
 */
@Component({
    components: {
        view_tabexppanel, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class TrmTrainAgencyTabExpView extends TrmTrainAgencyTabExpViewBase { }
</script>