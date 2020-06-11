<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParKhzcmxPickupViewBase from './par-khzcmx-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/par-khzcmx/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 考核组成明细数据选择视图
 *
 * @export
 * @class ParKhzcmxPickupView
 * @extends {ParKhzcmxPickupViewBase}
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
export default class ParKhzcmxPickupView extends ParKhzcmxPickupViewBase { }
</script>