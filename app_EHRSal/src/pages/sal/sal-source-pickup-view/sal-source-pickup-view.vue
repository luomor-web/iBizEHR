<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSourcePickupViewBase from './sal-source-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-source/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 薪酬计算源数据选择视图
 *
 * @export
 * @class SalSourcePickupView
 * @extends {SalSourcePickupViewBase}
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
export default class SalSourcePickupView extends SalSourcePickupViewBase { }
</script>