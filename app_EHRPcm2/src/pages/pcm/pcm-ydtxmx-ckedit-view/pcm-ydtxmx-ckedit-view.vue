<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdtxmxCKEditViewBase from './pcm-ydtxmx-ckedit-view-base.vue';

import view_form from '@widgets/pcm-ydtxmx/main-form/main-form.vue';

/**
 * 异动退休明细
 *
 * @export
 * @class PcmYdtxmxCKEditView
 * @extends {PcmYdtxmxCKEditViewBase}
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
export default class PcmYdtxmxCKEditView extends PcmYdtxmxCKEditViewBase { }
</script>