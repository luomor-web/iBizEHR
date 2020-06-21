<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocRuleQuickEditViewBase from './soc-rule-quick-edit-view-base.vue';

import view_form from '@widgets/soc-rule/main2-form/main2-form.vue';

/**
 * 社保规则编辑视图
 *
 * @export
 * @class SocRuleQuickEditView
 * @extends {SocRuleQuickEditViewBase}
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
export default class SocRuleQuickEditView extends SocRuleQuickEditViewBase { }
</script>