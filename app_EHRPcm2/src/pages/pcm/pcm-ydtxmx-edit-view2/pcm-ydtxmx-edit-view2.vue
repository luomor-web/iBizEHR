<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdtxmxEditView2Base from './pcm-ydtxmx-edit-view2-base.vue';

import view_form from '@widgets/pcm-ydtxmx/main-form/main-form.vue';
import view_drbar from '@widgets/pcm-ydtxmx/default-drbar/default-drbar.vue';

/**
 * 异动病休明细编辑视图
 *
 * @export
 * @class PcmYdtxmxEditView2
 * @extends {PcmYdtxmxEditView2Base}
 */
@Component({
    components: {
        view_form, 
        view_drbar, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PcmYdtxmxEditView2 extends PcmYdtxmxEditView2Base { }
</script>