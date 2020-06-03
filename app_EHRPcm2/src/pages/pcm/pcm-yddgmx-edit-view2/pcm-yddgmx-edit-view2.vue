<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxEditView2Base from './pcm-yddgmx-edit-view2-base.vue';

import view_form from '@widgets/pcm-yddgmx/main-form/main-form.vue';
import view_drbar from '@widgets/pcm-yddgmx/default-drbar/default-drbar.vue';

/**
 * 异动待岗明细编辑视图
 *
 * @export
 * @class PcmYddgmxEditView2
 * @extends {PcmYddgmxEditView2Base}
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
export default class PcmYddgmxEditView2 extends PcmYddgmxEditView2Base { }
</script>