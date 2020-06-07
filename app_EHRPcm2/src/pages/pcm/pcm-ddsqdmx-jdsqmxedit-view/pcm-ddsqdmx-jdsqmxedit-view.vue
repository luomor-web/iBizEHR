<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxJDSQMXEditViewBase from './pcm-ddsqdmx-jdsqmxedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/jdsqmx-form/jdsqmx-form.vue';

/**
 * 借调申请明细
 *
 * @export
 * @class PcmDdsqdmxJDSQMXEditView
 * @extends {PcmDdsqdmxJDSQMXEditViewBase}
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
export default class PcmDdsqdmxJDSQMXEditView extends PcmDdsqdmxJDSQMXEditViewBase { }
</script>