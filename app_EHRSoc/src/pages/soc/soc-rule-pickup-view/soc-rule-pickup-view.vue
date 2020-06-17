<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocRulePickupViewBase from './soc-rule-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/soc-rule/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 社保规则数据选择视图
 *
 * @export
 * @class SocRulePickupView
 * @extends {SocRulePickupViewBase}
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
export default class SocRulePickupView extends SocRulePickupViewBase { }
</script>