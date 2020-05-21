<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmSignOrgBDWPickupViewBase from './orm-sign-org-bdwpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-sign-org/bdwpickup-viewpickupviewpanel-pickupviewpanel/bdwpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 注册单位选择
 *
 * @export
 * @class OrmSignOrgBDWPickupView
 * @extends {OrmSignOrgBDWPickupViewBase}
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
export default class OrmSignOrgBDWPickupView extends OrmSignOrgBDWPickupViewBase { }
</script>