<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxEditView9Base from './pcm-ydjpmx-edit-view9-base.vue';

import view_form from '@widgets/pcm-ydjpmx/main2-form/main2-form.vue';

/**
 * 解聘明细信息
 *
 * @export
 * @class PcmYdjpmxEditView9
 * @extends {PcmYdjpmxEditView9Base}
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
export default class PcmYdjpmxEditView9 extends PcmYdjpmxEditView9Base { }
</script>