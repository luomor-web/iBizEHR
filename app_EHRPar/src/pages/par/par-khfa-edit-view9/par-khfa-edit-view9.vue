<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParKhfaEditView9Base from './par-khfa-edit-view9-base.vue';

import view_form from '@widgets/par-khfa/khnr-form/khnr-form.vue';

/**
 * 考核对象
 *
 * @export
 * @class ParKhfaEditView9
 * @extends {ParKhfaEditView9Base}
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
export default class ParKhfaEditView9 extends ParKhfaEditView9Base { }
</script>