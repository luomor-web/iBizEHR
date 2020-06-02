<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxRedirectViewBase from './pcm-ydjzmx-redirect-view-base.vue';


/**
 * 异动兼职明细数据重定向视图
 *
 * @export
 * @class PcmYdjzmxRedirectView
 * @extends {PcmYdjzmxRedirectViewBase}
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
export default class PcmYdjzmxRedirectView extends PcmYdjzmxRedirectViewBase { }
</script>