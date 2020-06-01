<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VacLeaveManageWFProxyStartViewBase from './vac-leave-manage-wfproxy-start-view-base.vue';


/**
 * 流程启动
 *
 * @export
 * @class VacLeaveManageWFProxyStartView
 * @extends {VacLeaveManageWFProxyStartViewBase}
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
export default class VacLeaveManageWFProxyStartView extends VacLeaveManageWFProxyStartViewBase { }
</script>