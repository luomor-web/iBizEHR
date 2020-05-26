<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGSECTORMPickupViewBase from './ormorgsectormpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormorgsector/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';
import view_searchform from '@widgets/ormorgsector/default-2-searchform/default-2-searchform.vue';

/**
 * 部门管理数据多项选择视图
 *
 * @export
 * @class ORMORGSECTORMPickupView
 * @extends {ORMORGSECTORMPickupViewBase}
 */
@Component({
    components: {
        view_pickupviewpanel, 
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ORMORGSECTORMPickupView extends ORMORGSECTORMPickupViewBase { }
</script>