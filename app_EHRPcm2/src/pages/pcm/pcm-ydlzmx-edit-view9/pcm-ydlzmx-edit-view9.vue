<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxEditView9Base from './pcm-ydlzmx-edit-view9-base.vue';

import view_form from '@widgets/pcm-ydlzmx/main2-form/main2-form.vue';

/**
 * 离职明细信息
 *
 * @export
 * @class PcmYdlzmxEditView9
 * @extends {PcmYdlzmxEditView9Base}
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
export default class PcmYdlzmxEditView9 extends PcmYdlzmxEditView9Base { }
</script>