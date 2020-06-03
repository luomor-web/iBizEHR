<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESCHANGEEditViewBase from './pimarchiveschangeedit-view-base.vue';

import view_form from '@widgets/pim-archives-change/main-form/main-form.vue';

/**
 * 档案归档地变更记录编辑视图
 *
 * @export
 * @class PIMARCHIVESCHANGEEditView
 * @extends {PIMARCHIVESCHANGEEditViewBase}
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
export default class PIMARCHIVESCHANGEEditView extends PIMARCHIVESCHANGEEditViewBase { }
</script>