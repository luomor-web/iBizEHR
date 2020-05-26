<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDUTYEstManPickupViewBase from './ormdutyest-man-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/ormduty/est-man-pickup-viewpickupviewpanel-pickupviewpanel/est-man-pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 职务库
 *
 * @export
 * @class ORMDUTYEstManPickupView
 * @extends {ORMDUTYEstManPickupViewBase}
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
export default class ORMDUTYEstManPickupView extends ORMDUTYEstManPickupViewBase { }
</script>