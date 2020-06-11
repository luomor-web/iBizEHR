<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParExamCycleRedirectViewBase from './par-exam-cycle-redirect-view-base.vue';


/**
 * 考核周期数据重定向视图
 *
 * @export
 * @class ParExamCycleRedirectView
 * @extends {ParExamCycleRedirectViewBase}
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
export default class ParExamCycleRedirectView extends ParExamCycleRedirectViewBase { }
</script>