<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxJZSQMXEditViewBase from './pcm-ddsqdmx-jzsqmxedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/jzsqmx-form/jzsqmx-form.vue';

/**
 * 兼职申请明细
 *
 * @export
 * @class PcmDdsqdmxJZSQMXEditView
 * @extends {PcmDdsqdmxJZSQMXEditViewBase}
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
export default class PcmDdsqdmxJZSQMXEditView extends PcmDdsqdmxJZSQMXEditViewBase { }
</script>