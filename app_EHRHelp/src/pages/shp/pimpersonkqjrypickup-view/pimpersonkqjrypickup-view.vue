<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONKQJRYPickupViewBase from './pimpersonkqjrypickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/kqjrypickup-viewpickupviewpanel-pickupviewpanel/kqjrypickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 选择请假人员
 *
 * @export
 * @class PIMPERSONKQJRYPickupView
 * @extends {PIMPERSONKQJRYPickupViewBase}
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
export default class PIMPERSONKQJRYPickupView extends PIMPERSONKQJRYPickupViewBase { }
</script>