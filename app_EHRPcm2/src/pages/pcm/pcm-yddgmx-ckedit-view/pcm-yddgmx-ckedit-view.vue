<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxCKEditViewBase from './pcm-yddgmx-ckedit-view-base.vue';

import view_form from '@widgets/pcm-yddgmx/dgck-form/dgck-form.vue';

/**
 * 异动病休明细
 *
 * @export
 * @class PcmYddgmxCKEditView
 * @extends {PcmYddgmxCKEditViewBase}
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
export default class PcmYddgmxCKEditView extends PcmYddgmxCKEditViewBase { }
</script>