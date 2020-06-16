<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmDepartPickupViewBase from './trm-depart-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-depart/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 部门需求填报数据选择视图
 *
 * @export
 * @class TrmDepartPickupView
 * @extends {TrmDepartPickupViewBase}
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
export default class TrmDepartPickupView extends TrmDepartPickupViewBase { }
</script>