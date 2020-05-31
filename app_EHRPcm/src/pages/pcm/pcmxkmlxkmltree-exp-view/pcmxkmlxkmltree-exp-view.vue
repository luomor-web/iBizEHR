<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMXKMLXKMLTreeExpViewBase from './pcmxkmlxkmltree-exp-view-base.vue';

import view_treeexpbar from '@widgets/pcm-xkml/xkmltree-exp-viewtreeexpbar-treeexpbar/xkmltree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 学科目录树导航视图
 *
 * @export
 * @class PCMXKMLXKMLTreeExpView
 * @extends {PCMXKMLXKMLTreeExpViewBase}
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
export default class PCMXKMLXKMLTreeExpView extends PCMXKMLXKMLTreeExpViewBase { }
</script>