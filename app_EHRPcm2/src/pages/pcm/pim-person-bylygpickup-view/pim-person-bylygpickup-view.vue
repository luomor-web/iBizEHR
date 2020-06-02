<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonBYLYGPickupViewBase from './pim-person-bylygpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/bylygpickup-viewpickupviewpanel-pickupviewpanel/bylygpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * B/Y类员工选择视图
 *
 * @export
 * @class PimPersonBYLYGPickupView
 * @extends {PimPersonBYLYGPickupViewBase}
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
export default class PimPersonBYLYGPickupView extends PimPersonBYLYGPickupViewBase { }
</script>