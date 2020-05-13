<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmSignOrgPickupViewBase from './orm-sign-org-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-sign-org/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 法人主体数据选择视图
 *
 * @export
 * @class OrmSignOrgPickupView
 * @extends {OrmSignOrgPickupViewBase}
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
export default class OrmSignOrgPickupView extends OrmSignOrgPickupViewBase { }
</script>