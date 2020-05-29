<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONPersonInfoTreeExpViewBase from './pimpersonperson-info-tree-exp-view-base.vue';

import view_treeexpbar from '@widgets/pim-person/person-info-tree-exp-viewtreeexpbar-treeexpbar/person-info-tree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 人员信息树导航视图
 *
 * @export
 * @class PIMPERSONPersonInfoTreeExpView
 * @extends {PIMPERSONPersonInfoTreeExpViewBase}
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
export default class PIMPERSONPersonInfoTreeExpView extends PIMPERSONPersonInfoTreeExpViewBase { }
</script>