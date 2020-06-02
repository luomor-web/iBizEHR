<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonKXZXYGPickupViewBase from './pim-person-kxzxygpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/kxzxygpickup-viewpickupviewpanel-pickupviewpanel/kxzxygpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 试用期员工
 *
 * @export
 * @class PimPersonKXZXYGPickupView
 * @extends {PimPersonKXZXYGPickupViewBase}
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
export default class PimPersonKXZXYGPickupView extends PimPersonKXZXYGPickupViewBase { }
</script>