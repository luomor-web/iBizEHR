<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTrainPlantermPickupViewBase from './trm-train-planterm-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-train-planterm/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 培训立项数据选择视图
 *
 * @export
 * @class TrmTrainPlantermPickupView
 * @extends {TrmTrainPlantermPickupViewBase}
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
export default class TrmTrainPlantermPickupView extends TrmTrainPlantermPickupViewBase { }
</script>