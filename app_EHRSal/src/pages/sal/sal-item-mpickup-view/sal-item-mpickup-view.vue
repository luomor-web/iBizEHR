<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalItemMPickupViewBase from './sal-item-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-item/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 薪酬要素项数据多项选择视图
 *
 * @export
 * @class SalItemMPickupView
 * @extends {SalItemMPickupViewBase}
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
export default class SalItemMPickupView extends SalItemMPickupViewBase { }
</script>