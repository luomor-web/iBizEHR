<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceSetupEditViewBase from './att-endence-setup-edit-view-base.vue';

import view_form from '@widgets/att-endence-setup/main-form/main-form.vue';

/**
 * 考勤设置编辑视图
 *
 * @export
 * @class AttEndenceSetupEditView
 * @extends {AttEndenceSetupEditViewBase}
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
export default class AttEndenceSetupEditView extends AttEndenceSetupEditViewBase { }
</script>