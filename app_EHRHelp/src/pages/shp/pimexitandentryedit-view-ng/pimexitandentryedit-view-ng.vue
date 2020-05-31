<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYEditView_NGBase from './pimexitandentryedit-view-ng-base.vue';

import view_form from '@widgets/pim-exitandentry/ng-form/ng-form.vue';

/**
 * 出（国）境基本信息
 *
 * @export
 * @class PIMEXITANDENTRYEditView_NG
 * @extends {PIMEXITANDENTRYEditView_NGBase}
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
export default class PIMEXITANDENTRYEditView_NG extends PIMEXITANDENTRYEditView_NGBase { }
</script>