<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceSetupMPickupViewBase from './att-endence-setup-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/att-endence-setup/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 考勤设置数据多项选择视图
 *
 * @export
 * @class AttEndenceSetupMPickupView
 * @extends {AttEndenceSetupMPickupViewBase}
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
export default class AttEndenceSetupMPickupView extends AttEndenceSetupMPickupViewBase { }
</script>