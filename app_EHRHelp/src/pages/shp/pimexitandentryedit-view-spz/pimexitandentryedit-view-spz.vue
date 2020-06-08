<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYEditView_SPZBase from './pimexitandentryedit-view-spz-base.vue';

import view_form from '@widgets/pim-exitandentry/spz-form/spz-form.vue';

/**
 * 出（国）境基本信息
 *
 * @export
 * @class PIMEXITANDENTRYEditView_SPZ
 * @extends {PIMEXITANDENTRYEditView_SPZBase}
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
export default class PIMEXITANDENTRYEditView_SPZ extends PIMEXITANDENTRYEditView_SPZBase { }
</script>