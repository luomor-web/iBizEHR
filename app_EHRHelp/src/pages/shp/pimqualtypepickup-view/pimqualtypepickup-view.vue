<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMQUALTYPEPickupViewBase from './pimqualtypepickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-qual-type/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 执业资格类别数据选择视图
 *
 * @export
 * @class PIMQUALTYPEPickupView
 * @extends {PIMQUALTYPEPickupViewBase}
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
export default class PIMQUALTYPEPickupView extends PIMQUALTYPEPickupViewBase { }
</script>