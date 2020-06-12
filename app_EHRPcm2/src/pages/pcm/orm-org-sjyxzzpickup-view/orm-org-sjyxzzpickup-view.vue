<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgSJYXZZPickupViewBase from './orm-org-sjyxzzpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/sjyxzzpickup-viewpickupviewpanel-pickupviewpanel/sjyxzzpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 选择组织
 *
 * @export
 * @class OrmOrgSJYXZZPickupView
 * @extends {OrmOrgSJYXZZPickupViewBase}
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
export default class OrmOrgSJYXZZPickupView extends OrmOrgSJYXZZPickupViewBase { }
</script>