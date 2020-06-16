<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndanceRecordEditViewBase from './att-endance-record-edit-view-base.vue';

import view_form from '@widgets/att-endance-record/main-form/main-form.vue';

/**
 * 考勤记录编辑视图
 *
 * @export
 * @class AttEndanceRecordEditView
 * @extends {AttEndanceRecordEditViewBase}
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
export default class AttEndanceRecordEditView extends AttEndanceRecordEditViewBase { }
</script>