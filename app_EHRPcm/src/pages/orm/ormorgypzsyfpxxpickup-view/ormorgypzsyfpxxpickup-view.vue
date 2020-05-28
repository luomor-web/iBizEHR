<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGYPZSYFPXXPickupViewBase from './ormorgypzsyfpxxpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/ypzsyfpxxpickup-viewpickupviewpanel-pickupviewpanel/ypzsyfpxxpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 组织数据选择视图
 *
 * @export
 * @class ORMORGYPZSYFPXXPickupView
 * @extends {ORMORGYPZSYFPXXPickupViewBase}
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
export default class ORMORGYPZSYFPXXPickupView extends ORMORGYPZSYFPXXPickupViewBase { }
</script>