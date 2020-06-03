<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdtxmxEditViewBase from './pcm-ydtxmx-edit-view-base.vue';

import view_form from '@widgets/pcm-ydtxmx/main-form/main-form.vue';

/**
 * 异动病休明细编辑视图
 *
 * @export
 * @class PcmYdtxmxEditView
 * @extends {PcmYdtxmxEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PcmYdtxmxEditView extends PcmYdtxmxEditViewBase { }
</script>