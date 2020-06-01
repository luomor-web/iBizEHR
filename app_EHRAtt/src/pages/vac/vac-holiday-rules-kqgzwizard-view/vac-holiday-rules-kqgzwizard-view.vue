<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacHolidayRulesKQGZWizardViewBase from './vac-holiday-rules-kqgzwizard-view-base.vue';

import view_wizardpanel from '@widgets/vac-holiday-rules/kqgzstxd-wizardpanel/kqgzstxd-wizardpanel.vue';

/**
 * 考勤规则向导
 *
 * @export
 * @class VacHolidayRulesKQGZWizardView
 * @extends {VacHolidayRulesKQGZWizardViewBase}
 */
@Component({
    components: {
        view_wizardpanel, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class VacHolidayRulesKQGZWizardView extends VacHolidayRulesKQGZWizardViewBase { }
</script>