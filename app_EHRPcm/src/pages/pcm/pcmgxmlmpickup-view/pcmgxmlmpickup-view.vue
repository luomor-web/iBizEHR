<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMGXMLMPickupViewBase from './pcmgxmlmpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-gxml/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 高校名录数据多项选择视图
 *
 * @export
 * @class PCMGXMLMPickupView
 * @extends {PCMGXMLMPickupViewBase}
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
export default class PCMGXMLMPickupView extends PCMGXMLMPickupViewBase { }
</script>