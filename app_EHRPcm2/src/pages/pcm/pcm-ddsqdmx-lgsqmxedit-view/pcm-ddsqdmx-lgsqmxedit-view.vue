<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxLGSQMXEditViewBase from './pcm-ddsqdmx-lgsqmxedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/lgsqmx-form/lgsqmx-form.vue';

/**
 * 轮岗申请明细
 *
 * @export
 * @class PcmDdsqdmxLGSQMXEditView
 * @extends {PcmDdsqdmxLGSQMXEditViewBase}
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
export default class PcmDdsqdmxLGSQMXEditView extends PcmDdsqdmxLGSQMXEditViewBase { }
</script>