<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzsqEditViewBase from './pcm-xygzzsq-edit-view-base.vue';

import view_form from '@widgets/pcm-xygzzsq/main-form/main-form.vue';

/**
 * 试用期员工转正申请编辑视图
 *
 * @export
 * @class PcmXygzzsqEditView
 * @extends {PcmXygzzsqEditViewBase}
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
export default class PcmXygzzsqEditView extends PcmXygzzsqEditViewBase { }
</script>