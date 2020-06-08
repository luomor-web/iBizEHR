<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxEditView9Base from './pcm-ydjzmx-edit-view9-base.vue';

import view_form from '@widgets/pcm-ydjzmx/main-form/main-form.vue';

/**
 * 兼职明细信息
 *
 * @export
 * @class PcmYdjzmxEditView9
 * @extends {PcmYdjzmxEditView9Base}
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
export default class PcmYdjzmxEditView9 extends PcmYdjzmxEditView9Base { }
</script>