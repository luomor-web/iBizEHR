<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxCKEditViewBase from './pcm-ydntmx-ckedit-view-base.vue';

import view_form from '@widgets/pcm-ydntmx/ntck-form/ntck-form.vue';

/**
 * 异动内退明细
 *
 * @export
 * @class PcmYdntmxCKEditView
 * @extends {PcmYdntmxCKEditViewBase}
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
export default class PcmYdntmxCKEditView extends PcmYdntmxCKEditViewBase { }
</script>