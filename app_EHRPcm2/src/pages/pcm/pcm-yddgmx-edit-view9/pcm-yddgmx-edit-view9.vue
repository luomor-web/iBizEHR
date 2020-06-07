<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxEditView9Base from './pcm-yddgmx-edit-view9-base.vue';

import view_form from '@widgets/pcm-yddgmx/dgck-form/dgck-form.vue';

/**
 * 待岗明细信息
 *
 * @export
 * @class PcmYddgmxEditView9
 * @extends {PcmYddgmxEditView9Base}
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
export default class PcmYddgmxEditView9 extends PcmYddgmxEditView9Base { }
</script>