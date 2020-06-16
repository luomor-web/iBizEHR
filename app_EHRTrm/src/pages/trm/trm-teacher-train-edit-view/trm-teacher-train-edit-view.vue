<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmTeacherTrainEditViewBase from './trm-teacher-train-edit-view-base.vue';

import view_form from '@widgets/trm-teacher-train/main-form/main-form.vue';

/**
 * 讲师授课记录编辑视图
 *
 * @export
 * @class TrmTeacherTrainEditView
 * @extends {TrmTeacherTrainEditViewBase}
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
export default class TrmTeacherTrainEditView extends TrmTeacherTrainEditViewBase { }
</script>