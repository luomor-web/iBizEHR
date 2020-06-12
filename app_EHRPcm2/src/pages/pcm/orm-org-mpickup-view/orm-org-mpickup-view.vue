<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgMPickupViewBase from './orm-org-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 组织管理数据多项选择视图
 *
 * @export
 * @class OrmOrgMPickupView
 * @extends {OrmOrgMPickupViewBase}
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
export default class OrmOrgMPickupView extends OrmOrgMPickupViewBase { }
</script>