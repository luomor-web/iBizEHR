<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacHolidayRulesCurOrmorgPickupViewBase from './vac-holiday-rules-cur-ormorg-pickup-view-base.vue';

import view_pickupviewpanel from '@widgets/vac-holiday-rules/cur-ormorg-pickup-viewpickupviewpanel-pickupviewpanel/cur-ormorg-pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 考勤规则
 *
 * @export
 * @class VacHolidayRulesCurOrmorgPickupView
 * @extends {VacHolidayRulesCurOrmorgPickupViewBase}
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
export default class VacHolidayRulesCurOrmorgPickupView extends VacHolidayRulesCurOrmorgPickupViewBase { }
</script>