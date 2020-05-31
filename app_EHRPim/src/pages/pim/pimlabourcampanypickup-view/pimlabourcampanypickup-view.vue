<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMLABOURCAMPANYPickupViewBase from './pimlabourcampanypickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-labourcampany/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 劳务派遣公司管理数据选择视图
 *
 * @export
 * @class PIMLABOURCAMPANYPickupView
 * @extends {PIMLABOURCAMPANYPickupViewBase}
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
export default class PIMLABOURCAMPANYPickupView extends PIMLABOURCAMPANYPickupViewBase { }
</script>