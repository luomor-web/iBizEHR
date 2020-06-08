<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYEditView_YQXBase from './pimexitandentryedit-view-yqx-base.vue';

import view_form from '@widgets/pim-exitandentry/yqx-form/yqx-form.vue';

/**
 * 出（国）境基本信息
 *
 * @export
 * @class PIMEXITANDENTRYEditView_YQX
 * @extends {PIMEXITANDENTRYEditView_YQXBase}
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
export default class PIMEXITANDENTRYEditView_YQX extends PIMEXITANDENTRYEditView_YQXBase { }
</script>