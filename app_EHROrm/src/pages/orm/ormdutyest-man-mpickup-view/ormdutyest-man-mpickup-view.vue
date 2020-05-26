<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDUTYEstManMPickupViewBase from './ormdutyest-man-mpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormduty/est-man-mpickup-viewpickupviewpanel-pickupviewpanel/est-man-mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 职务库
 *
 * @export
 * @class ORMDUTYEstManMPickupView
 * @extends {ORMDUTYEstManMPickupViewBase}
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
export default class ORMDUTYEstManMPickupView extends ORMDUTYEstManMPickupViewBase { }
</script>