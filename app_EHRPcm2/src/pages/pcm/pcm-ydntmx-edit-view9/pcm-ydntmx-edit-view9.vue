<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxEditView9Base from './pcm-ydntmx-edit-view9-base.vue';

import view_form from '@widgets/pcm-ydntmx/ntck-form/ntck-form.vue';

/**
 * 内退明细信息
 *
 * @export
 * @class PcmYdntmxEditView9
 * @extends {PcmYdntmxEditView9Base}
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
export default class PcmYdntmxEditView9 extends PcmYdntmxEditView9Base { }
</script>