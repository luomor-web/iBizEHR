<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxEditView2Base from './pcm-ydjzmx-edit-view2-base.vue';

import view_form from '@widgets/pcm-ydjzmx/main-form/main-form.vue';
import view_drbar from '@widgets/pcm-ydjzmx/default-drbar/default-drbar.vue';

/**
 * 异动兼职明细编辑视图
 *
 * @export
 * @class PcmYdjzmxEditView2
 * @extends {PcmYdjzmxEditView2Base}
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
export default class PcmYdjzmxEditView2 extends PcmYdjzmxEditView2Base { }
</script>