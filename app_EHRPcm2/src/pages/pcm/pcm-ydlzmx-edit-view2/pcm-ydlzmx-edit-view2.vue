<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxEditView2Base from './pcm-ydlzmx-edit-view2-base.vue';

import view_form from '@widgets/pcm-ydlzmx/main-form/main-form.vue';
import view_drbar from '@widgets/pcm-ydlzmx/default-drbar/default-drbar.vue';

/**
 * 异动离职明细编辑视图
 *
 * @export
 * @class PcmYdlzmxEditView2
 * @extends {PcmYdlzmxEditView2Base}
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
export default class PcmYdlzmxEditView2 extends PcmYdlzmxEditView2Base { }
</script>