<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMGXMLGXMLTreeExpViewBase from './pcmgxmlgxmltree-exp-view-base.vue';

import view_treeexpbar from '@widgets/pcm-gxml/gxmltree-exp-viewtreeexpbar-treeexpbar/gxmltree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 高校名录树导航视图
 *
 * @export
 * @class PCMGXMLGXMLTreeExpView
 * @extends {PCMGXMLGXMLTreeExpViewBase}
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
export default class PCMGXMLGXMLTreeExpView extends PCMGXMLGXMLTreeExpViewBase { }
</script>