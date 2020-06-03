<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndanceSettingsEditViewBase from './att-endance-settings-edit-view-base.vue';

import view_form from '@widgets/att-endance-settings/main-form/main-form.vue';

/**
 * 考勤人员
 *
 * @export
 * @class AttEndanceSettingsEditView
 * @extends {AttEndanceSettingsEditViewBase}
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
export default class AttEndanceSettingsEditView extends AttEndanceSettingsEditViewBase { }
</script>