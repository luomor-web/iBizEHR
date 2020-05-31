<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONPickupViewBase from './pimpersonpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pim-person/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';
import view_searchform from '@widgets/pim-person/ryinfo-search-form-searchform/ryinfo-search-form-searchform.vue';

/**
 * 人员信息数据选择视图
 *
 * @export
 * @class PIMPERSONPickupView
 * @extends {PIMPERSONPickupViewBase}
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
export default class PIMPERSONPickupView extends PIMPERSONPickupViewBase { }
</script>