<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMRCXLPickupViewBase from './pcmrcxlpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcmrcxl/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';
import view_searchform from '@widgets/pcmrcxl/default-searchform/default-searchform.vue';

/**
 * 人才序列数据选择视图
 *
 * @export
 * @class PCMRCXLPickupView
 * @extends {PCMRCXLPickupViewBase}
 */
@Component({
    components: {
        view_pickupviewpanel, 
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PCMRCXLPickupView extends PCMRCXLPickupViewBase { }
</script>