<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxRedirectViewBase from './pcm-ydgzmx-redirect-view-base.vue';


/**
 * 异动挂职明细数据重定向视图
 *
 * @export
 * @class PcmYdgzmxRedirectView
 * @extends {PcmYdgzmxRedirectViewBase}
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
export default class PcmYdgzmxRedirectView extends PcmYdgzmxRedirectViewBase { }
</script>