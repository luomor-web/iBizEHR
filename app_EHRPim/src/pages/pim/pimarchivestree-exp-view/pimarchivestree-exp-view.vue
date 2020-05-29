<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESTreeExpViewBase from './pimarchivestree-exp-view-base.vue';

import view_treeexpbar from '@widgets/pim-archives/tree-exp-viewtreeexpbar-treeexpbar/tree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 档案信息树导航视图
 *
 * @export
 * @class PIMARCHIVESTreeExpView
 * @extends {PIMARCHIVESTreeExpViewBase}
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
export default class PIMARCHIVESTreeExpView extends PIMARCHIVESTreeExpViewBase { }
</script>