<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ARCHIVALCATALOGUEPickupViewBase from './archivalcataloguepickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-archival-catalogue/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 档案目录数据选择视图
 *
 * @export
 * @class ARCHIVALCATALOGUEPickupView
 * @extends {ARCHIVALCATALOGUEPickupViewBase}
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
export default class ARCHIVALCATALOGUEPickupView extends ARCHIVALCATALOGUEPickupViewBase { }
</script>