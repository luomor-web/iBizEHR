<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMREWARDPUNISHMENTEditViewBase from './pimrewardpunishmentedit-view-base.vue';

import view_form from '@widgets/pim-reward-punishment/main-form/main-form.vue';

/**
 * 奖励惩罚编辑视图
 *
 * @export
 * @class PIMREWARDPUNISHMENTEditView
 * @extends {PIMREWARDPUNISHMENTEditViewBase}
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
export default class PIMREWARDPUNISHMENTEditView extends PIMREWARDPUNISHMENTEditViewBase { }
</script>