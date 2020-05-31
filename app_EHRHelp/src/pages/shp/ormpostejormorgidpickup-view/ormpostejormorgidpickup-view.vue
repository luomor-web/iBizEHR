<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPOSTEJORMORGIDPickupViewBase from './ormpostejormorgidpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-post/ejormorgidpickup-viewpickupviewpanel-pickupviewpanel/ejormorgidpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 岗位管理数据选择视图
 *
 * @export
 * @class ORMPOSTEJORMORGIDPickupView
 * @extends {ORMPOSTEJORMORGIDPickupViewBase}
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
export default class ORMPOSTEJORMORGIDPickupView extends ORMPOSTEJORMORGIDPickupViewBase { }
</script>