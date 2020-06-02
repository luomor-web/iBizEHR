<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgSJYXZZQXPickupViewBase from './orm-org-sjyxzzqxpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/sjyxzzqxpickup-viewpickupviewpanel-pickupviewpanel/sjyxzzqxpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 选择组织
 *
 * @export
 * @class OrmOrgSJYXZZQXPickupView
 * @extends {OrmOrgSJYXZZQXPickupViewBase}
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
export default class OrmOrgSJYXZZQXPickupView extends OrmOrgSJYXZZQXPickupViewBase { }
</script>