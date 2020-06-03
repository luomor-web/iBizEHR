<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxEditViewBase from './pcm-yddgmx-edit-view-base.vue';

import view_form from '@widgets/pcm-yddgmx/main-form/main-form.vue';

/**
 * 异动待岗明细
 *
 * @export
 * @class PcmYddgmxEditView
 * @extends {PcmYddgmxEditViewBase}
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
export default class PcmYddgmxEditView extends PcmYddgmxEditViewBase { }
</script>