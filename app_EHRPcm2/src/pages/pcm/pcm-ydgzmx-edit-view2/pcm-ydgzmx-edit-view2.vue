<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxEditView2Base from './pcm-ydgzmx-edit-view2-base.vue';

import view_form from '@widgets/pcm-ydgzmx/main-form/main-form.vue';
import view_drbar from '@widgets/pcm-ydgzmx/default-drbar/default-drbar.vue';

/**
 * 异动挂职明细编辑视图
 *
 * @export
 * @class PcmYdgzmxEditView2
 * @extends {PcmYdgzmxEditView2Base}
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
export default class PcmYdgzmxEditView2 extends PcmYdgzmxEditView2Base { }
</script>