<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMZPMEGLTreeExpViewBase from './pcmzpmegltree-exp-view-base.vue';

import view_treeexpbar from '@widgets/pcm-zpmegl/tree-exp-viewtreeexpbar-treeexpbar/tree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 招聘名额管理树导航视图
 *
 * @export
 * @class PCMZPMEGLTreeExpView
 * @extends {PCMZPMEGLTreeExpViewBase}
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
export default class PCMZPMEGLTreeExpView extends PCMZPMEGLTreeExpViewBase { }
</script>