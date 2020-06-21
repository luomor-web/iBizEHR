<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocRuleDetailEditViewBase from './soc-rule-detail-edit-view-base.vue';

import view_form from '@widgets/soc-rule-detail/main-form/main-form.vue';

/**
 * 社保规则明细编辑视图
 *
 * @export
 * @class SocRuleDetailEditView
 * @extends {SocRuleDetailEditViewBase}
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
export default class SocRuleDetailEditView extends SocRuleDetailEditViewBase { }
</script>