<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYYGCGJXJEditViewBase from './pimexitandentryygcgjxjedit-view-base.vue';

import view_form from '@widgets/pim-exitandentry/ygcgj-form/ygcgj-form.vue';

/**
 * 出（国）境基本信息
 *
 * @export
 * @class PIMEXITANDENTRYYGCGJXJEditView
 * @extends {PIMEXITANDENTRYYGCGJXJEditViewBase}
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
export default class PIMEXITANDENTRYYGCGJXJEditView extends PIMEXITANDENTRYYGCGJXJEditViewBase { }
</script>