<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalRuleEditViewBase from './sal-rule-edit-view-base.vue';

import view_form from '@widgets/sal-rule/main-form/main-form.vue';

/**
 * 薪酬规则编辑视图
 *
 * @export
 * @class SalRuleEditView
 * @extends {SalRuleEditViewBase}
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
export default class SalRuleEditView extends SalRuleEditViewBase { }
</script>