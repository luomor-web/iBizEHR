<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSchemeMPickupViewBase from './sal-scheme-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-scheme/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 薪酬方案数据多项选择视图
 *
 * @export
 * @class SalSchemeMPickupView
 * @extends {SalSchemeMPickupViewBase}
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
export default class SalSchemeMPickupView extends SalSchemeMPickupViewBase { }
</script>