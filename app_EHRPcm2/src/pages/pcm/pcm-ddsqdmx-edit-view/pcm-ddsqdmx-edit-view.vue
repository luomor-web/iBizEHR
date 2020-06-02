<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxEditViewBase from './pcm-ddsqdmx-edit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/main-form/main-form.vue';

/**
 * 调动申请明细
 *
 * @export
 * @class PcmDdsqdmxEditView
 * @extends {PcmDdsqdmxEditViewBase}
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
export default class PcmDdsqdmxEditView extends PcmDdsqdmxEditViewBase { }
</script>