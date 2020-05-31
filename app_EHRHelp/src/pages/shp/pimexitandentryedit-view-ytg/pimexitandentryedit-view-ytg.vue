<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYEditView_YTGBase from './pimexitandentryedit-view-ytg-base.vue';

import view_form from '@widgets/pim-exitandentry/ytg-form/ytg-form.vue';

/**
 * 出（国）境基本信息
 *
 * @export
 * @class PIMEXITANDENTRYEditView_YTG
 * @extends {PIMEXITANDENTRYEditView_YTGBase}
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
export default class PIMEXITANDENTRYEditView_YTG extends PIMEXITANDENTRYEditView_YTGBase { }
</script>