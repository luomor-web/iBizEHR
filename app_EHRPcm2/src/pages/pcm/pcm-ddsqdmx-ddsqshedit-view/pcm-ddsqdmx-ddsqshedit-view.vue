<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxDDSQSHEditViewBase from './pcm-ddsqdmx-ddsqshedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/ddgxgzform-form/ddgxgzform-form.vue';

/**
 * 调动
 *
 * @export
 * @class PcmDdsqdmxDDSQSHEditView
 * @extends {PcmDdsqdmxDDSQSHEditViewBase}
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
export default class PcmDdsqdmxDDSQSHEditView extends PcmDdsqdmxDDSQSHEditViewBase { }
</script>