<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxTYPE_GZCEditView3Base from './pcm-ydgzmx-type-gzcedit-view3-base.vue';

import view_drtab from '@widgets/pcm-ydgzmx/default-drtab/default-drtab.vue';
import view_form from '@widgets/pcm-ydgzmx/gzcedit-form-form/gzcedit-form-form.vue';

/**
 * 异动挂职明细编辑视图(挂职出)
 *
 * @export
 * @class PcmYdgzmxTYPE_GZCEditView3
 * @extends {PcmYdgzmxTYPE_GZCEditView3Base}
 */
@Component({
    components: {
        view_drtab, 
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PcmYdgzmxTYPE_GZCEditView3 extends PcmYdgzmxTYPE_GZCEditView3Base { }
</script>