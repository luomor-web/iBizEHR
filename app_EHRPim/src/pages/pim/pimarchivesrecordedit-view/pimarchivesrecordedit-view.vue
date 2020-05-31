<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESRECORDEditViewBase from './pimarchivesrecordedit-view-base.vue';

import view_form from '@widgets/pim-archives-record/main-form/main-form.vue';

/**
 * 档案目录缺失记录编辑视图
 *
 * @export
 * @class PIMARCHIVESRECORDEditView
 * @extends {PIMARCHIVESRECORDEditViewBase}
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
export default class PIMARCHIVESRECORDEditView extends PIMARCHIVESRECORDEditViewBase { }
</script>