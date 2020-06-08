<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxEditView2Base from './pcm-ydbxmx-edit-view2-base.vue';

import view_form from '@widgets/pcm-ydbxmx/main-form/main-form.vue';
import view_drbar from '@widgets/pcm-ydbxmx/default-drbar/default-drbar.vue';

/**
 * 异动病休明细编辑视图
 *
 * @export
 * @class PcmYdbxmxEditView2
 * @extends {PcmYdbxmxEditView2Base}
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
export default class PcmYdbxmxEditView2 extends PcmYdbxmxEditView2Base { }
</script>