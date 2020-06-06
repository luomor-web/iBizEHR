<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESLOANANDRETURNEditViewBase from './pimarchivesloanandreturnedit-view-base.vue';

import view_form from '@widgets/pim-archive-sloanandreturn/main-form/main-form.vue';

/**
 * 档案借阅及归还记录编辑视图
 *
 * @export
 * @class PIMARCHIVESLOANANDRETURNEditView
 * @extends {PIMARCHIVESLOANANDRETURNEditViewBase}
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
export default class PIMARCHIVESLOANANDRETURNEditView extends PIMARCHIVESLOANANDRETURNEditViewBase { }
</script>