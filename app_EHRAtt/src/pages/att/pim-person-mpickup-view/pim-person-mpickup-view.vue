<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonMPickupViewBase from './pim-person-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 人员信息数据多项选择视图
 *
 * @export
 * @class PimPersonMPickupView
 * @extends {PimPersonMPickupViewBase}
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
export default class PimPersonMPickupView extends PimPersonMPickupViewBase { }
</script>