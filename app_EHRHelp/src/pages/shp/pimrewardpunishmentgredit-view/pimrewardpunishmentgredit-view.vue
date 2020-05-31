<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMREWARDPUNISHMENTGREditViewBase from './pimrewardpunishmentgredit-view-base.vue';

import view_form from '@widgets/pim-reward-punishment/main-2-form/main-2-form.vue';

/**
 * 奖励惩罚编辑视图
 *
 * @export
 * @class PIMREWARDPUNISHMENTGREditView
 * @extends {PIMREWARDPUNISHMENTGREditViewBase}
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
export default class PIMREWARDPUNISHMENTGREditView extends PIMREWARDPUNISHMENTGREditViewBase { }
</script>