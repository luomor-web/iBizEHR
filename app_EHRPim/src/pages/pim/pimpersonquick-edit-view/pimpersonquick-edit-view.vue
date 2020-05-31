<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONQuickEditViewBase from './pimpersonquick-edit-view-base.vue';

import view_form from '@widgets/pim-person/quick-edit-form-form/quick-edit-form-form.vue';

/**
 * 人员信息编辑视图
 *
 * @export
 * @class PIMPERSONQuickEditView
 * @extends {PIMPERSONQuickEditViewBase}
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
export default class PIMPERSONQuickEditView extends PIMPERSONQuickEditViewBase { }
</script>