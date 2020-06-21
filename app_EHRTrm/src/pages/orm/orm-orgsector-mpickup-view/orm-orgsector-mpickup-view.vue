<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgsectorMPickupViewBase from './orm-orgsector-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/orm-orgsector/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 部门管理数据多项选择视图
 *
 * @export
 * @class OrmOrgsectorMPickupView
 * @extends {OrmOrgsectorMPickupViewBase}
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
export default class OrmOrgsectorMPickupView extends OrmOrgsectorMPickupViewBase { }
</script>