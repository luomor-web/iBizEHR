<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalRulePickupViewBase from './sal-rule-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/sal-rule/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 薪酬规则数据选择视图
 *
 * @export
 * @class SalRulePickupView
 * @extends {SalRulePickupViewBase}
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
export default class SalRulePickupView extends SalRulePickupViewBase { }
</script>