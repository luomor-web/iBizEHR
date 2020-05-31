<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONZDEditViewBase from './pimpersonzdedit-view-base.vue';

import view_form from '@widgets/pim-person/read-ryinfo-form-form/read-ryinfo-form-form.vue';

/**
 * 员工信息
 *
 * @export
 * @class PIMPERSONZDEditView
 * @extends {PIMPERSONZDEditViewBase}
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
export default class PIMPERSONZDEditView extends PIMPERSONZDEditViewBase { }
</script>