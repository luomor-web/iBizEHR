<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParIntegralRuleEditView9Base from './par-integral-rule-edit-view9-base.vue';

import view_form from '@widgets/par-integral-rule/main2-form/main2-form.vue';

/**
 * 积分规则
 *
 * @export
 * @class ParIntegralRuleEditView9
 * @extends {ParIntegralRuleEditView9Base}
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
export default class ParIntegralRuleEditView9 extends ParIntegralRuleEditView9Base { }
</script>