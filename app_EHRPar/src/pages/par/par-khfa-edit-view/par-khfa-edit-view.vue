<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParKhfaEditViewBase from './par-khfa-edit-view-base.vue';

import view_form from '@widgets/par-khfa/main-form/main-form.vue';

/**
 * 考核对象
 *
 * @export
 * @class ParKhfaEditView
 * @extends {ParKhfaEditViewBase}
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
export default class ParKhfaEditView extends ParKhfaEditViewBase { }
</script>