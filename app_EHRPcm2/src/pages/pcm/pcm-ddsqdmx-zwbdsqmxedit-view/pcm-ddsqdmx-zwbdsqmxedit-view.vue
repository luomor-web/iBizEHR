<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxZWBDSQMXEditViewBase from './pcm-ddsqdmx-zwbdsqmxedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/zwbdsqmx-form/zwbdsqmx-form.vue';

/**
 * 职务变动申请明细
 *
 * @export
 * @class PcmDdsqdmxZWBDSQMXEditView
 * @extends {PcmDdsqdmxZWBDSQMXEditViewBase}
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
export default class PcmDdsqdmxZWBDSQMXEditView extends PcmDdsqdmxZWBDSQMXEditViewBase { }
</script>