<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMDETAILRedirectViewBase from './pcmdetailredirect-view-base.vue';


/**
 * 人员明细表数据重定向视图
 *
 * @export
 * @class PCMDETAILRedirectView
 * @extends {PCMDETAILRedirectViewBase}
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
export default class PCMDETAILRedirectView extends PCMDETAILRedirectViewBase { }
</script>