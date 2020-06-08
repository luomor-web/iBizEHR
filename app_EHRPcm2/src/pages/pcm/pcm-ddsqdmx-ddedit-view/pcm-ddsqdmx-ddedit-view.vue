<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxDDEditViewBase from './pcm-ddsqdmx-ddedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/main-form/main-form.vue';

/**
 * 调动
 *
 * @export
 * @class PcmDdsqdmxDDEditView
 * @extends {PcmDdsqdmxDDEditViewBase}
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
export default class PcmDdsqdmxDDEditView extends PcmDdsqdmxDDEditViewBase { }
</script>