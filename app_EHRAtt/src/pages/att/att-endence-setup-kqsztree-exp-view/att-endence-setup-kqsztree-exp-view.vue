<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import AttEndenceSetupKQSZTreeExpViewBase from './att-endence-setup-kqsztree-exp-view-base.vue';

import view_treeexpbar from '@widgets/att-endence-setup/kqsztree-exp-viewtreeexpbar-treeexpbar/kqsztree-exp-viewtreeexpbar-treeexpbar.vue';

/**
 * 考勤设置树导航视图
 *
 * @export
 * @class AttEndenceSetupKQSZTreeExpView
 * @extends {AttEndenceSetupKQSZTreeExpViewBase}
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
export default class AttEndenceSetupKQSZTreeExpView extends AttEndenceSetupKQSZTreeExpViewBase { }
</script>