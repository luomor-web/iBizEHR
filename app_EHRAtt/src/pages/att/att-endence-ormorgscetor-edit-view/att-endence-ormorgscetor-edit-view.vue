<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceOrmorgscetorEditViewBase from './att-endence-ormorgscetor-edit-view-base.vue';

import view_form from '@widgets/att-endence-ormorgscetor/main-form/main-form.vue';

/**
 * 考勤部门编辑视图
 *
 * @export
 * @class AttEndenceOrmorgscetorEditView
 * @extends {AttEndenceOrmorgscetorEditViewBase}
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
export default class AttEndenceOrmorgscetorEditView extends AttEndenceOrmorgscetorEditViewBase { }
</script>