<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESEditViewBase from './pimarchivesedit-view-base.vue';

import view_form from '@widgets/pim-archives/main-form/main-form.vue';

/**
 * 档案信息编辑视图
 *
 * @export
 * @class PIMARCHIVESEditView
 * @extends {PIMARCHIVESEditViewBase}
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
export default class PIMARCHIVESEditView extends PIMARCHIVESEditViewBase { }
</script>