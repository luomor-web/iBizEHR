<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGPickupViewBase from './ormorgpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 组织管理数据选择视图
 *
 * @export
 * @class ORMORGPickupView
 * @extends {ORMORGPickupViewBase}
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
export default class ORMORGPickupView extends ORMORGPickupViewBase { }
</script>