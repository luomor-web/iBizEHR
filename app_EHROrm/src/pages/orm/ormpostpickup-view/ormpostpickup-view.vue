<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPOSTPickupViewBase from './ormpostpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-post/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 岗位管理数据选择视图
 *
 * @export
 * @class ORMPOSTPickupView
 * @extends {ORMPOSTPickupViewBase}
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
export default class ORMPOSTPickupView extends ORMPOSTPickupViewBase { }
</script>