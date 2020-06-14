<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParExamCycleMPickupViewBase from './par-exam-cycle-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/par-exam-cycle/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 考核周期数据多项选择视图
 *
 * @export
 * @class ParExamCycleMPickupView
 * @extends {ParExamCycleMPickupViewBase}
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
export default class ParExamCycleMPickupView extends ParExamCycleMPickupViewBase { }
</script>