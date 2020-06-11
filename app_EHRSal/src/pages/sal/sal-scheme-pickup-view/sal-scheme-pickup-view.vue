<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSchemePickupViewBase from './sal-scheme-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-scheme/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 薪酬方案数据选择视图
 *
 * @export
 * @class SalSchemePickupView
 * @extends {SalSchemePickupViewBase}
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
export default class SalSchemePickupView extends SalSchemePickupViewBase { }
</script>