<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYEditViewBase from './pimexitandentryedit-view-base.vue';

import view_form from '@widgets/pim-exitandentry/ckyjl-form/ckyjl-form.vue';

/**
 * 出（国）境管理编辑视图
 *
 * @export
 * @class PIMEXITANDENTRYEditView
 * @extends {PIMEXITANDENTRYEditViewBase}
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
export default class PIMEXITANDENTRYEditView extends PIMEXITANDENTRYEditViewBase { }
</script>