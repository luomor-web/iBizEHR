<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmXygzzsqRedirectViewBase from './pcm-xygzzsq-redirect-view-base.vue';


/**
 * 试用期员工转正申请数据重定向视图
 *
 * @export
 * @class PcmXygzzsqRedirectView
 * @extends {PcmXygzzsqRedirectViewBase}
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
export default class PcmXygzzsqRedirectView extends PcmXygzzsqRedirectViewBase { }
</script>