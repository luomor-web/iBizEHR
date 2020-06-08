<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxDDCKEditViewBase from './pcm-ddsqdmx-ddckedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/ddgxgzform-form/ddgxgzform-form.vue';

/**
 * 异动调动明细
 *
 * @export
 * @class PcmDdsqdmxDDCKEditView
 * @extends {PcmDdsqdmxDDCKEditViewBase}
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
export default class PcmDdsqdmxDDCKEditView extends PcmDdsqdmxDDCKEditViewBase { }
</script>