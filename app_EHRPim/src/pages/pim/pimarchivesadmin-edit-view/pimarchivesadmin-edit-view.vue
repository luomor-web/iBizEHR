<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESAdminEditViewBase from './pimarchivesadmin-edit-view-base.vue';

import view_form from '@widgets/pim-archives/admin-edit-form-2-form/admin-edit-form-2-form.vue';

/**
 * 档案信息编辑视图
 *
 * @export
 * @class PIMARCHIVESAdminEditView
 * @extends {PIMARCHIVESAdminEditViewBase}
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
export default class PIMARCHIVESAdminEditView extends PIMARCHIVESAdminEditViewBase { }
</script>