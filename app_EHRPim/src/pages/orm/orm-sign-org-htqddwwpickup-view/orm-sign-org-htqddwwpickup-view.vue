<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmSignOrgHTQDDWWPickupViewBase from './orm-sign-org-htqddwwpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-sign-org/htqddwwpickup-viewpickupviewpanel-pickupviewpanel/htqddwwpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 合同签订单位选择
 *
 * @export
 * @class OrmSignOrgHTQDDWWPickupView
 * @extends {OrmSignOrgHTQDDWWPickupViewBase}
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
export default class OrmSignOrgHTQDDWWPickupView extends OrmSignOrgHTQDDWWPickupViewBase { }
</script>