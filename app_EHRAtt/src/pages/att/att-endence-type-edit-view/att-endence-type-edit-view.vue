<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceTypeEditViewBase from './att-endence-type-edit-view-base.vue';

import view_form from '@widgets/att-endence-type/main-form/main-form.vue';

/**
 * 考勤类型编辑视图
 *
 * @export
 * @class AttEndenceTypeEditView
 * @extends {AttEndenceTypeEditViewBase}
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
export default class AttEndenceTypeEditView extends AttEndenceTypeEditViewBase { }
</script>