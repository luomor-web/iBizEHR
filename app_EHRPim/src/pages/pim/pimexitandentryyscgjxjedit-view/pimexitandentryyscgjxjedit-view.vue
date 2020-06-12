<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYYSCGJXJEditViewBase from './pimexitandentryyscgjxjedit-view-base.vue';

import view_form from '@widgets/pim-exitandentry/yscgj-form/yscgj-form.vue';

/**
 * 出（国）境基本信息
 *
 * @export
 * @class PIMEXITANDENTRYYSCGJXJEditView
 * @extends {PIMEXITANDENTRYYSCGJXJEditViewBase}
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
export default class PIMEXITANDENTRYYSCGJXJEditView extends PIMEXITANDENTRYYSCGJXJEditViewBase { }
</script>