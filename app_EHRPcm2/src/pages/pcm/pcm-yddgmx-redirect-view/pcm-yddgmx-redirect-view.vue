<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxRedirectViewBase from './pcm-yddgmx-redirect-view-base.vue';


/**
 * 异动待岗明细数据重定向视图
 *
 * @export
 * @class PcmYddgmxRedirectView
 * @extends {PcmYddgmxRedirectViewBase}
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
export default class PcmYddgmxRedirectView extends PcmYddgmxRedirectViewBase { }
</script>