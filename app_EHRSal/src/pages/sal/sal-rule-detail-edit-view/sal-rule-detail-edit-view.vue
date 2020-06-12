<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalRuleDetailEditViewBase from './sal-rule-detail-edit-view-base.vue';

import view_form from '@widgets/sal-rule-detail/main-form/main-form.vue';

/**
 * 薪酬规则明细编辑视图
 *
 * @export
 * @class SalRuleDetailEditView
 * @extends {SalRuleDetailEditViewBase}
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
export default class SalRuleDetailEditView extends SalRuleDetailEditViewBase { }
</script>