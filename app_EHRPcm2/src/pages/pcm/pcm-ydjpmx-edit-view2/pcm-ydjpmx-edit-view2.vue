<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxEditView2Base from './pcm-ydjpmx-edit-view2-base.vue';

import view_form from '@widgets/pcm-ydjpmx/main-form/main-form.vue';
import view_drbar from '@widgets/pcm-ydjpmx/default-drbar/default-drbar.vue';

/**
 * 异动解聘明细编辑视图
 *
 * @export
 * @class PcmYdjpmxEditView2
 * @extends {PcmYdjpmxEditView2Base}
 */
@Component({
    components: {
        view_form, 
        view_drbar, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PcmYdjpmxEditView2 extends PcmYdjpmxEditView2Base { }
</script>