<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgPickupViewBase from './orm-org-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 组织管理数据选择视图
 *
 * @export
 * @class OrmOrgPickupView
 * @extends {OrmOrgPickupViewBase}
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
export default class OrmOrgPickupView extends OrmOrgPickupViewBase { }
</script>