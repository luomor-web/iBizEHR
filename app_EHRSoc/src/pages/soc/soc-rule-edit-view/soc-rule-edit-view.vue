<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocRuleEditViewBase from './soc-rule-edit-view-base.vue';

import view_form from '@widgets/soc-rule/main-form/main-form.vue';

/**
 * 社保规则编辑视图
 *
 * @export
 * @class SocRuleEditView
 * @extends {SocRuleEditViewBase}
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
export default class SocRuleEditView extends SocRuleEditViewBase { }
</script>