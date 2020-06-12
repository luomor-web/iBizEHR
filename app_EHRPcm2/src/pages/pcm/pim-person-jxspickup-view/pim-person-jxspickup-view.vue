<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonJXSPickupViewBase from './pim-person-jxspickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/jxspickup-viewpickupviewpanel-pickupviewpanel/jxspickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 见习生选择视图
 *
 * @export
 * @class PimPersonJXSPickupView
 * @extends {PimPersonJXSPickupViewBase}
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
export default class PimPersonJXSPickupView extends PimPersonJXSPickupViewBase { }
</script>