<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalItemPickupViewBase from './sal-item-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-item/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 薪酬要素项数据选择视图
 *
 * @export
 * @class SalItemPickupView
 * @extends {SalItemPickupViewBase}
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
export default class SalItemPickupView extends SalItemPickupViewBase { }
</script>