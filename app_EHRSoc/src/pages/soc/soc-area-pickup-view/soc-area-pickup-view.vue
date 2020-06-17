<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocAreaPickupViewBase from './soc-area-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/soc-area/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 参保地数据选择视图
 *
 * @export
 * @class SocAreaPickupView
 * @extends {SocAreaPickupViewBase}
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
export default class SocAreaPickupView extends SocAreaPickupViewBase { }
</script>