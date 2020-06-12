<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonPickupViewBase from './pim-person-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';
import view_searchform from '@widgets/pim-person/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 人员信息数据选择视图
 *
 * @export
 * @class PimPersonPickupView
 * @extends {PimPersonPickupViewBase}
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
export default class PimPersonPickupView extends PimPersonPickupViewBase { }
</script>