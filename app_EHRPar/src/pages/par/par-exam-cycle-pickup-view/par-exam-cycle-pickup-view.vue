<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParExamCyclePickupViewBase from './par-exam-cycle-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/par-exam-cycle/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 考核周期数据选择视图
 *
 * @export
 * @class ParExamCyclePickupView
 * @extends {ParExamCyclePickupViewBase}
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
export default class ParExamCyclePickupView extends ParExamCyclePickupViewBase { }
</script>