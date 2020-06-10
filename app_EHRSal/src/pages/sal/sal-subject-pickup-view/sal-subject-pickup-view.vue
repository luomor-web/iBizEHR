<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSubjectPickupViewBase from './sal-subject-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-subject/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 财务科目数据选择视图
 *
 * @export
 * @class SalSubjectPickupView
 * @extends {SalSubjectPickupViewBase}
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
export default class SalSubjectPickupView extends SalSubjectPickupViewBase { }
</script>