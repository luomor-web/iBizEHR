<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocRuleDetailPickupViewBase from './soc-rule-detail-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/soc-rule-detail/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 社保规则明细数据选择视图
 *
 * @export
 * @class SocRuleDetailPickupView
 * @extends {SocRuleDetailPickupViewBase}
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
export default class SocRuleDetailPickupView extends SocRuleDetailPickupViewBase { }
</script>