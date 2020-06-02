<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceSetupPickupViewBase from './att-endence-setup-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/att-endence-setup/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 考勤设置数据选择视图
 *
 * @export
 * @class AttEndenceSetupPickupView
 * @extends {AttEndenceSetupPickupViewBase}
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
export default class AttEndenceSetupPickupView extends AttEndenceSetupPickupViewBase { }
</script>