<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmDemdeftionPickupViewBase from './trm-demdeftion-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/trm-demdeftion/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 需求调查定义数据选择视图
 *
 * @export
 * @class TrmDemdeftionPickupView
 * @extends {TrmDemdeftionPickupViewBase}
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
export default class TrmDemdeftionPickupView extends TrmDemdeftionPickupViewBase { }
</script>