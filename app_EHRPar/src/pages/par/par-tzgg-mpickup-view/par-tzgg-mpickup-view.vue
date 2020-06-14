<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParTzggMPickupViewBase from './par-tzgg-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/par-tzgg/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 通知公告数据多项选择视图
 *
 * @export
 * @class ParTzggMPickupView
 * @extends {ParTzggMPickupViewBase}
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
export default class ParTzggMPickupView extends ParTzggMPickupViewBase { }
</script>