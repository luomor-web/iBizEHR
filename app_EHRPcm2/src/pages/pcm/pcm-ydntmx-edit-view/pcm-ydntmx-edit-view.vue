<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxEditViewBase from './pcm-ydntmx-edit-view-base.vue';

import view_form from '@widgets/pcm-ydntmx/main-form/main-form.vue';

/**
 * 异动内退明细
 *
 * @export
 * @class PcmYdntmxEditView
 * @extends {PcmYdntmxEditViewBase}
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
export default class PcmYdntmxEditView extends PcmYdntmxEditViewBase { }
</script>