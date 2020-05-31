<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ARCHIVESMANAGEEditViewBase from './archivesmanageedit-view-base.vue';

import view_form from '@widgets/pim-archives-manage/main-form/main-form.vue';

/**
 * 档案管理编辑视图
 *
 * @export
 * @class ARCHIVESMANAGEEditView
 * @extends {ARCHIVESMANAGEEditViewBase}
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
export default class ARCHIVESMANAGEEditView extends ARCHIVESMANAGEEditViewBase { }
</script>