<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLECATALOGUENotPickupViewBase from './pimtitlecataloguenot-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-title-catalogue/not-pickup-viewpickupviewpanel-pickupviewpanel/not-pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 职称目录管理数据选择视图
 *
 * @export
 * @class PIMTITLECATALOGUENotPickupView
 * @extends {PIMTITLECATALOGUENotPickupViewBase}
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
export default class PIMTITLECATALOGUENotPickupView extends PIMTITLECATALOGUENotPickupViewBase { }
</script>