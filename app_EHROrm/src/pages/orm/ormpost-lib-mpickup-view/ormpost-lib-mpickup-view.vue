<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPostLibMPickupViewBase from './ormpost-lib-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormpost-lib/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 标准岗位
 *
 * @export
 * @class ORMPostLibMPickupView
 * @extends {ORMPostLibMPickupViewBase}
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
export default class ORMPostLibMPickupView extends ORMPostLibMPickupViewBase { }
</script>