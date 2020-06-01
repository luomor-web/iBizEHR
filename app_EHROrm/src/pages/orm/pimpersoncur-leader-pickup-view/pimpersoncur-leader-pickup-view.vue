<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONCurLeaderPickupViewBase from './pimpersoncur-leader-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/cur-leader-pickup-viewpickupviewpanel-pickupviewpanel/cur-leader-pickup-viewpickupviewpanel-pickupviewpanel.vue';
import view_searchform from '@widgets/pim-person/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 部门负责人选择
 *
 * @export
 * @class PIMPERSONCurLeaderPickupView
 * @extends {PIMPERSONCurLeaderPickupViewBase}
 */
@Component({
    components: {
        view_pickupviewpanel, 
        view_searchform, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMPERSONCurLeaderPickupView extends PIMPERSONCurLeaderPickupViewBase { }
</script>