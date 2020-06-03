<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESArchivesRecordEditViewBase from './pimarchivesarchives-record-edit-view-base.vue';

import view_form from '@widgets/pim-archives/main-callout-form/main-callout-form.vue';

/**
 * 调档记录编辑视图
 *
 * @export
 * @class PIMARCHIVESArchivesRecordEditView
 * @extends {PIMARCHIVESArchivesRecordEditViewBase}
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
export default class PIMARCHIVESArchivesRecordEditView extends PIMARCHIVESArchivesRecordEditViewBase { }
</script>