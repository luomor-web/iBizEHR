<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMLABOURCAMPANYEditViewBase from './pimlabourcampanyedit-view-base.vue';

import view_form from '@widgets/pim-labourcampany/main-form/main-form.vue';

/**
 * 劳务派遣公司编辑视图
 *
 * @export
 * @class PIMLABOURCAMPANYEditView
 * @extends {PIMLABOURCAMPANYEditViewBase}
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
export default class PIMLABOURCAMPANYEditView extends PIMLABOURCAMPANYEditViewBase { }
</script>