<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMQUALMAJORPickupViewBase from './pimqualmajorpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-qual-major/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 执业资格专业数据选择视图
 *
 * @export
 * @class PIMQUALMAJORPickupView
 * @extends {PIMQUALMAJORPickupViewBase}
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
export default class PIMQUALMAJORPickupView extends PIMQUALMAJORPickupViewBase { }
</script>