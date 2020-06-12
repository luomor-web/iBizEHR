<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxEditView2Base from './pcm-ydntmx-edit-view2-base.vue';

import view_form from '@widgets/pcm-ydntmx/main-form/main-form.vue';
import view_drbar from '@widgets/pcm-ydntmx/default-drbar/default-drbar.vue';

/**
 * 异动内退明细编辑视图
 *
 * @export
 * @class PcmYdntmxEditView2
 * @extends {PcmYdntmxEditView2Base}
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
export default class PcmYdntmxEditView2 extends PcmYdntmxEditView2Base { }
</script>