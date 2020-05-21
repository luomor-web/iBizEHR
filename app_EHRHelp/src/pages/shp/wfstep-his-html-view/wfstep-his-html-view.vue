<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import WFStepHisHtmlViewBase from './wfstep-his-html-view-base.vue';


/**
 * 工作流步骤HTML视图
 *
 * @export
 * @class WFStepHisHtmlView
 * @extends {WFStepHisHtmlViewBase}
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
export default class WFStepHisHtmlView extends WFStepHisHtmlViewBase { }
</script>