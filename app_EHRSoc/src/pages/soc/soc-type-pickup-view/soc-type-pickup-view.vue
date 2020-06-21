<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocTypePickupViewBase from './soc-type-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/soc-type/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 保险类型数据选择视图
 *
 * @export
 * @class SocTypePickupView
 * @extends {SocTypePickupViewBase}
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
export default class SocTypePickupView extends SocTypePickupViewBase { }
</script>