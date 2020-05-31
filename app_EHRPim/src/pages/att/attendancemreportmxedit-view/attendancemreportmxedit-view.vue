<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ATTENDANCEMREPORTMXEditViewBase from './attendancemreportmxedit-view-base.vue';

import view_form from '@widgets/att-endance-mreportmx/main-form/main-form.vue';

/**
 * 考勤月报明细
 *
 * @export
 * @class ATTENDANCEMREPORTMXEditView
 * @extends {ATTENDANCEMREPORTMXEditViewBase}
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
export default class ATTENDANCEMREPORTMXEditView extends ATTENDANCEMREPORTMXEditViewBase { }
</script>