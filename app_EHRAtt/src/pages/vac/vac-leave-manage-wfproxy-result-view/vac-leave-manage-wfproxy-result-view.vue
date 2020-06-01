<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveManageWFProxyResultViewBase from './vac-leave-manage-wfproxy-result-view-base.vue';


/**
 * 请假管理
 *
 * @export
 * @class VacLeaveManageWFProxyResultView
 * @extends {VacLeaveManageWFProxyResultViewBase}
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
export default class VacLeaveManageWFProxyResultView extends VacLeaveManageWFProxyResultViewBase { }
</script>