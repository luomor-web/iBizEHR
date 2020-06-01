<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceSetupKQBYPickupViewBase from './att-endence-setup-kqbypickup-view-base.vue';

import view_pickupviewpanel from '@widgets/att-endence-setup/kqbypickup-viewpickupviewpanel-pickupviewpanel/kqbypickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 考勤设置数据选择视图
 *
 * @export
 * @class AttEndenceSetupKQBYPickupView
 * @extends {AttEndenceSetupKQBYPickupViewBase}
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
export default class AttEndenceSetupKQBYPickupView extends AttEndenceSetupKQBYPickupViewBase { }
</script>