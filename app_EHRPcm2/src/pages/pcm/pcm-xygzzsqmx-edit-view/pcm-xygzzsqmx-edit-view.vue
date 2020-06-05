<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzsqmxEditViewBase from './pcm-xygzzsqmx-edit-view-base.vue';

import view_form from '@widgets/pcm-xygzzsqmx/main-form/main-form.vue';

/**
 * 试用期员工转正申请明细编辑视图
 *
 * @export
 * @class PcmXygzzsqmxEditView
 * @extends {PcmXygzzsqmxEditViewBase}
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
export default class PcmXygzzsqmxEditView extends PcmXygzzsqmxEditViewBase { }
</script>