<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzsqEditView2Base from './pcm-xygzzsq-edit-view2-base.vue';

import view_form from '@widgets/pcm-xygzzsq/main-form/main-form.vue';
import view_drbar from '@widgets/pcm-xygzzsq/default-drbar/default-drbar.vue';

/**
 * 试用期员工转正申请编辑视图
 *
 * @export
 * @class PcmXygzzsqEditView2
 * @extends {PcmXygzzsqEditView2Base}
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
export default class PcmXygzzsqEditView2 extends PcmXygzzsqEditView2Base { }
</script>