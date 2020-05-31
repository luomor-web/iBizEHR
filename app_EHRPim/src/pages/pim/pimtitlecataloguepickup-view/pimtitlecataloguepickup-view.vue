<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLECATALOGUEPickupViewBase from './pimtitlecataloguepickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-title-catalogue/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 职称目录管理数据选择视图
 *
 * @export
 * @class PIMTITLECATALOGUEPickupView
 * @extends {PIMTITLECATALOGUEPickupViewBase}
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
export default class PIMTITLECATALOGUEPickupView extends PIMTITLECATALOGUEPickupViewBase { }
</script>