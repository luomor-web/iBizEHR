<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGXMBQPickupViewBase from './ormorgxmbqpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/xmbqpickup-viewpickupviewpanel-pickupviewpanel/xmbqpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 组织数据选择视图
 *
 * @export
 * @class ORMORGXMBQPickupView
 * @extends {ORMORGXMBQPickupViewBase}
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
export default class ORMORGXMBQPickupView extends ORMORGXMBQPickupViewBase { }
</script>