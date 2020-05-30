<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMREWARDPUNISHMENTRedirectViewBase from './pimrewardpunishmentredirect-view-base.vue';


/**
 * 奖励惩罚数据重定向视图
 *
 * @export
 * @class PIMREWARDPUNISHMENTRedirectView
 * @extends {PIMREWARDPUNISHMENTRedirectViewBase}
 */
@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMREWARDPUNISHMENTRedirectView extends PIMREWARDPUNISHMENTRedirectViewBase { }
</script>