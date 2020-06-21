<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainActapplyPickupViewBase from './trm-train-actapply-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-train-actapply/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 培训活动申请数据选择视图
 *
 * @export
 * @class TrmTrainActapplyPickupView
 * @extends {TrmTrainActapplyPickupViewBase}
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
export default class TrmTrainActapplyPickupView extends TrmTrainActapplyPickupViewBase { }
</script>