<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTTreeExpViewBase from './pimcontracttree-exp-view-base.vue';

import view_treeexpbar from '@widgets/pim-contract/tree-exp-viewtreeexpbar-treeexpbar/tree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 合同信息树导航视图
 *
 * @export
 * @class PIMCONTRACTTreeExpView
 * @extends {PIMCONTRACTTreeExpViewBase}
 */
@Component({
    components: {
        view_treeexpbar, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMCONTRACTTreeExpView extends PIMCONTRACTTreeExpViewBase { }
</script>