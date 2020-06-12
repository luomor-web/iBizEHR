<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSchemeItemPickupViewBase from './sal-scheme-item-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-scheme-item/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 方案要素项数据选择视图
 *
 * @export
 * @class SalSchemeItemPickupView
 * @extends {SalSchemeItemPickupViewBase}
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
export default class SalSchemeItemPickupView extends SalSchemeItemPickupViewBase { }
</script>