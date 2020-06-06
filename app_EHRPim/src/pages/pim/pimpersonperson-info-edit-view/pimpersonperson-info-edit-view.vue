<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONPersonInfoEditViewBase from './pimpersonperson-info-edit-view-base.vue';

import view_form from '@widgets/pim-person/ryinfo-form-form/ryinfo-form-form.vue';

/**
 * 员工信息
 *
 * @export
 * @class PIMPERSONPersonInfoEditView
 * @extends {PIMPERSONPersonInfoEditViewBase}
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
export default class PIMPERSONPersonInfoEditView extends PIMPERSONPersonInfoEditViewBase { }
</script>