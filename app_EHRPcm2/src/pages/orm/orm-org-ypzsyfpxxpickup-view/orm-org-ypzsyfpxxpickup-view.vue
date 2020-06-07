<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgYPZSYFPXXPickupViewBase from './orm-org-ypzsyfpxxpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/ypzsyfpxxpickup-viewpickupviewpanel-pickupviewpanel/ypzsyfpxxpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 组织数据选择视图
 *
 * @export
 * @class OrmOrgYPZSYFPXXPickupView
 * @extends {OrmOrgYPZSYFPXXPickupViewBase}
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
export default class OrmOrgYPZSYFPXXPickupView extends OrmOrgYPZSYFPXXPickupViewBase { }
</script>