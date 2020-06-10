<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalParamPickupViewBase from './sal-param-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-param/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 薪酬计算指标数据选择视图
 *
 * @export
 * @class SalParamPickupView
 * @extends {SalParamPickupViewBase}
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
export default class SalParamPickupView extends SalParamPickupViewBase { }
</script>