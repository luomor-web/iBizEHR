<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYEditView_YBHBase from './pimexitandentryedit-view-ybh-base.vue';

import view_form from '@widgets/pim-exitandentry/ybh-form/ybh-form.vue';

/**
 * 出（国）境基本信息
 *
 * @export
 * @class PIMEXITANDENTRYEditView_YBH
 * @extends {PIMEXITANDENTRYEditView_YBHBase}
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
export default class PIMEXITANDENTRYEditView_YBH extends PIMEXITANDENTRYEditView_YBHBase { }
</script>