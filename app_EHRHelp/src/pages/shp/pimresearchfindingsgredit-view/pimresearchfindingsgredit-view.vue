<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMRESEARCHFINDINGSGREditViewBase from './pimresearchfindingsgredit-view-base.vue';

import view_form from '@widgets/pim-research-findings/gredit-form-form/gredit-form-form.vue';

/**
 * 科研成果编辑视图
 *
 * @export
 * @class PIMRESEARCHFINDINGSGREditView
 * @extends {PIMRESEARCHFINDINGSGREditViewBase}
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
export default class PIMRESEARCHFINDINGSGREditView extends PIMRESEARCHFINDINGSGREditViewBase { }
</script>