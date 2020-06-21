<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainAgencyPickupViewBase from './trm-train-agency-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-train-agency/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 培训机构数据选择视图
 *
 * @export
 * @class TrmTrainAgencyPickupView
 * @extends {TrmTrainAgencyPickupViewBase}
 */
@Component({
    components: {
        view_pickupviewpanel, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class TrmTrainAgencyPickupView extends TrmTrainAgencyPickupViewBase { }
</script>