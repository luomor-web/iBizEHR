<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocArchivesTreeExpViewBase from './soc-archives-tree-exp-view-base.vue';

import view_treeexpbar from '@widgets/soc-archives/tree-exp-viewtreeexpbar-treeexpbar/tree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 社保档案树导航视图
 *
 * @export
 * @class SocArchivesTreeExpView
 * @extends {SocArchivesTreeExpViewBase}
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
export default class SocArchivesTreeExpView extends SocArchivesTreeExpViewBase { }
</script>