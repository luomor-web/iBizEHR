<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParIntegralRuleEditViewBase from './par-integral-rule-edit-view-base.vue';

import view_form from '@widgets/par-integral-rule/main-form/main-form.vue';

/**
 * 积分规则
 *
 * @export
 * @class ParIntegralRuleEditView
 * @extends {ParIntegralRuleEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ParIntegralRuleEditView extends ParIntegralRuleEditViewBase { }
</script>