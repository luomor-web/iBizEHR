<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMRESEARCHFINDINGSEditViewBase from './pimresearchfindingsedit-view-base.vue';

import view_form from '@widgets/pim-research-findings/main-form/main-form.vue';

/**
 * 科研成果编辑视图
 *
 * @export
 * @class PIMRESEARCHFINDINGSEditView
 * @extends {PIMRESEARCHFINDINGSEditViewBase}
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
export default class PIMRESEARCHFINDINGSEditView extends PIMRESEARCHFINDINGSEditViewBase { }
</script>