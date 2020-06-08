<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxType_GZJEditView3Base from './pcm-ydgzmx-type-gzjedit-view3-base.vue';

import view_drtab from '@widgets/pcm-ydgzmx/default-drtab/default-drtab.vue';
import view_form from '@widgets/pcm-ydgzmx/gzredit-form-form/gzredit-form-form.vue';

/**
 * 异动挂职明细编辑视图(挂职进)
 *
 * @export
 * @class PcmYdgzmxType_GZJEditView3
 * @extends {PcmYdgzmxType_GZJEditView3Base}
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
export default class PcmYdgzmxType_GZJEditView3 extends PcmYdgzmxType_GZJEditView3Base { }
</script>