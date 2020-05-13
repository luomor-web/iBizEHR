<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORPickupViewBase from './ormorgsectorpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormorgsector/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 部门管理数据选择视图
 *
 * @export
 * @class ORMORGSECTORPickupView
 * @extends {ORMORGSECTORPickupViewBase}
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
export default class ORMORGSECTORPickupView extends ORMORGSECTORPickupViewBase { }
</script>