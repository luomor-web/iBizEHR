<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgJQGZSYFPXXPickupViewBase from './orm-org-jqgzsyfpxxpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-org/jqgzsyfpxxpickup-viewpickupviewpanel-pickupviewpanel/jqgzsyfpxxpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 组织数据选择视图
 *
 * @export
 * @class OrmOrgJQGZSYFPXXPickupView
 * @extends {OrmOrgJQGZSYFPXXPickupViewBase}
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
export default class OrmOrgJQGZSYFPXXPickupView extends OrmOrgJQGZSYFPXXPickupViewBase { }
</script>