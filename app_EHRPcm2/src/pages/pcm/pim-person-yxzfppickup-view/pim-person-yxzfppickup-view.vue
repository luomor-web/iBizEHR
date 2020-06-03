<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonYXZFPPickupViewBase from './pim-person-yxzfppickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/yxzfppickup-viewpickupviewpanel-pickupviewpanel/yxzfppickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 员工库
 *
 * @export
 * @class PimPersonYXZFPPickupView
 * @extends {PimPersonYXZFPPickupViewBase}
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
export default class PimPersonYXZFPPickupView extends PimPersonYXZFPPickupViewBase { }
</script>