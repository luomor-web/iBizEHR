<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGXjPickupViewBase from './ormorgxj-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/xj-pickup-viewpickupviewpanel-pickupviewpanel/xj-pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 组织管理数据选择视图
 *
 * @export
 * @class ORMORGXjPickupView
 * @extends {ORMORGXjPickupViewBase}
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
export default class ORMORGXjPickupView extends ORMORGXjPickupViewBase { }
</script>