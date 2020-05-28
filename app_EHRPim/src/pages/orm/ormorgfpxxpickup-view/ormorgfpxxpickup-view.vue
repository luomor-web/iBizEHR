<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGFPXXPickupViewBase from './ormorgfpxxpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/fpxxpickup-viewpickupviewpanel-pickupviewpanel/fpxxpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 组织数据选择视图
 *
 * @export
 * @class ORMORGFPXXPickupView
 * @extends {ORMORGFPXXPickupViewBase}
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
export default class ORMORGFPXXPickupView extends ORMORGFPXXPickupViewBase { }
</script>